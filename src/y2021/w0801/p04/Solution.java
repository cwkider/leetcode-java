/**
  * @FileName : Solution.java
  * @Date : 2021. 8. 3. 
  * @Problem Title : Subsets II
 */
package y2021.w0801.p04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {
	List<List<Integer>> ret;
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ret = new ArrayList<List<Integer>>();
        
        List<Integer> ret2 = new ArrayList<Integer>();
        ret.add(ret2);
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; ++i) {
        	if(map.get(nums[i]) == null) {
        		map.put(nums[i],  1);
        	} else {
        		map.put(nums[i],  map.get(nums[i]) + 1);
        	}
        }
        
        Iterator<Integer> itr = map.keySet().iterator();
        int mapsz = map.size();
        int[][] arrset = new int[mapsz][2];
        int idx = 0;
        while(itr.hasNext()) {
        	Integer key = itr.next();
        	Integer val = map.get(key);
//        	System.out.println("key : " + key + " | val : " + val);
        	arrset[idx][0] = key;
        	arrset[idx][1] = val;
        	idx++;
        }
        ret2 = new ArrayList<Integer>();
        makeList(ret2, arrset, 0);
        
        return ret;
    }
    
    public void makeList(List<Integer> ret2, int[][] arrset, int n) {
//    	System.out.println("n : " + n + " | ret2 : " + ret2);
    	int end = n;
    	if(n == 0) end = arrset.length - 1;
    	for(int k = n; k <= end; ++k) {
	    	int key = arrset[k][0];
	    	int val = arrset[k][1];
	    	
	    	ArrayList<Integer> ret3 = new ArrayList<Integer>(ret2);
	    	for(int i = 0; i < val; ++i) {
	    		ret3.add(key);
	    		ret.add(ret3);
//	    		System.out.println("n : " + n + " | i : " + i + " | key : " + key + " | val : " + val + " | ret2 : " + ret2 + " | ret3 : " + ret3);
	    		ArrayList<Integer> ret4 = new ArrayList<Integer>(ret3);
	    		ret3 = new ArrayList<Integer>(ret4);
	    		for(int j = k + 1; j < arrset.length; ++j)
	    			makeList(ret4, arrset, j);
	    	}
    	}
    }
    
	public static void main(String[] args) {
		List<List<Integer>> ret;
		Solution st = new Solution();
		int sz = 0;
		
		int[] nums01 = {1,2,2};
		//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
		ret = st.subsetsWithDup(nums01);
		sz = ret.size();
		for(int i = 0; i < sz; ++i) {
			List<Integer> ret2 = ret.get(i);
			int sz2 = ret2.size();
			System.out.print("{");
			for(int j = 0; j < sz2; ++j) {
				System.out.print(ret2.get(j) + ",");
			}
			System.out.print("}");
		}
		System.out.println();
		
		int[] nums02 = {1,2,3};
		//Output: [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
		ret = st.subsetsWithDup(nums02);
		sz = ret.size();
		for(int i = 0; i < sz; ++i) {
			List<Integer> ret2 = ret.get(i);
			int sz2 = ret2.size();
			System.out.print("{");
			for(int j = 0; j < sz2; ++j) {
				System.out.print(ret2.get(j) + ",");
			}
			System.out.print("}");
		}
	}

}
