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
public class sortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }
	private TreeNode build(int[] nums,int l,int r) {
		if(l > r) return null;
		//中点计算 l + (r - l) / 2 而不是 (l+r)/2：防止 l、r 极大时整型溢出；
		int  mid = l+(r-l)/2;
		TreeNode node=new TreeNode(nums[mid]);
		node.left = build(nums,l,mid-1);
		node.right = build(nums,mid+1,r);
		return node;
	}
}
