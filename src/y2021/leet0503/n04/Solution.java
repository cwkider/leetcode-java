package y2021.leet0503.n04;

public class Solution {
    public int longestStrChain(String[] words) {
        int ret = 0;
        
        int[] lengs = new int[words.length];
        
        for(int i = 0; i < words.length; ++i) {
        	lengs[i] = words[i].length();
        }
        
        int itemp;
        String stemp;
        for(int i = 0; i < words.length - 1; ++i) {
        	for(int j = i + 1; j < words.length; ++j) {
        		if(lengs[i] > lengs[j]) {
        			itemp = lengs[i];
        			stemp = new String(words[i]);
        			lengs[i] = lengs[j];
        			words[i] = words[j];
        			lengs[j] = itemp;
        			words[j] = new String(stemp);
        		}
        	}
        }
        
        int[] cache = new int[1001];
        for(int i = 0; i < 1001; ++i) cache[i] = -1;
        
//        for(int i = 0; i < words.length; ++i) {
//        	System.out.print(words[i] + " ");
//        }
//        System.out.println();
        
        ret = getMaxNum(-1, words, cache);
        
        return ret;
    }
    
    int getMaxNum(int idx, String[] words, int[] cache) {
    	if(idx == words.length - 1) return 1;
    	if(idx != -1 && cache[idx] != -1) return cache[idx];
    	
    	int srt, end;
    	if(idx == -1) {
    		srt = 0;
    		end = words.length;
    	} else {
    		srt = idx;
    		end = idx + 2;
    	}
    	
    	int ret = 1;
    	for(int i = srt; i < end - 1; ++i) {
    		for(int j = i + 1; j < words.length; ++j) {
    			if(checkPredecessor(words[i], words[j])) {
    				ret = Math.max(ret, getMaxNum(j, words, cache) + 1);
    			}
    			
    			if(words[i].length() + 1 < words[j].length()) break;
    		}
    	}
    	
    	if(idx != -1) cache[idx] = ret;
    	
    	return ret;
    }
    
    boolean checkPredecessor(String a, String b) {
    	boolean ret = true;
    	
    	if(a.length()+1 != b.length()) return false;
    	
    	int cnt = 0, bidx = 0;
    	for(int i = 0; i < a.length(); ++i) {
    		if(a.charAt(i) != b.charAt(bidx)) {
    			cnt++;
    			if(cnt > 1) return false;
    			i--;
    		}
    		bidx++;
    	}
    	
    	if(cnt == 0 && bidx != b.length() - 1) return false;
    	
    	return ret;
    }
    
	public static void main(String[] args) {
		Solution st = new Solution();
		
		String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		System.out.println(st.longestStrChain(words));
		System.out.println("-----------------------------");

		String[] words1 = {"a","b","ba","bca","bda","bdca"};
		System.out.println(st.longestStrChain(words1));
		System.out.println("-----------------------------");
		
		String[] words2 = {"qyssedya","pabouk","mjwdrbqwp","vylodpmwp","nfyqeowa","pu","paboukc","qssedya","lopmw","nfyqowa","vlodpmw","mwdrqwp","opmw","qsda","neo","qyssedhyac","pmw","lodpmw","mjwdrqwp","eo","nfqwa","pabuk","nfyqwa","qssdya","qsdya","qyssedhya","pabu","nqwa","pabqoukc","pbu","mw","vlodpmwp","x","xr"};
		System.out.println(st.longestStrChain(words2));
		System.out.println("-----------------------------");
	}

}
