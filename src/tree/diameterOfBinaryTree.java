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
public class diameterOfBinaryTree {
	//二叉树直径 = 某一个节点的「左子树深度 + 右子树深度」的最大值
	int res=0;
	public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
	private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        // 经过当前节点的路径长度 = 左深 + 右深
        res = Math.max(res, leftDepth + rightDepth);
        // 当前节点深度 = 左右最大 + 1（向下一条边）
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
