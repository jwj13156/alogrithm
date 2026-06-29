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
public class inorderTraversal {
	//很简单的中序遍历
	List<Integer> list= new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }
	void dfs(TreeNode node) {
		if(node == null) return ;
		dfs(node.left);
		list.add(node.val);
		dfs(node.right);
	}
}
