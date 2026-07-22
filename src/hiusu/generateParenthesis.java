package hiusu;

public class generateParenthesis {
	 public List<String> generateParenthesis(int n) {
	        List<String> res = new ArrayList<>();
	        backtrack(n, 0, 0, new StringBuilder(), res);
	        return res;
	    }

	    /**
	     * @param n 总对数
	     * @param left 已使用左括号
	     * @param right 已使用右括号
	     * @param path 当前拼接的括号字符串
	     */
	    private void backtrack(int n, int left, int right, StringBuilder path, List<String> res) {
	        // 终止：左右括号全部用完
	        if (left == n && right == n) {
	            res.add(path.toString());
	            return;
	        }

	        // 优先尝试放左括号：左括号没用完就可以加
	        if (left < n) {
	            path.append('(');
	            backtrack(n, left + 1, right, path, res);
	            path.deleteCharAt(path.length() - 1); // 回溯
	        }

	        // 放右括号前提：右括号数量 < 左括号，保证合法
	        if (right < left) {
	            path.append(')');
	            backtrack(n, left, right + 1, path, res);
	            path.deleteCharAt(path.length() - 1); // 回溯
	        }
	    }
}
