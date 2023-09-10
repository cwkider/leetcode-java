package problems.leetpr00010;

public class Solution {
    public static void main(String[] args) {
        Solution st = new Solution();

        String s, p;
        int i = 1;
        s = "aa";
        p = "a";
        System.out.println("1 | false | ==================================");
        System.out.println(st.isMatch(s, p));

        s = "aa";
        p = "a*";
        System.out.println("2 | true | ==================================");
        System.out.println(st.isMatch(s, p));

        s = "aa";
        p = ".*";
        System.out.println("3 | true | ==================================");
        System.out.println(st.isMatch(s, p));


        s = "aab";
        p = ".*";
        System.out.println("4 | true | ==================================");
        System.out.println(st.isMatch(s, p));

        s = "aab";
        p = ".*a";
        System.out.println("5 | false | ==================================");
        System.out.println(st.isMatch(s, p));

        s = "aab";
        p = "c*a*b";
        System.out.println("6 | true | ==================================");
        System.out.println(st.isMatch(s, p));

        s = "aaa";
        p = "ab*a*c*a";
        System.out.println("7 | true | ==================================");
        System.out.println(st.isMatch(s, p));

        s = "a";
        p = "ab*";
        System.out.println("8 | true | ==================================");
        System.out.println(st.isMatch(s, p));

        s = "bbbba";
        p = ".*a*a";
        System.out.println("9 | true | ==================================");
        System.out.println(st.isMatch(s, p));

        s = "a";
        p = ".*..a*";
        System.out.println("10 | false | ==================================");
        System.out.println(st.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int[][] matchYn = new int[20][20];

        return recursiveMatch(s, 0, p, 0, matchYn);
    }

    private boolean recursiveMatch(String s, int sidx, String p, int pidx, int[][] matchYn) {
//        System.out.println("sidx : " + sidx + " | pidx : " + pidx);
        if (sidx == s.length()) {
            if (pidx == p.length()) return true;
            else {
                int plng = p.length() - pidx;
                if (plng % 2 == 0) {
                    for (int i = pidx+1; i < p.length(); i=i+2) {
                        if (p.charAt(i) != '*') return false;
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }

        if (pidx == p.length()) {
            if (sidx < s.length()) return false;
            else return true;
        }

        if (matchYn[sidx][pidx] == -1) return false;

        if (pidx < p.length()-1 && p.charAt(pidx+1) == '*') {
            if (recursiveMatch(s, sidx, p, pidx + 2, matchYn)) return true;
            for (int i = sidx; i < s.length(); ++i) {
                if (s.charAt(i) == p.charAt(pidx) || p.charAt(pidx) == '.') {
                    if(recursiveMatch(s, i + 1, p, pidx + 2, matchYn)) return true;
                } else {
                    break;
                }
            }
        } else if (p.charAt(pidx) == '.' || p.charAt(pidx) == s.charAt(sidx)) {
            if(recursiveMatch(s, sidx + 1, p, pidx + 1, matchYn)) return true;
        }

        return false;
    }
}
