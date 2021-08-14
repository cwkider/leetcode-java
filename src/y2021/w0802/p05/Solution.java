/**
  * @FileName : Solution.java
  * @Date : 2021. 8. 11. 
  * @Problem Title : Array of Doubled Pairs
 */
package y2021.w0802.p05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author cwkider
 *
 */
public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        boolean ret = true;
        Arrays.sort(arr);
        int minuscnt = 0;
        int pluscnt = 0;
        for(int i = 0; i < arr.length; ++i) {
        	if(arr[i] < 0) {
        		minuscnt++;
        	} else {
        		break;
        	}
        }
        if(minuscnt % 2 != 0) return false;

        pluscnt = arr.length - minuscnt;
        Map<Integer, Integer> mmp = new HashMap<Integer, Integer>();
        Map<Integer, Integer> pmp = new HashMap<Integer, Integer>();

        for(int i = 0; i < arr.length; ++i) {
        	if(arr[i] < 0) {
        		if(mmp.get(arr[i] * -1) == null) {
        			mmp.put(arr[i] * -1, 1);
        		} else mmp.put(arr[i] * -1, mmp.get(arr[i] * -1) + 1);
        	} else {
        		if(pmp.get(arr[i]) == null) {
        			pmp.put(arr[i], 1);
        		} else pmp.put(arr[i], pmp.get(arr[i]) + 1);
        	}
        }

//        System.out.println("pluscnt : " + pluscnt);
        int midx = 0, pidx = 0;
        if(minuscnt > 0) {
        	TreeMap<Integer, Integer> mtm = new TreeMap<Integer, Integer>(mmp);
	        Iterator<Integer> mkeys = mtm.keySet().iterator();
	        int mkey = mkeys.next();
	        while(midx < minuscnt / 2) {
	//        	System.out.println("key : " + mkeys.next());
	        	mmp.put(mkey, mmp.get(mkey) - 1);
	        	int fnum = mkey * 2;
	        	if(mmp.get(fnum) == null) return false;
	        	else {
	        		if(mmp.get(fnum) == 0) return false;
	        		else {
	        			mmp.put(fnum,  mmp.get(fnum) - 1);
	        		}
	        	}
	        	while(mmp.get(mkey) == 0 && mkeys.hasNext()) mkey = mkeys.next();
	        	midx++;
	        }
        }

        if(pluscnt > 0) {
        	TreeMap<Integer, Integer> ptm = new TreeMap<Integer, Integer>(pmp);
	        Iterator<Integer> pkeys = ptm.keySet().iterator();
	        int pkey = pkeys.next();
	        while(pidx < pluscnt / 2) {
//	        	System.out.println("key : " + pkey);
	        	pmp.put(pkey, pmp.get(pkey) - 1);
	        	int fnum = pkey * 2;
	        	if(pmp.get(fnum) == null) return false;
	        	else {
	        		if(pmp.get(fnum) == 0) return false;
	        		else {
	        			pmp.put(fnum,  pmp.get(fnum) - 1);
	        		}
	        	}
	        	while(pmp.get(pkey) == 0 && pkeys.hasNext()) pkey = pkeys.next();
	        	pidx++;
	        }
        }

        return ret;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution st = new Solution();
		
//		int[] arr01 = {3,1,3,6};
//		//Output: false
//		System.out.println(st.canReorderDoubled(arr01));
//		
//		int[] arr02 = {2,1,2,6};
//		//Output: false
//		System.out.println(st.canReorderDoubled(arr02));
//		
//		int[] arr03 = {4,-2,2,-4};
//		//Output: true
//		System.out.println(st.canReorderDoubled(arr03));
//		
//		int[] arr04 = {1,2,4,16,8,4};
//		//Output: false
//		System.out.println(st.canReorderDoubled(arr04));
//		
//		int[] arr05 = {1,3,2,4,6,8};
//		//Output: true
//		System.out.println(st.canReorderDoubled(arr05));
//		
//		int[] arr06 = {1,2,3,4,6,8};
//		//Output: true
//		System.out.println(st.canReorderDoubled(arr06));
//		
//		int[] arr07 = {2,1,2,1,1,1,2,2};
//		//Output: true
//		System.out.println(st.canReorderDoubled(arr07));
//		
//		int[] arr08 = {4,4,8,8,8,8,2,2,16,16,1,32};
//		//Output: false
//		System.out.println(st.canReorderDoubled(arr08));

		int[] arr09 = {-1,4,6,8,-4,6,-6,3,-2,3,-3,-8};
		//Output: true
		System.out.println(st.canReorderDoubled(arr09));
	}
}
