package y2021.leet0503.n05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ret = new ArrayList<>();
        
        String[][] paths2 = new String[5*10000][2];
        
        String[] tokens;
        int cnt = 0;
        for(int i = 0; i < paths.length; ++i) {
        	tokens = paths[i].split(" ");
        	for(int j = 1; j < tokens.length; ++j) {
	        	int idx = tokens[j].indexOf("(");
	        	paths2[cnt][0] = new String(tokens[0] + "/" + tokens[j].substring(0, idx));
	        	paths2[cnt][1] = new String(tokens[j].substring(idx + 1, tokens[j].length()));
//	        	System.out.println("cnt : " + cnt + " | paths2[cnt][0] : " + paths2[cnt][0] + " | paths2[cnt][1] : " + paths2[cnt][1]);
	        	cnt++;
	        }
        }
        
//        System.out.println("cnt : " + cnt);
        
        Arrays.sort(paths2, 0, cnt, new Comparator<String[]>() {
        	@Override
			public int compare(String[] a1, String[] a2) {
        		String field1 = a1[1];
        		String filed2 = a2[1];
        		return field1.compareTo(filed2);
        	}
        });
        
//        for(int i = 0; i < cnt; ++i) {
//        	System.out.println("i : " + i + " | paths2[i][0] : " + paths2[i][0] + " | paths2[i][1] : " + paths2[i][1]);
//        }
        
        List<String> cand = new ArrayList<String>();
        int cnt2 = 0;
        for(int i = 0; i < cnt - 1; ++i) {
//        	System.out.println("i : " + i + " | paths2[i][0] : " + paths2[i][0] + " | paths2[i][1] : " + paths2[i][1]);
        	cand.add(paths2[i][0]);
        	cnt2++;
        	if(!paths2[i][1].equals(paths2[i+1][1])) {
        		if(cnt2 > 1) ret.add(cand);
        		cand = new ArrayList<String>();
        		cnt2 = 0;
        	}
        	if(i == cnt - 2 && paths2[i][1].equals(paths2[i+1][1])) {
        		cand.add(paths2[i + 1][0]);
        		ret.add(cand);
        	}
        }
        
        return ret;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution st = new Solution();
		
//		String[] path1 = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
//		List<List<String>> ret1 = st.findDuplicate(path1);
//		
//		for(int i = 0; i < ret1.size(); ++i) {
//			List<String> temp = ret1.get(i);
//			for(int j = 0; j < temp.size(); ++j) {
//				System.out.print(temp.get(j) + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("--------------------------------------------------------");
		
		String[] path2 = {"root/qgjazhtliq/djmevsktisuvd/acsuolhnermqzok/mkts/ibrdqxawjgut/emb wl.txt(odumfqzwczehoyk) z.txt(gojsklotgchjzfm) txtoyg.txt(gojsklotgchjzfm) eupidhefx.txt(ahlsazuzrsf) rekzkaifwp.txt(yfxaymkefaofowqjpgaceffkjsehtmqkgy) l.txt(odumfqzwczehoyk) bqmhpxumxlbe.txt(yfxaymkefaofowqjpgaceffkjsehtmqkgy) qoqgiauqbayuc.txt(odumfqzwczehoyk) mpstemqlxy.txt(ahlsazuzrsf)"};
		List<List<String>> ret2 = st.findDuplicate(path2);
		
		for(int i = 0; i < ret2.size(); ++i) {
			List<String> temp = ret2.get(i);
			for(int j = 0; j < temp.size(); ++j) {
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------");

	}

}
