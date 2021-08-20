/**
 * @FileName : Solution.java
 * @Date : 2021. 8. 20.
 * @Problem Title : Maximum Product of Splitted Binary Tree
 */
package y2021.w0803.p06;

import java.util.ArrayList;

public class Solution {
    int total;

    public int maxProduct(TreeNode root) {
        int ret = 0;

        total = setSubSum(root);
//        System.out.println("total : " + total + " | root.val : " + root.val);

        long prod = 0;
        if(root.left != null)
            prod = Math.max(prod, getMaxProd(root.left));
        if(root.right != null)
            prod = Math.max(prod, getMaxProd(root.right));

//        System.out.println("prod : " + prod);
        long mod = 1000000000 + 7;
        ret = (int)(prod % mod);

        return ret;
    }

    public long getMaxProd(TreeNode node) {
        long ret = 0;
        ret = Math.max((long)node.val * (long)(total - node.val), ret);
//        System.out.println("node.val : " + node.val + " | ret : " + ret);
        if(node.left != null) {
            ret = Math.max(ret, getMaxProd(node.left));
        }

        if(node.right != null) {
            ret = Math.max(ret, getMaxProd(node.right));
        }

        return ret;
    }

    public int setSubSum(TreeNode node) {
        if(node.left == null && node.right == null) {
            return node.val;
        }

        int ret = 0;
        if(node.left != null) {
            ret += setSubSum(node.left);
        }
        if(node.right != null) {
            ret += setSubSum(node.right);
        }
        ret += node.val;
        node.val = ret;

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

    public TreeNode setTreeNode(Integer[] nums) {
        TreeNode ret = new TreeNode();

        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        int lng = nums.length;
        ret.val = nums[0];
        al.add(ret);
        int i = 1;
        int j = 0;
        int lng2 = al.size();
        ArrayList<TreeNode> al2 = new ArrayList<TreeNode>();
        while(i < lng){
            if(j < lng2) {
                if(nums[i] != null) {
                    TreeNode tn = new TreeNode(nums[i]);
                    al2.add(tn);
                    al.get(j).left = tn;
                } else {
                    al.get(j).left = null;
                }
                i++;
                if (i < lng) {
                    if(nums[i] != null) {
                        TreeNode tn = new TreeNode(nums[i]);
                        al2.add(tn);
                        al.get(j).right = tn;
                    }else {
                        al.get(j).right = null;
                    }
                    i++;
                }
                j++;
            } else {
                j = 0;
                al = al2;
                lng2 = al.size();
                al2 = new ArrayList<TreeNode>();
            }
        }

        return ret;
    }

    public void printTreeNode(TreeNode root) {
        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        al.add(root);
        ArrayList<TreeNode> al2 = new ArrayList<TreeNode>();
        int i = 0;
        while(al.size() > 0) {
            if(i < al.size()) {
                System.out.print(al.get(i).val + " ");
                if(al.get(i).left != null) {
                    al2.add(al.get(i).left);
                }
                if(al.get(i).right != null) {
                    al2.add(al.get(i).right);
                }
                ++i;
            } else {
                al = al2;
                al2 = new ArrayList<TreeNode>();
                i = 0;
            }
        }

    }

    public static void main(String[] args) {
        Solution st = new Solution();
        TreeNode root;

        Integer[] nums01 = {1,2,3,4,5,6};
        //Output: 110
        root = st.setTreeNode(nums01);
        st.printTreeNode(root);
        System.out.println();
        System.out.println(st.maxProduct(root));
        System.out.println("-----------------------------");

        Integer[] nums02 = {1,null,2,3,4,null,null,5,6};
        //Output: 90
        root = st.setTreeNode(nums02);
        st.printTreeNode(root);
        System.out.println();
        System.out.println(st.maxProduct(root));
        System.out.println("-----------------------------");

        Integer[] nums03 = {2,3,9,10,7,8,6,5,4,11,1};
        //Output: 1025
        root = st.setTreeNode(nums03);
        st.printTreeNode(root);
        System.out.println();
        System.out.println(st.maxProduct(root));
        System.out.println("-----------------------------");

        Integer[] nums04 = {1, 1};
        //Output: 1
        root = st.setTreeNode(nums04);
        st.printTreeNode(root);
        System.out.println();
        System.out.println(st.maxProduct(root));
        System.out.println("-----------------------------");
    }
}


