package tree;

public class maxPathSum {
	 private int maxSum;

	    public int maxPathSum(TreeNode root) {
	        // 题目节点值可以全为负数，初始不能设0，设极小值
	        maxSum = Integer.MIN_VALUE;
	        maxGain(root);
	        return maxSum;
	    }

	    // 返回：以node为起点向下单条分支的最大和
	    private int maxGain(TreeNode node) {
	        if (node == null) return 0;

	        // 子树增益为负直接取0，代表不选这条分支
	        int left = Math.max(maxGain(node.left), 0);
	        int right = Math.max(maxGain(node.right), 0);

	        // 当前节点作为最高点，左+自身+右，一条完整路径
	        int currentPath = node.val + left + right;
	        // 更新全局最大值
	        maxSum = Math.max(maxSum, currentPath);

	        // 向上只能返回单侧分支：当前节点 + 左右中更大的一支
	        return node.val + Math.max(left, right);
	    }
}
