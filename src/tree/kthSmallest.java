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
public class kthSmallest {
	//顺着 BST 中序升序，遍历计数，走到第 k 个直接返回
	int count = 0;
    int res = 0;
	public int kthSmallest(TreeNode root, int k) {
		inOrder(root, k);
        return res;
    }
	void inOrder(TreeNode node, int k) {
        if(node == null) return;
        inOrder(node.left, k);
        // 访问当前节点，计数+1
        count++;
        if(count == k) {
            res = node.val;
            return;
        }
        inOrder(node.right, k);
    }
}
