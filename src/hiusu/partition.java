package hiusu;

public class partition {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, 0, path, res);
        return res;
    }

    /**
     * @param start 当前分割起点
     * @param path  当前已分割的回文子串列表
     */
    private void backtrack(String s, int start, List<String> path, List<List<String>> res) {
        // 终止条件：分割到字符串末尾，找到一套完整方案
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // i为分割终点，截取 [start, i] 子串
        for (int i = start; i < s.length(); i++) {
            // 剪枝：当前子串不是回文，不进入递归
            if (!isPalindrome(s, start, i)) {
                continue;
            }
            // 选择：截取回文子串加入路径
            String sub = s.substring(start, i + 1);
            path.add(sub);
            // 递归处理下一段，起点更新为 i+1
            backtrack(s, i + 1, path, res);
            // 回溯撤销
            path.remove(path.size() - 1);
        }
    }

    // 判断 s[l~r] 是否回文
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
