/**
  * @FileName : Solution.java
  * @Date : 2021. 8. 14. 
  * @Problem Title : 
 */
package y2021.w0802.p07;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cwkider
 *
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
//        int matrix.length = matrix.length;
//        int matrix[0].length = matrix[0].length;
//        int[] carr = new int[matrix.length];
//        int[] rarr = new int[matrix[0].length];
        int rzero = 1;
        int czero = 1;
        
        for(int i = 0; i < matrix.length; ++i) {
        	for(int j = 0; j < matrix[0].length; ++j) {
        		if(matrix[i][j] == 0) {
//        			System.out.println(i + ", " + j + "is 0 !!!!!");
        			if(i != 0 && j != 0) {
	        			matrix[i][0] = 0;
	        			matrix[0][j] = 0;
        			} else {
        				if(i == 0 && j == 0) {
        					rzero = 0;
        					czero = 0;
        				} else if(i != 0) {
        					czero = 0;
        				} else {
        					rzero = 0;
        				}
        			}
        		}
        	}
        }
        
        for(int i = 1; i < matrix.length; ++i) 
        	if(matrix[i][0] == 0) 
        		for(int j = 0; j < matrix[0].length; ++j) {
//        			System.out.println("2] " + i + ", " + j + "is 0 !!!!!");
        			matrix[i][j] = 0;
        		}
        
        for(int i = 1; i < matrix[0].length; ++i) 
        	if(matrix[0][i] == 0) 
        		for(int j = 0; j < matrix.length; ++j) {
//        			System.out.println("3] " + i + ", " + j + "is 0 !!!!!");
        			matrix[j][i] = 0;
        		}
        
        if(rzero == 0)
        	for(int i = 0; i < matrix[0].length; ++i) 
        		matrix[0][i] = 0;
        	
        if(czero == 0)
        	for(int i = 0; i < matrix.length; ++i)
        		matrix[i][0] = 0;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution st = new Solution();
		int clng, rlng;
		
		int[][] matrix01 = {{1,1,1},{1,0,1},{1,1,1}};
		st.setZeroes(matrix01);
		rlng = matrix01.length;
		clng = matrix01[0].length;
		System.out.print("{");
		for(int i = 0; i < rlng; ++i) {
			System.out.print(" {");
			for(int j = 0; j < clng; ++j) 
				System.out.print(matrix01[i][j] + ",");
			System.out.print("}, ");
		}
		System.out.println("}");
		System.out.println("--------------------------------");

		int[][] matrix02 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		st.setZeroes(matrix02);
		rlng = matrix02.length;
		clng = matrix02[0].length;
		System.out.print("{");
		for(int i = 0; i < rlng; ++i) {
			System.out.print(" {");
			for(int j = 0; j < clng; ++j) 
				System.out.print(matrix02[i][j] + ",");
			System.out.print("}, ");
		}
		System.out.println("}");
		System.out.println("--------------------------------");

		int[][] matrix03 = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
		st.setZeroes(matrix03);
		rlng = matrix03.length;
		clng = matrix03[0].length;
		System.out.print("{");
		for(int i = 0; i < rlng; ++i) {
			System.out.print(" {");
			for(int j = 0; j < clng; ++j) 
				System.out.print(matrix03[i][j] + ",");
			System.out.print("}, ");
		}
		System.out.println("}");
		System.out.println("--------------------------------");
	}
}
