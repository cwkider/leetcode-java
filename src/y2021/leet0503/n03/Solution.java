package y2021.leet0503.n03;


public class Solution {
    public int minCameraCover(TreeNode root) {
       int ret = putCamera(root, 1, 1, 1);
       
       
       
       return ret;
    }
    
    public int putCamera(TreeNode node, int prtCvYn, int prtCmYn, int putYn) {
    	if(node == null) return 0;
    	int ret = node.val;
    	if(ret != 0) return ret;
    	
    	ret = 0;
    	
    	int nowCvYn = 0;
    	if(prtCmYn == 1) nowCvYn = 1;
    	
    	if(putYn == 1) {
    		ret = 1;
    		nowCvYn = 1;
    	}
    	
    	if(prtCvYn == 0) {
    		if(node.left != null) {
    			int ret2 = putCamera(node.left, nowCvYn, putYn, 1);
    			if(putYn == 1) ret2 = Math.min(ret2, putCamera(node.left, nowCvYn, 1, 0));
    			ret += ret2;
    		}
    		if(node.right != null) {
    			int ret2 = putCamera(node.right, nowCvYn, putYn, 1);
    			if(putYn == 1) ret2 = Math.min(ret2, putCamera(node.right, nowCvYn, 1, 0));
    			ret += ret2;
    		}
    	}
    	else { // prtCvYn == 1
    		int ret2 = 0;
    		// ī�޶� ���ʿ� ���� ���
    		ret2 = putCamera(node.left, nowCvYn, putYn, 1);
    		ret2 += putCamera(node.right, nowCvYn, putYn, 1);
    		// ī�޶� ���ʿ��� ���� ���
    		ret2 = Math.min(ret2, putCamera(node.left, nowCvYn, putYn, 1) + putCamera(node.left, nowCvYn, putYn, 0));
   			// ī�޶� �����ʿ� ���� ���
    		ret2 = Math.min(ret2, putCamera(node.left, nowCvYn, putYn, 0) + putCamera(node.left, nowCvYn, putYn, 1));
    		// ī�޶� ���ʿ� �ȳ��� ��� 
    		if(prtCmYn == 1 || putYn == 1)	ret2 = Math.min(ret2, putCamera(node.left, nowCvYn, putYn, 0) + putCamera(node.left, nowCvYn, putYn, 0));
    	}

    	return ret;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
