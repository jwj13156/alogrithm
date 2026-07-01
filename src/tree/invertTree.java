package tree;
import java.util.*;
class TreeNode {
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
public class invertTree {
	public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        //核心操作只有一步：每个节点交换左右子节点
        TreeNode tem=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(tem);
        return root;
    }
}
