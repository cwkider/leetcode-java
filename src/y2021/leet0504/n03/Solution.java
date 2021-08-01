package y2021.leet0504.n03;

public class Solution {
    public String shortestSuperstring(String[] words) {
        String ret = "";
        int retLng = 990;
        
        if(words.length == 1) return words[0];
        
        String[][] cache = new String[13][(int) (Math.pow(2, 13) - 1)];
        
        int used = 0;
        String temp;
        
        for(int i = 0; i < words.length; ++i) {
        	used = 1 << (i + 1);
        	temp = getShortestString(i, words, cache, used, 1);
        	if(retLng > temp.length()) ret = temp;
			retLng = ret.length();
        	used = 0;
        }
        
        return ret;
    }
    
    public String getShortestString(int idx, String[] words, String[][] cache, int used, int cnt) {
    	if(cache[idx][used] != null) return cache[idx][used];
    	String ret = "";
    	int retLng = 990;
    	
    	String temp, shortstring;
    	int jtemp = 0;
		for(int j = 0; j < words.length; ++j) {
			jtemp = 1 << (j + 1);
			if((used & jtemp) >= 1) continue;
			temp = combinedString(idx, j, words);
			used |= jtemp;
			if(cnt < words.length - 1) {
				shortstring = getShortestString(j, words, cache, used, cnt + 1);
//				System.out.println("1. temp : " + temp + " | shortstring : " + shortstring + " | idx : " + idx + " | j : " + j);
				shortstring = shortstring.substring(words[j].length());
//				System.out.println("2. temp : " + temp + " | shortstring : " + shortstring + " | idx : " + idx + " | j : " + j	);
			}
			else shortstring = "";
//			System.out.println("3. idx : " + idx + " | j : " + j + " | temp : " + temp + " | shortstring : " + shortstring + " | ret : " + ret);
			temp += shortstring;
			if(retLng > temp.length()) ret = temp;
			retLng = ret.length();
			used ^= jtemp;
		}
		
		cache[idx][used] = ret;
    	
    	return ret;
    }
    
    public String combinedString(int ia, int ib, String[] words) {
    	String ret = null;
    	
    	String a = new String(words[ia]);
    	String b = new String(words[ib]);
    	int lena = a.length();
    	int lenb = b.length();
    	
    	int lenc = lena;
    	if(lena > lenb) lenc = lenb;
    	
    	String suba, subb;
    	for(int i = 0; i < lenc; ++i) {
    		suba = a.substring(lena - lenc + i, lena);
    		subb = b.substring(0, lenc - i);
    		if(suba.equals(subb)) {
    			ret = a + b.substring(lenc - i, lenb);
//    			System.out.println("3. ret : " + ret + " | suba : " + suba + " | subb : " + subb);
    			break;
    		}
    	}
    	
    	if(ret == null) ret = a + b;
    	
    	return ret;
    }
    
	public static void main(String[] args) {
		Solution st = new Solution();
		
		String[] words1 = {"alex","loves","leetcode"};
		//Output: "alexlovesleetcode"
		System.out.println(st.shortestSuperstring(words1));
		System.out.println("----------------------------------------------");
		
		String[] words2 = {"catg","ctaagt","gcta","ttca","atgcatc"};
		//Output: "gctaagttcatgcatc"
		//         gctaagttcatgcatc gcta, ctaagt, 
		System.out.println(st.shortestSuperstring(words2));
		System.out.println(st.combinedString(1, 3, words2));
		System.out.println("----------------------------------------------");
		
		String[] words3 = {"a"};
		//Output: "a"
		System.out.println(st.shortestSuperstring(words3));
		System.out.println("----------------------------------------------");
	}

}
