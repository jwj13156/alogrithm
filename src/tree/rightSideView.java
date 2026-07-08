package tree;
import java.util.ArrayList;
import java.util.List;

// 二叉树节点定义
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
public class rightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    // depth：当前节点层数，res.size() 代表已经收集了几层
    private void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;
        // 当前深度等于结果长度，说明是本层第一个遍历到的节点（最右侧）
        if (depth == res.size()) {
            res.add(node.val);
        }
        // 关键：先遍历右子树，再左子树（右中左）
        //这里没有中是因为一方面开始的调用dfs已经算是中了，第二每一个节点都算是一个
        //根节点，中般指的是进行的操作
        dfs(node.right, depth + 1, res);
        dfs(node.left, depth + 1, res);
    }
}
