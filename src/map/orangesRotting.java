package map;

public class orangesRotting {
	public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // 上下左右四个方向偏移量
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // 1. 遍历网格，收集腐烂橘子、统计新鲜橘子
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // 没有新鲜橘子，直接0分钟
        if (fresh == 0) return 0;

        int minutes = 0;
        // 2. 分层BFS，只要有腐烂橘子且还有新鲜橘子就继续扩散
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size(); // 当前层橘子数量（当前分钟全部腐烂源）
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                // 遍历四个相邻格子
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    // 边界合法 + 是新鲜橘子
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // 腐烂
                        fresh--;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            // 一层扩散完成，时间+1
            minutes++;
        }

        // 新鲜橘子为0返回时间，否则返回-1
        return fresh == 0 ? minutes : -1;
    }
}
