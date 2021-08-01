package y2021.leet0503.n07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ret = new ArrayList<>();
        
        if(root == null) return ret;
    	
    	HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
    	
    	getLevel(root, hm, 1);
    	
    	for (Integer key: hm.keySet()) {
            if(hm.get(key) != null) ret.add(hm.get(key));
        }
    	return ret;
    }
    
    void getLevel(TreeNode node, HashMap<Integer, List<Integer>> hm, int level) {
    	List<Integer> list = null;
    	
    	Integer itkey = new Integer(level);
    	
    	if(hm.get(itkey) != null) {
    		list = hm.get(itkey);
    		Integer itval = new Integer(node.val);
    		list.add(itval);
    		hm.put(itkey, list);
    	} else {
    		list = new ArrayList<Integer>();
    		Integer itval = new Integer(node.val);
    		list.add(itval);
    		hm.put(itkey, list);
    	}
    	
    	if(node.left != null) getLevel(node.left, hm, level + 1);
    	if(node.right != null) getLevel(node.right, hm, level + 1);
    }
    
    public void printTree(TreeNode node) {
    	System.out.println(node.val);
    	if(node.left != null) printTree(node.left);
    	if(node.right != null) printTree(node.right);
    }
    
	public static void main(String[] args) {
		Solution st = new Solution();
		
		Integer[] nums1 = new Integer[7];
		nums1[0] = new Integer(3);
		nums1[1] = new Integer(9);
		nums1[2] = new Integer(20);
		nums1[3] = null;
		nums1[4] = null;
		nums1[5] = new Integer(15);
		nums1[6] = new Integer(7);
		
		TreeNode root1 = st.setInput(nums1);
		
		st.printTree(root1);
		
		List<List<Integer>> ret = st.levelOrder(root1);
		
		st.printListTree(ret);

	}
	
	public void printListTree(List<List<Integer>> ret) {
		int lng1 = ret.size();
		int lng2;
		
		List<Integer> ret2;
		for(int i = 0; i < lng1; ++i) {
			ret2 = ret.get(i);
			lng2 = ret2.size();
			for(int j = 0; j < lng2; ++j) {
				System.out.print(ret2.get(j));
			}
			System.out.println();
		}
	}
	
	public TreeNode setInput(Integer[] nums) {
		TreeNode ret = new TreeNode(nums[0]);
		
		TreeNode[] arrtn = new TreeNode[2000];
		arrtn[0] = ret;
		
		int arrlng = nums.length;
		int idx = 2;
		int bflng = 1, aflng = 1;
		TreeNode[] arrtn2 = new TreeNode[2000];
		while (aflng < arrlng) {
			bflng = aflng;
			aflng += idx;
			if(aflng > arrlng) aflng = arrlng;
			
			int aridx = -1, aridx2 = 0;;
			for(int i = bflng; i < aflng; ++i) {
				if(i % 2 == 1) {
					aridx++;
					if(nums[i] != null) {
						arrtn[aridx].left = new TreeNode(nums[i].intValue());
						arrtn2[aridx2] = arrtn[aridx].left;
						aridx2++;
					}
				} else {
					if(nums[i] != null) {
						arrtn[aridx].right = new TreeNode(nums[i].intValue());
						arrtn2[aridx2] = arrtn[aridx].right;
						aridx2++;
					}
				}
			}
			
			idx *= 2;
			arrtn = arrtn2;
			arrtn2 = new TreeNode[2000];
		}
		
		return ret;
	}

	
	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
}
