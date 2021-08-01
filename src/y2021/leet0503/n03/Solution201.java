package y2021.leet0503.n03;


public class Solution201 {
    public int minCameraCover(TreeNode root) {
       int ret = 987654321;
       
       ret = Math.min(ret, putCamera(root));
       
       int ret2 = 0;
       if(root.left != null || root.right != null) {
    	   if(root.left != null && root.right != null) {
    		   int ret3 = putCamera(root.left);
    		   int ret4 = putCamera(root.right);
    		   int ret5 = 0;
    		   if(root.right.left != null) {
    			   ret5 += putCamera(root.right.left);
    		   }
    		   if(root.right.right != null) {
    			   ret5 += putCamera(root.right.right);
    		   }
    		   
    		   if(ret5 != 0) ret4 = Math.min(ret4,  ret5);
    		   ret2 = ret3 + ret4;
    		   
    		   ret5 = 0;
    		   if(root.left.left != null) {
    			   ret5 += putCamera(root.left.left);
    		   }
    		   if(root.left.right != null) {
    			   ret5 += putCamera(root.left.right);
    		   }
    		   if(ret5 != 0) ret3 = Math.min(ret3,  ret5);
    		   ret2 = Math.min(ret2,  ret3 + ret4);
    	   }
    	   else if(root.left != null) {
    		   ret2 += putCamera(root.left);
    	   }
    	   else if(root.right != null) {
    		   ret2 += putCamera(root.right);
    	   }
       }
       
//       System.out.println("ret : " + ret  + " | ret2 : " + ret2);
       
       if(ret2 != 0) ret = Math.min(ret,  ret2);
       
       return ret;
    }
    
    public int putCamera(TreeNode node) {
    	int ret = node.val;
    	if(ret != 0) return ret;
    	
    	ret = 0;
    	
    	if(node.left != null) {
    		if(node.left.left != null) {
    			int ret1 = putCamera(node.left.left);
    			int ret2 = 0;
    			if(node.left.left.left != null) {
    				ret2 += putCamera(node.left.left.left);
    			}
    			if(node.left.left.right != null) {
    				ret2 += putCamera(node.left.left.right);
    			}
//    			System.out.println("1 ret1 : " + ret1  + " | ret2 : " + ret2);
    			if(ret2 != 0) ret += Math.min(ret1, ret2);
    			else ret += ret1;
    		}
    		if(node.left.right != null) {
    			int ret1 = putCamera(node.left.right);
    			int ret2 = 0;
    			if(node.left.right.left != null) {
    				ret2 += putCamera(node.left.right.left);
    			}
    			if(node.left.right.right != null) {
    				ret2 += putCamera(node.left.right.right);
    			}
//    			System.out.println("2 ret1 : " + ret1  + " | ret2 : " + ret2);
    			if(ret2 != 0) ret += Math.min(ret1, ret2);
    			else ret += ret1;
    		}
    	}

    	if(node.right != null) {
    		if(node.right.left != null) {
    			int ret1 = putCamera(node.right.left);
    			int ret2 = 0;
    			if(node.right.left.left != null) {
    				ret2 += putCamera(node.right.left.left);
    			}
    			if(node.right.left.right != null) {
    				ret2 += putCamera(node.right.left.right);
    			}
//    			System.out.println("3 ret1: " + ret1  + " | ret2 : " + ret2);
    			if(ret2 != 0) ret += Math.min(ret1, ret2);
    			else ret += ret1;
    			
    		}
    		if(node.right.right != null) {
    			int ret1 = putCamera(node.right.right);
    			int ret2 = 0;
    			if(node.right.right.left != null) {
    				ret2 += putCamera(node.right.right.left);
    			}
    			if(node.right.right.right != null) {
    				ret2 += putCamera(node.right.right.right);
    			}
//    			System.out.println("4 ret1 : " + ret1  + " | ret2 : " + ret2);
    			if(ret2 != 0) ret += Math.min(ret1, ret2);
    			else ret += ret1;
    		}
    	}
    	
    	ret += 1;
    	
    	node.val = ret;

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
