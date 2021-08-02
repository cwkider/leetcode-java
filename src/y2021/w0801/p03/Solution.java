/**
  * @FileName : Solution.java
  * @Date : 2021. 8. 2. 
  * @Problem Title : Two Sum
 */
package y2021.w0801.p03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i = 0; i < nums.length; ++i) {
        	if(map.get(nums[i]) != null) {
        		ArrayList<Integer> alidx = map.get(nums[i]);
        		alidx.add(new Integer(i));
        		map.put(nums[i], alidx);
        	} else {
        		ArrayList<Integer> alidx = new ArrayList<Integer>();
        		alidx.add(new Integer(i));
        		map.put(nums[i], alidx);
        	}
        }
        
        boolean findYn = false;
        for(int i = 0; i < nums.length; ++i) {
        	int findnum = target - nums[i];
        	
        	if(map.get(findnum) != null) {
        		ArrayList<Integer> alidx = map.get(findnum);
        		for(int j = 0; j < alidx.size(); ++j) {
        			if(alidx.get(j).intValue() != i) {
        				ret[0] = i;
        				ret[1] = alidx.get(j).intValue();
        				findYn = true;
        				break;
        			}
        		}
        	}
        	
        	if(findYn) break;
        }
        
        return ret;
    }
    
	public static void main(String[] args) {
		Solution st = new Solution();
		int target = 0;
		int[] ret;
		
		int[] nums01 = {2,7,11,15};
		target = 9;
		//Output: [0,1]
		ret = st.twoSum(nums01, target);
		System.out.println("[ret[0]] : " + ret[0] + " | [ret[1]] : " + ret[1]);

		int[] nums02 = {3, 2, 4};
		target = 6;
		//Output: [1,2]
		ret = st.twoSum(nums02, target);
		System.out.println("[ret[0]] : " + ret[0] + " | [ret[1]] : " + ret[1]);

		int[] nums03 = {3, 3};
		target = 6;
		//Output: [0, 1]
		ret = st.twoSum(nums03, target);
		System.out.println("[ret[0]] : " + ret[0] + " | [ret[1]] : " + ret[1]);

	}

}
