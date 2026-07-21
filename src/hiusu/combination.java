package hiusu;
import java.util.*;

public class combination {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, target, 0, 0, path, res);
        return res;
    }

    /**
     * @param start 从start下标开始选取，不回头，避免重复组合
     * @param sum 当前路径累加和
     */
    private void backtrack(int[] candidates, int target, int start, int sum,
                           List<Integer> path, List<List<Integer>> res) {
        // 终止：和等于目标，收集答案
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 和超过目标，剪枝，不用继续往下搜
        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            // 选择
            path.add(num);
            sum += num;
            // 重点！下一层依旧从i开始，允许重复选取当前数字
            backtrack(candidates, target, i, sum, path, res);
            // 回溯撤销
            sum -= num;
            path.remove(path.size() - 1);
        }
    }
}
