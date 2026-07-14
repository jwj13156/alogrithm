package map;

public class numIslands {
	 public int numIslands(char[][] grid) {
	        if (grid == null || grid.length == 0) return 0;
	        int rows = grid.length;
	        int cols = grid[0].length;
	        int count = 0;

	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                if (grid[i][j] == '1') {
	                    count++;
	                    dfs(grid, i, j);
	                }
	            }
	        }
	        return count;
	    }

	    // 把当前连通的陆地全部设为海水
	    private void dfs(char[][] grid, int i, int j) {
	        int rows = grid.length;
	        int cols = grid[0].length;
	        // 越界 或者 当前是水，直接返回
	        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
	            return;
	        }
	        // 标记已访问，原地修改为0
	        grid[i][j] = '0';
	        // 上下左右递归
	        dfs(grid, i - 1, j);
	        dfs(grid, i + 1, j);
	        dfs(grid, i, j - 1);
	        dfs(grid, i, j + 1);
	    }
}
