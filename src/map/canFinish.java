package map;

public class canFinish {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//问题等价于：判断有向图是否存在环
		//无环：可以完成所有课程，返回 true
		//有环：循环依赖，无法完成，返回 false
        // 1. 构建邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 入度数组
        int[] inDegree = new int[numCourses];

        // 边 b -> a，[a,b]
        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

        // 2. 入度为0的节点入队列
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        // 3. BFS
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            // 遍历当前课程的后继
            for (int next : adj.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // 遍历过的课程数量等于总课程 → 无环
        return count == numCourses;
    }
}
