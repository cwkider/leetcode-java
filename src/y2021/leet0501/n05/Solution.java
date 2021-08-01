package y2021.leet0501.n05;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean ret = false;
        
        int lng = nums.length;
        
        int cnt = 0;
        for(int i = 0; i < lng - 1; ++i) {
        	if(nums[i] > nums[i + 1]) {
        		if(i < lng - 2 && nums[i] <= nums[i + 2]) nums[i+1] = nums[i+2];
        		else if(i == lng - 2) nums[i+1] = nums[i];
        		else nums[i] = nums[i+1];
        		cnt++;
        		if(cnt > 1) break;
        		if(i > 0 && nums[i-1] > nums[i]) {
        			cnt = 2;
        			break;
        		}
        	}
        }
        
        if(cnt <= 1) ret = true;
        
        
        return ret;
    }
    
    public static void main(String args[]) {
    	int[] nums1 = {4,2,3};
    	
    	Solution st = new Solution();
    	
    	System.out.println(st.checkPossibility(nums1));
    	
    }
}
