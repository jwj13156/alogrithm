package hiusu;

public class letterCombinations {
	 // 下标对应数字，存对应字母
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        // 空字符串直接返回空集合
        if (digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder());
        return res;
    }

    // index：当前处理第几位数字
    private void backtrack(String digits, int index, StringBuilder path) {
        // 终止条件：所有数字处理完毕
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        // 获取当前数字对应的字母串
        String letters = map[digits.charAt(index) - '0'];
        // 遍历当前数字所有可选字母
        for (char c : letters.toCharArray()) {
            path.append(c);        // 选择
            backtrack(digits, index + 1, path); // 处理下一位数字
            path.deleteCharAt(path.length() - 1); // 回溯撤销
        }
    }
}
