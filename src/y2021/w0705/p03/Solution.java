package y2021.w0705.p03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class MapSum {
	private Map<String, Integer> mp;
    /** Initialize your data structure here. */
    public MapSum() {
        mp = new HashMap<String, Integer>();
    }
    
    public void insert(String key, int val) {
        mp.put(key, val);
    }
    
    public int sum_2(String prefix) {
        int ret = 0;
        
        int plng = prefix.length();
        
        Iterator<String> keys = mp.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
//            System.out.println("[Key]:" + key + " [Value]:" +  mp.get(key));
            int klng = key.length();
            if(klng >= plng) {
            	String kpre = key.substring(0, plng);
//            	System.out.println("[Key]:" + key + " [Value]:" +  mp.get(key) + " | [kpre] : " + kpre);
            	if(prefix.equals(kpre)) ret += mp.get(key);
            }
        }
                
        return ret;
    }
    
    public int sum(String prefix) {
        int ret = 0;
        
        int plng = prefix.length();
        
        Iterator<Entry<String, Integer>> entries = mp.entrySet().iterator();
        while(entries.hasNext()){
        	Map.Entry<String, Integer> entry = entries.next();
            String key = entry.getKey();
            int klng = key.length();
            if(klng >= plng) {
            	String kpre = key.substring(0, plng);
            	if(prefix.equals(kpre)) ret += entry.getValue();
            }
        }
                
        return ret;
    }
}


public class Solution {
	/**
	 * Your MapSum object will be instantiated and called as such:
	 * MapSum obj = new MapSum();
	 * obj.insert(key,val);
	 * int param_2 = obj.sum(prefix);
	 */
	public static void main(String[] args) {
		int ret = 0;
		
		MapSum mapSum = new MapSum();
		mapSum.insert("apple", 3);  
		ret = mapSum.sum("ap");           // return 3 (apple = 3)
		System.out.println("[ret] : " + ret);
		mapSum.insert("app", 2);    
		ret = mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
		System.out.println("[ret] : " + ret);

	}
}



