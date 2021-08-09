/**
  * @FileName : Solution.java
  * @Date : 2021. 8. 9. 
  * @Problem Title : 
 */
package y2021.w0802.p03;

/**
 * @author cwkider
 *
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        String ret = "";
        int lng1 = num1.length();
        int lng2 = num2.length();
        
        if(lng2 > lng1) {
        	String sTemp = num1;
        	int iTemp = lng1;
        	num1 = num2;
        	lng1 = lng2;
        	num2 = sTemp;
        	lng2 = iTemp;
        }
        int j = lng2 - 1;
        int up = 0;
        int n1 = 0, n2 = 0;
        String retTemp = "";
        for(int i = lng1 - 1; i >= 0; --i) {
        	n1 = num1.charAt(i) - '0';
        	if(j >= 0) n2 = num2.charAt(j) - '0';
        	else n2 = 0;
        	int sum = n1 + n2 + up;
        	if(sum >= 10) {
        		up = 1;
        		sum -= 10;
        	} else {
        		up = 0;
        	}
        	retTemp += String.valueOf(sum);
        	j--;
        }
        if(up == 1) retTemp = retTemp + String.valueOf(1);
        
//        System.out.println("retTemp : " + retTemp);
        
        for(int i = retTemp.length() - 1; i >= 0; --i) 
        	ret += retTemp.charAt(i);
        
        return ret;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution st = new Solution();
		String num1, num2;
		
		num1 = "11";
		num2 = "123";
		//Output: "134"
		System.out.println(st.addStrings(num1, num2));
		
		num1 = "456";
		num2 = "77";
		//Output: "533"
		System.out.println(st.addStrings(num1, num2));
		
		num1 = "0";
		num2 = "0";
		//Output: "0"
		System.out.println(st.addStrings(num1, num2));

		num1 = "1";
		num2 = "9";
		//Output: "10"
		System.out.println(st.addStrings(num1, num2));
	}

}
