package hiusu;

public class exist {
	public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        // 遍历所有起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // idx：当前匹配word第idx个字符
    private boolean dfs(char[][] board, int x, int y, String word, int idx) {
        // 全部匹配完成，找到单词
        if (idx == word.length()) return true;
        // 越界 / 当前字符不匹配 / 已走过
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(idx)) {
            return false;
        }
        char temp = board[x][y];
        // 原地标记已访问
        board[x][y] = '#';
        // 上下左右四向搜索
        boolean res = dfs(board, x - 1, y, word, idx + 1)
                || dfs(board, x + 1, y, word, idx + 1)
                || dfs(board, x, y - 1, word, idx + 1)
                || dfs(board, x, y + 1, word, idx + 1);
        // 回溯恢复
        board[x][y] = temp;
        return res;
    }
}
