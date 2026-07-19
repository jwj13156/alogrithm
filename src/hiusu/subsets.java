package hiusu;

public class subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTrack(nums, 0, path, result);
        return result;
    }

    /**
     * @param start 本次循环从哪个下标开始取，保证只往后取，不重复
     */
    private void backTrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        // 当前path就是一个子集，直接存入结果
        res.add(new ArrayList<>(path));

        // 只从start往后遍历，不回头
        for (int i = start; i < nums.length; i++) {
            // 选择当前数字
            path.add(nums[i]);
            // 下一层只能选 i 之后的元素，i+1
            backTrack(nums, i + 1, path, res);
            // 回溯撤销选择
            path.remove(path.size() - 1);
        }
    }
}
