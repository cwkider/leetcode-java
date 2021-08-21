package y2021.w0803.p08;

import java.util.ArrayList;

public class Solution {
    int[][] crow;
    int[][] ccol;
    int[][] csub;
    ArrayList<Integer[]> points;

    public void solveSudoku(char[][] board) {
        crow = new int[9][9];
        ccol = new int[9][9];
        csub = new int[9][9];

        points = new ArrayList<Integer[]>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    Integer[] pos = new Integer[2];
                    pos[0] = new Integer(i);
                    pos[1] = new Integer(j);
                    points.add(pos);
                } else {
                    int val = board[i][j] - '0' - 1;
                    crow[i][val] = 1;
                    ccol[j][val] = 1;
                    int sidx = (i / 3) * 3 + (j / 3);
                    csub[sidx][val] = 1;
                }
            }
        }

        checkPosition(0, board);
    }

    boolean checkPosition(int idx, char[][] board) {
        int sz = points.size();
        int i = points.get(idx)[0];
        int j = points.get(idx)[1];
        int sidx = (i / 3) * 3 + (j / 3);
        if (idx == sz - 1) {
            for (int v = 1; v <= 9; ++v) {
                int val = v - 1;
                if (checkPossible(i, j, val)) {
                    board[i][j] = (char)(v + '0');
                    return true;
                }
                crow[i][val] -= 1;
                ccol[j][val] -= 1;
                csub[sidx][val] -= 1;
            }
            return false;
        }
        boolean ret = false;

        for (int v = 1; v <= 9; ++v) {
            int val = v - 1;
            if (checkPossible(i, j, val)) {
                ret = checkPosition(idx + 1, board);
                if (ret) {
                    board[i][j] = (char)(v + '0');
                    break;
                }
                crow[i][val] -= 1;
                ccol[j][val] -= 1;
                csub[sidx][val] -= 1;
            }
        }

        return ret;
    }

    boolean checkPossible(int i, int j, int val) {
        boolean ret = true;

        if (crow[i][val] >= 1) return false;
        if (ccol[j][val] >= 1) return false;
        int sidx = (i / 3) * 3 + (j / 3);
        if (csub[sidx][val] >= 1) return false;

        crow[i][val] += 1;
        ccol[j][val] += 1;
        csub[sidx][val] += 1;

        return ret;
    }

    public static void main(String[] args) {
        Solution st = new Solution();

        char[][] board01 = { {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'} };
        //Output: [["5","3","4","6","7","8","9","1","2"]
        // ,["6","7","2","1","9","5","3","4","8"]
        // ,["1","9","8","3","4","2","5","6","7"]
        // ,["8","5","9","7","6","1","4","2","3"]
        // ,["4","2","6","8","5","3","7","9","1"]
        // ,["7","1","3","9","2","4","8","5","6"]
        // ,["9","6","1","5","3","7","2","8","4"]
        // ,["2","8","7","4","1","9","6","3","5"]
        // ,["3","4","5","2","8","6","1","7","9"]]
        st.solveSudoku(board01);
        for(int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j)
                System.out.print(board01[i][j] + " ");
            System.out.println();
        }
        System.out.println("---------------------------------");
    }
}
