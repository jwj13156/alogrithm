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
public class maxDepth {
	public int maxDepth(TreeNode root) {
		//递归，当前节点的最大深度是之前的最大深度加1
		if(root == null) return 0;
	    int left = maxDepth(root.left);
	    int right = maxDepth(root.right);
	    return Math.max(left, right) + 1;
	}
}
