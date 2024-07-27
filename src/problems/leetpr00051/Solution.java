package problems.leetpr00051;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n;
        List<List<String>> ret;
        Solution st = new Solution();

        n = 4;
        ret = st.solveNQueens(n);

        for(int i = 0; i < ret.size(); ++i) {
//            List<String> lst = ret.get(i);
//            for (int j = 0; j < lst.size(); ++j) {
//
//            }
            System.out.println(ret.get(i).toString());
        }

        n = 5;
        ret = st.solveNQueens(n);

        for(int i = 0; i < ret.size(); ++i) {
            System.out.println(ret.get(i).toString());
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<List<String>>();
        int[][] puzzle = new int[n][n];

        List<String> cand = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            String srow = "";
            for (int j = 0; j < n; ++j) {
                if (j == i) srow += "Q";
                else srow += ".";
            }
            cand.add(srow);
            markPossibleYn(puzzle, 0, i, n, -1);
            getNQueens(puzzle, ret, cand, 1, n);
            markPossibleYn(puzzle, 0, i, n, 1);
            cand.remove(0);
        }

        return ret;
    }

    public void getNQueens(int[][] puzzle, List<List<String>> ret, List<String> cand, int y, int n) {
        if (y == n) {
            List<String> ok = new ArrayList<String>(cand);
            ret.add(ok);
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (puzzle[y][i] == 0) {
                String srow = "";
                for (int j = 0; j < n; ++j) {
                    if (j == i) srow += "Q";
                    else srow += ".";
                }
                cand.add(srow);
                markPossibleYn(puzzle, y, i, n, -1);
                getNQueens(puzzle, ret, cand, y + 1, n);
                cand.remove(y);
                markPossibleYn(puzzle, y, i, n, 1);
            }
        }
    }

    public void markPossibleYn(int[][] puzzle, int y, int x, int n, int pos) {
        for (int i = y+1; i < n; ++i) {
            int gap = i - y;
            if(x - gap >= 0) {
                puzzle[i][x-gap] += pos;
            }
            if(x + gap < n) {
                puzzle[i][x+gap] += pos;
            }
            puzzle[i][x] += pos;
        }
    }
}
