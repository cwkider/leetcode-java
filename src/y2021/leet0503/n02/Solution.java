package y2021.leet0503.n02;

public class Solution {
    public boolean isNumber(String s) {
        boolean ret = true;
        
        int lng = s.length();
        
        boolean pmYn = false;
        boolean eYn = false;
        boolean dotYn = false;
        boolean numYn = false;
        char cnow, cbefore, c2before;
        for(int i = 0; i < lng; ++i) {
        	cnow = s.charAt(i);
        	if(i != 0) cbefore = s.charAt(i - 1);
        	else cbefore = s.charAt(0);
//        	if(i >= 2) c2before = s.charAt(index)
        	
        	//����
        	if(cnow >= '0' && cnow <= '9') {
        		numYn = true;
        		continue;
        	}
        	//e or E
        	else if(cnow == 'e' || cnow == 'E') {
        		if(i == 0 || i == lng - 1 || eYn == true) {
//        			System.out.println("1 e E> cnow : " + cnow + " | lng : " + lng);
        			return false;
        		}
        		else if(!((cbefore >= '0' && cbefore <= '9') || (cbefore == '.' && numYn == true))) {
//        			System.out.println("2 e E> cnow : " + cnow + " | lng : " + lng);
        			return false;
        		}
        		else {
        			eYn = true;
        		}
        	}
        	// +, -
        	else if(cnow == '+' || cnow == '-') {
        		if(i == lng - 1) return false;
        		else 
        			if(i != 0 && !(cbefore == 'e' || cbefore == 'E')) return false;
        	}
        	else if(cnow == '.') {
//        		System.out.println("1 cnow : " + cnow + " | lng : " + lng);
        		if((i == 0 && lng == 1) || (i != 0 && (!(cbefore >= '0' && cbefore <= '9') && !(cbefore == '+' || cbefore == '-'))) || eYn == true || dotYn == true) {
//        			System.out.println("2 cnow : " + cnow + " | lng : " + lng);
        			return false;
        		}
        		else {
        			dotYn = true;
        		}
        		
        	}
        	else return false;
        }
        
        if(!numYn) ret = false;
        
        return ret;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Solution st = new Solution(); 
		
		s = "0";
		//Output: true
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = "e";
		//Output: false
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = ".";
		//Output: false
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = ".1";
		//Output: true
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");
		
		s = "0089";
		//Output: true
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = "2e10";
		//Output: true
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = "99e2.5";
		//Output: false
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = "1e";
		//Output: false
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = "3.";
		//Output: true
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = ".1.";
		//Output: false
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = "-1.";
		//Output: true
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = "+.8";
		//Output: true
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = "6+1";
		//Output: false
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");

		s = "+.";
		//Output: false
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");
		
		s = "46.e3";
		//Output: true
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");
		
		s=".e1";
		//Output: false
		System.out.println(st.isNumber(s));
		System.out.println("--------------------------------------------");
	}

}
