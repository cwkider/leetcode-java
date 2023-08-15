package problems.leetpr00006;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public java.lang.String convert(String s, int numRows) {
        StringBuilder ret = new StringBuilder("");
        CharOfS[] arrObj = new CharOfS[s.length()];

        int idx = 1;
        int num = 1;
        for(int i = 0; i < s.length(); ++i) {
            arrObj[i] = new CharOfS();
            arrObj[i].idx = idx;
            arrObj[i].ch = s.charAt(i);

            if(numRows == 1) num = 0;
            else if(idx == 1) num = 1;
            else if(idx == numRows) num = -1;
            idx = idx + num;
        }

        Arrays.sort(arrObj, new Comparator<CharOfS>() {
            @Override
            public int compare(CharOfS c1, CharOfS c2) {
                return Integer.compare(c1.idx, c2.idx);
            }
        });

        for(int i = 0; i < s.length(); ++i) {
//            System.out.println("idx : " + arrObj[i].idx + " | ch : " + arrObj[i].ch);
            ret.append(arrObj[i].ch);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Solution st = new Solution();
        String s;
        int numRows;

        s = "PAYPALISHIRING";
        numRows = 3;
        //Output : "PAHNAPLSIIGYIR"
        //          PAHNAPLSIIGYIR
        System.out.println(st.convert(s, numRows));
        System.out.println("===================================");

        s = "PAYPALISHIRING";
        numRows = 4;
        //Output : "PINALSIGYAHRPI"
        //          PINALSIGYAHRPI
        System.out.println(st.convert(s, numRows));
        System.out.println("===================================");

        s = "A";
        numRows = 1;
        //Output : "A"
        //          A
        System.out.println(st.convert(s, numRows));
        System.out.println("===================================");

        s = "AB";
        numRows = 1;
        //Output : "AB"
        //          A
        System.out.println(st.convert(s, numRows));
        System.out.println("===================================");

        s = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        numRows = 1;
        //Output : "A"
        //          A
        System.out.println(st.convert(s, numRows));
        System.out.println("===================================");
    }

    static class CharOfS{
        int idx;
        char ch;
    }
}
