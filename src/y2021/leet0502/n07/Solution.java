package y2021.leet0502.n07;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> getRightString(String a2) {
		List<String> ret = new ArrayList<String>();
		
		// ������ ���ڿ� ���� 
		// ���̰� 1�̸� �� �߰�
		// ���̰� 1�� �ƴϰ� ���� 0�� �ƴϸ�
		//   0���� ������ ��� - ù�ڸ� ���� . �߰��Ͽ� �� �߰�
		//   0�� �ƴ� ���� ������ ��� - ù�ڸ� ���� ���ڸ� ������ .�� ,�� �� �߰� 
		String ins2;
		if(a2.length() == 1) {
			ins2 = a2 + ")";
			ret.add(ins2);
		} else {
			if(a2.charAt(a2.length() - 1) != '0') {
				if(a2.charAt(0) == '0') {
					ins2 = a2.substring(0, 1) + "." + a2.substring(1, a2.length()) + ")";
					ret.add(ins2);
				} else {
					for(int j = 0; j < a2.length() - 1; ++j) {
						ins2 = a2.substring(0, j+1) + "." + a2.substring(j + 1, a2.length()) + ")";
						ret.add(ins2);
					}
					ins2 = a2 + ")";
					ret.add(ins2);	    						
				}
			} else {
				if(a2.charAt(0) != '0') {
					ins2 = a2 + ")";
					ret.add(ins2);
				}
			}
		}    				
		
		return ret;
	}
	
    public List<String> ambiguousCoordinates(String s) {
    	List<String> ret = new ArrayList<String>();
    	int lng = s.length();
    	s = s.substring(1, lng - 1);
    	lng = s.length();
    	
    	String a1 = "", a2 = "";
    	String t1, t2, ins1 = "", ins2 = "", ins3 = "";
    	List<String> rList;
    	for(int i = 0; i < lng - 1; ++i) {
    		t1 = s.substring(i, i + 1);
    		t2 = s.substring(i + 1, lng);
    		// ���� ������ ���ؼ�
    		// i == 0�̸� �̹� ���ڰ� 0�� ��� ����, �߰���
    		// �̹� ���ڰ� 0�� �ƴ� ���
    		//   0���� ������ ��� - �Ǿ� 0 ���� ���� �߰�
    		//   0���� ���۾��� ��� - ��ü ���� / �� �����ĺ��� .
    		a1 += t1;
    		a2 = t2;
    		if(i == 0 || a1.charAt(0) != '0' || (a1.charAt(0) == '0' && !t1.equals("0"))) {
    			if(i == 0) {
    				ins1 = "(" + a1 + ", ";
    				rList = getRightString(a2);
    				if(rList.size() > 0) {
    					for(int j = 0; j < rList.size(); ++j) {
    						ins2 = rList.get(j);
    						ins3 = ins1 + ins2;
    						ret.add(ins3);
    					}
    				}
    			}
    			else {
	    			if(a1.charAt(0) == '0') {
	    				ins1 = "(" + a1.substring(0, 1) + "." + a1.substring(1, a1.length()) + ", ";
	    				
	    				rList = getRightString(a2);
	    				if(rList.size() > 0) {
	    					for(int j = 0; j < rList.size(); ++j) {
	    						ins2 = rList.get(j);
	    						ins3 = ins1 + ins2;
	    						ret.add(ins3);
	    					}
	    				}
	    			} else {
	    				if(a1.charAt(a1.length() - 1) == '0') {
	    					ins1 = "(" + a1 + ", ";
	    					rList = getRightString(a2);
	        				if(rList.size() > 0) {
	        					for(int j = 0; j < rList.size(); ++j) {
	        						ins2 = rList.get(j);
	        						ins3 = ins1 + ins2;
	        						ret.add(ins3);
	        					}
	        				}
	    				}
	    				else {
		    				for(int k = 0; k < a1.length(); ++k) {
		    					if(k < a1.length() - 1) ins1 = "(" + a1.substring(0, k+1) + "." + a1.substring(k+1, a1.length()) + ", ";
		    					else ins1 = "(" + a1 + ", ";
		        				rList = getRightString(a2);
		        				if(rList.size() > 0) {
		        					for(int j = 0; j < rList.size(); ++j) {
		        						ins2 = rList.get(j);
		        						ins3 = ins1 + ins2;
		        						ret.add(ins3);
		        					}
		        				}
		    				}
	    				}
	    			}
	
    			}
    		}
    	}
    	
    	return ret;
    }
    
	public static void main(String[] args) {
		Solution st = new Solution();
		
		String s;
		
		
		List<String> ans;
		
		s = "(123)";
		//Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
		ans = st.ambiguousCoordinates(s);
		
		for(int i = 0; i < ans.size(); ++i) {
			System.out.println(ans.get(i));
		}
		System.out.println("---------------------------------------------------");

		s = "(00011)";
		//Output:  ["(0.001, 1)", "(0, 0.011)"]
		ans = st.ambiguousCoordinates(s);
		
		for(int i = 0; i < ans.size(); ++i) {
			System.out.println(ans.get(i));
		}
		System.out.println("---------------------------------------------------");

		s = "(0123)";
		//Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
		ans = st.ambiguousCoordinates(s);
		
		for(int i = 0; i < ans.size(); ++i) {
			System.out.println(ans.get(i));
		}
		System.out.println("---------------------------------------------------");

		s = "(100)";
		//["(10, 0)"]
		ans = st.ambiguousCoordinates(s);
		
		for(int i = 0; i < ans.size(); ++i) {
			System.out.println(ans.get(i));
		}
		System.out.println("---------------------------------------------------");

		s = "(010)";
		//["(0, 10)","(0.1, 0)"]
		ans = st.ambiguousCoordinates(s);
		
		for(int i = 0; i < ans.size(); ++i) {
			System.out.println(ans.get(i));
		}
		System.out.println("---------------------------------------------------");	}

}
