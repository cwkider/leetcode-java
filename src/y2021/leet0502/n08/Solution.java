package y2021.leet0502.n08;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
	
    public void flatten(TreeNode root) {
    	if(root != null) partial(root);
    }
    
    public void partial(TreeNode node) {
//    	if( node.left == null && node.left.right == null ) {
//    		node.left.right = node.right;
//    		node.right = node.left;
//    		return;
//    	}
    	if(node.left == null &&  node.right == null) return;
    	
    	TreeNode temp = null;
    	if(node.left != null) {
    		partial(node.left);
    		temp = node.left;
    		while(temp.right != null) temp = temp.right;
    	}
    	if(node.right != null) partial(node.right);
    	
    	if(temp != null) {
    		temp.right = node.right;
    		node.right = node.left;
    		node.left = null;
    	}
    	
    	return;
    }
    
    void printTree(TreeNode node) {
    	if(node.left == null && node.right == null) {
    		System.out.println(node.val);
    	}
    	
    	System.out.println(node.val);
    	if(node.left != null) printTree(node.left);
    	if(node.right != null) printTree(node.right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
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
