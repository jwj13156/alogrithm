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
public class flatten {
	public void flatten(TreeNode root) {
        dfs(root);
    }

    // 返回展开后的链表尾节点
    private TreeNode dfs(TreeNode node) {
        if (node == null) return null;
        // 先递归处理右、左
        TreeNode leftTail = dfs(node.left);
        TreeNode rightTail = dfs(node.right);

        // 如果存在左子树，把左树移到右边
        if (leftTail != null) {
            // 左树尾部接上原右子树
            leftTail.right = node.right;
            // 原右子树替换为左子树
            node.right = node.left;
            // 左指针置空
            node.left = null;
        }
        // 返回当前子树链表的最后一个节点
        return rightTail != null ? rightTail : (leftTail != null ? leftTail : node);
    }
}
