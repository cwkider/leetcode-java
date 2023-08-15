package problems.leetpr00008;

public class Solution {
    public int myAtoi(String s) {
        int ret = 0;

        boolean numYn = false;
        boolean signYn = false;
        boolean numStart = false;
        int mnum = 1;
        int lng = 0;
        int[] arrNums = new int[200];
        for(int i = 0; i < s.length(); ++i) {
            char at = s.charAt(i);
            if(at >= '0' && at <= '9') {
                numYn = true;
                if(!numStart && at != '0') numStart = true;
                if(numStart) {
                    arrNums[lng] = at - '0';
                    lng++;
                }
            } else if(at == '+' || at == '-') {
                if(numYn) break;
                if(signYn) break;
                signYn = true;
                if(at == '-') mnum = -1;
            }
            else if(at == ' ') {
                if (!numYn && !signYn) continue;
                else break;
            }
            else break;
        }

        int posMax = (int) (Math.round(Math.pow(2, 31)) - 1);
        int negMax = (int)Math.pow(-2, 31);
        int posCheck = posMax - 2000000000;
        int negCheck = negMax + 2000000000;
//        System.out.println("posMax : " + posMax + " | negMax : " + negMax);
//        System.out.println("posCheck : " + posCheck + " | negCheck : " + negCheck);

        if(lng >= 11) {
            if(mnum == 1) ret = posMax;
            else ret = negMax;

            return ret;
        }

        int tens = 1;
        for(int i = 0; i< lng; ++i) {
            int idx = lng - i - 1;
            if(i == 9) {
                if(arrNums[idx] >= 3) {
                    if(mnum == 1) ret = posMax;
                    else ret = negMax;

                    break;
                } else if(arrNums[idx] == 2) {
//                    System.out.println("1.ret : " + ret );
                    if(ret > posCheck || ret < negCheck) {
                        if (mnum == 1) ret = posMax;
                        else ret = negMax;

                        break;
                    }
//                    System.out.println("2.ret : " + ret );
                }
            }

            ret = ret + (arrNums[idx] * mnum * tens);
//            System.out.println("i : " + i + " | idx : " + idx + " | arrNums[idx] : " + arrNums[idx] + " | ret : " + ret );
            if(i <= 8) tens *= 10;
            else break;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution st = new Solution();
        String s;

//        s = "42";
//        //Output : 42
//        System.out.println(st.myAtoi(s));
//        System.out.println("==============================================");
//
//        s = "4209a";
//        //Output : 4209
//        System.out.println(st.myAtoi(s));
//        System.out.println("==============================================");
//
//        s = "   -42";
//        //Output : -42
//        System.out.println(st.myAtoi(s));
//        System.out.println("==============================================");
//
//        s = "4193 with words";
//        //Output : 4193
//        System.out.println(st.myAtoi(s));
//        System.out.println("==============================================");
//
//        s = "-91283472332";
//        //Output : -2147483648
//        System.out.println(st.myAtoi(s));
//        System.out.println("==============================================");
//
//        s = "  0000000000012345678";
//        //Output : 2147483647
//        System.out.println(st.myAtoi(s));
//        System.out.println("==============================================");
//
//        s = "2147483646";
//        //Output : 2147483646
//        System.out.println(st.myAtoi(s));
//        System.out.println("==============================================");

        s = "2147483648";
        //Output : 2147483647
        System.out.println(st.myAtoi(s));
        System.out.println("==============================================");

        // TEST
        //        int temp = (int)Math.pow(2, 3);
//        System.out.println("temp : " + temp);
    }
}
