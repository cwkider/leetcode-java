/**
  * @FileName : Solution.java
  * @Date : 2022. 2. 20. 
  * @Problem Title : 3. Longest Substring Without Repeating Characters
 */
package problems.leetpr00003;

import java.util.HashMap;

/**
 * @author cwkider
 *
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s;
		int ret;
		Solution st = new Solution();
		
		s = "abcabcbb";
		//Output : 3
		ret = st.lengthOfLongestSubstring(s);
		System.out.println("ret : " + ret);
		System.out.println("==================================");

		s = "bbbbb";
		//Output : 1
		System.out.println("ret : " + ret);
		ret = st.lengthOfLongestSubstring(s);
		System.out.println("==================================");

		s = "pwwkew";
		//Output : 3
		ret = st.lengthOfLongestSubstring(s);
		System.out.println("ret : " + ret);
		System.out.println("==================================");

		s = " ";
		//Output : 1
		ret = st.lengthOfLongestSubstring(s);
		System.out.println("ret : " + ret);
		System.out.println("==================================");
	}
	
    public int lengthOfLongestSubstring(String s) {
    	int ret = 0;
    	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    	int lng = s.length();
    	
    	int cnum = 0;
    	int temp = 0;
    	for(int i = 0; i < lng; ++i) {
    		cnum++;
    		Character now = s.charAt(i);
    		hm.put(now, cnum);
    		temp = 1;
    		for(int j = i + 1; j < lng; ++j) {
	    		Character nowj = s.charAt(j);
	//    		System.out.println("now : " + "|" + now + "|");
	    		if(hm.get(nowj) != null) {
	    			int val = hm.get(nowj);
	    			if(val != cnum) {
	    				hm.put(nowj, cnum);
	        			temp++;
	        		} else {
	        			break;
	        		}
	    		} else {
	    			hm.put(nowj, cnum);
	    			temp++;
	    		}
    		}
    		ret = Math.max(ret,  temp);
    	}
    	
    	ret = Math.max(ret,  temp);
    	
    	return ret;
    }

    public int lengthOfLongestSubstring2(String s) {
    	int ret = 0;
    	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    	int lng = s.length();
    	
    	int cnum = 1;
    	int temp = 0;
    	for(int i = 0; i < lng; ++i) {
    		Character now = s.charAt(i);
//    		System.out.println("now : " + "|" + now + "|");
    		if(hm.get(now) != null) {
    			int val = hm.get(now);
    			if(val != cnum) {
    				hm.put(now, cnum);
        			temp++;
        		} else {
        			ret = Math.max(ret,  temp);
        			cnum++;
        			hm.put(now, cnum);
        			temp = 1;
        			if(i > 1 && s.charAt(i - 1) != s.charAt(i)) {
        				hm.put(s.charAt(i - 1), cnum);
        				temp++;
        			}
        		}
    		} else {
				hm.put(now, cnum);
    			temp++;
    		}
    	}
    	
    	for(int i = 0; i < lng - 1; ++i) {
    		for(int j = i + 1; j < lng; ++j) {
    			
    		}
    	}
    	
    	ret = Math.max(ret,  temp);
    	
    	return ret;
    }
}
