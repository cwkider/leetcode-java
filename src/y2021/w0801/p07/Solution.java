/**
  * @FileName : Solution.java
  * @Date : 2021. 8. 7. 
  * @Problem Title : Palindrome Partitioning II
 */
package y2021.w0801.p07;

/**
 * @author cwkider
 *
 */
public class Solution {
	static int[] cache = new int[2000];
	static int[][] pcache = new int[2000][2000];
	static String str;
    public int minCut(String s) {
    	str = s;
        int ret = 0;
        for(int i = 0; i < 2000; ++i) {
        	cache[i] = 987654321;
        	for(int j = 0; j < 2000; ++j) {
        		pcache[i][j] = -1;
        	}
        }
        
        ret = findIndex(0);
        
        return ret;
    }
    
    static int findIndex(int now) {
    	int ret = 987654321;
    	int lng = str.length();
    	if(now == lng) return 0;
    	
    	if(cache[now] != 987654321) return cache[now];
    	
    	if(isPalindrome(now, lng)) {
    		cache[now] = 0;
    		return 0;
    	}
    	for(int i = now + 1; i < lng; ++i) {
    		if(isPalindrome(now, i)) {
    			ret = Math.min(ret,  findIndex(i) + 1);
    		}
    	}
    	
    	cache[now] = ret;
    	
    	return ret;
    }
    
    static boolean isPalindrome(int i, int j) {
    	boolean ret = true;
    	if(pcache[i][j] != -1) {
    		if(pcache[i][j] == 0) return false;
    		else return true;
    	}
    	
    	int lng = j - i;
    	for(int k = 0; k < lng/2; ++k) {
    		if(str.charAt(i + k) != str.charAt(j - 1 - k)) {
    			ret = false;
    			break;
    		}
    	}
    	if(ret) pcache[i][j] = 1;
    	else pcache[i][j] = 0;
    	
    	return ret;
    }
    
    boolean isPalindrome2(String str) {
    	boolean ret = false;
    	
    	int lng = str.length();
    	int start2 = lng/2;
    	if(lng % 2 == 1) start2 += 1;
    	String sub1 = str.substring(0, lng/2);
    	String sub2 = str.substring(start2, lng);
    	StringBuffer sb = new StringBuffer(sub2); 
    	sub2 = sb.reverse().toString();

    	if(sub1.equals(sub2)) ret = true;
    	
    	return ret;
    }    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution st = new Solution();
		String s;
		
		s = "aab";
		//Output: 1
		System.out.println(st.minCut(s));

		s = "aabcc";
		//Output: 2
		System.out.println(st.minCut(s));
	
		s = "a";
		//Output: 0
		System.out.println(st.minCut(s));
	
		s = "ab";
		//Output: 1
		System.out.println(st.minCut(s));
	
		s = "aaa";
		//Output: 0
		System.out.println(st.minCut(s));
	}

}
