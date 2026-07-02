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
public class isSymmetric {
	public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
	public boolean check(TreeNode a,TreeNode b) {
		if(a==null && b==null) return true;
		if(a==null || b==null) return false;
		//核心，匹配对称的二叉树
		return a.val==b.val && check(a.left,b.right) &&check(a.right,b.left);
	}
}
