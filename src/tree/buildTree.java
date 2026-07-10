package tree;

public class buildTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int preL, int preR, int[] in, int inL, int inR) {
        //前序定根，中序分左右；
    	//用中序算出左树节点总数，用来切分前序数组的左右区间；
    	//左右区间分别递归生成子树，挂在当前根的 left、right；
    	//区间越界代表无节点，终止递归。
    	if (preL > preR) return null;
        int rootVal = pre[preL];
        TreeNode root = new TreeNode(rootVal);
        // 遍历中序找根位置
        int mid = inL;
        while (in[mid] != rootVal) mid++;
        int leftCnt = mid - inL;
        root.left = build(pre, preL+1, preL+leftCnt, in, inL, mid-1);
        root.right = build(pre, preL+leftCnt+1, preR, in, mid+1, inR);
        return root;
    }
}
