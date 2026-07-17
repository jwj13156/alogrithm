package hiusu;

public class permute {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, path, res);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        // 终止条件：路径长度等于数组长度，得到一组全排列
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历所有数字
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // 当前数字已选，跳过

            // 选择
            used[i] = true;
            path.add(nums[i]);
            // 递归
            backtrack(nums, used, path, res);
            // 回溯撤销选择
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
