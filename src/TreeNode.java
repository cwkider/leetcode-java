import java.util.ArrayList;

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
}
