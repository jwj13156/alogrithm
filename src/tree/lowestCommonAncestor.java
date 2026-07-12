package tree;

public class lowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 空节点 / 找到p / 找到q，直接返回自身
        if (root == null || root == p || root == q) {
            return root;
        }
        // 递归左右子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 2. 左右都不为空：p、q一边一个，当前root是公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 3. 只有一边有值，说明两个节点都在那一侧，返回有值的一侧
        return left == null ? right : left;
    }
}
