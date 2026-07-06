package tree;

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
public class isValidBST {
	long pre =Long.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		//中序遍历，记录前一个节点值，每次判断当前值是否大于前值，不满足则非法。
        if(root == null ) return true;
        if(!isValidBST(root.left)) return false;
        
        if(root.val <= pre) return false;
        pre=root.val;
        
        return isValidBST(root.right);
    }
}
