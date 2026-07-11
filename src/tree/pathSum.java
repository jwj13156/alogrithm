package tree;

public class pathSum {
	public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        // 三种情况：当前节点作为起点的路径数 + 左子树全部起点 + 右子树全部起点
        int cur = count(root, targetSum);
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);
        return cur + left + right;
    }

    // 以node为起点，向下走，统计和为sum的路径数量
    private int count(TreeNode node, long sum) {
        if (node == null) return 0;
        int res = 0;
        // 当前节点值刚好等于剩余sum，找到一条路径
        if (node.val == sum) {
            res++;
        }
        // 继续往下走，剩余和减去当前节点值
        res += count(node.left, sum - node.val);
        res += count(node.right, sum - node.val);
        return res;
    }
}
