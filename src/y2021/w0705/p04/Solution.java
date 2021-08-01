/**
  * @FileName : Solution.java
  * @Date : 2021. 7. 31. 
  * @Problem Title : Trapping Rain Water
 */
package y2021.w0705.p04;

import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        int ret = 0;
        Stack<Integer[]> st = new Stack<Integer[]>();
        
        int prehgt = 0;
        Integer[] star;
        int stidx = 0;
        int sthgt = 0;
        for(int i = 0; i < height.length; ++i) {
        	if(st.size() > 0 && height[i] > 0) {
        		int whgt = 0;
        		while(st.size() > 0) {
            		star = st.peek();
            		stidx = star[0].intValue();
            		sthgt = star[1].intValue();

        			int wwdt = i - stidx - 1;
        			if(wwdt == 0) {
            			if(sthgt > height[i]) {
            				prehgt = 0;
            				break;
            			} else {
            				prehgt = sthgt;
            				st.pop();
            			}
        			} else {
            			if(sthgt > height[i]) {
            				whgt = height[i] - prehgt;
            				prehgt = height[i];
            			} else { // height[i] >= sthgt
            				whgt = sthgt - prehgt;
            				prehgt = sthgt;
            				st.pop();
            			}
            			ret += (whgt * wwdt);
//            			System.out.println("[i] : " + i + " | [stidx] : " + stidx + " | [sthgt] : " + sthgt + " | [height[i]] : " + height[i] + " | [whgt] : " + whgt + " | [wwdt] : " + wwdt + " | [prehgt] : " + prehgt + " | [ret] : " + ret);
            			if(height[i] <= sthgt) {
            				break;
            			}
        			}
        		}
    			star = new Integer[2];
    			star[0] = new Integer(i);
    			star[1] = new Integer(height[i]);
    			st.push(star);
        	} else {
        		prehgt = 0;
        		if(height[i] > 0) {
	        		star = new Integer[2];
	    			star[0] = new Integer(i);
	    			star[1] = new Integer(height[i]);
	    			st.push(star);
        		}
        	}
        }
        
        return ret;
    }
    
	public static void main(String[] args) {
		int ret = 0;
		Solution st = new Solution();
		
		int[] height01 = {0,1,0,2,1,0,1,3,2,1,2,1};
		ret = st.trap(height01);
		System.out.println("[ret] : " + ret);
		
		int[] height02 = {4,2,0,3,2,5};
		ret = st.trap(height02);
		System.out.println("[ret] : " + ret);
	}

}
