import java.util.*;

class Solution {
    static int N;
    static int result = 0;
    static List<List<int[]>> graph;

    public int solution(int n, int infection, int[][] edges, int k) {
        N = n;
        result = 0;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int type = edge[2];
            graph.get(from).add(new int[]{to, type});
            graph.get(to).add(new int[]{from, type});
        }

        List<Integer> initialVirus = new ArrayList<>();
        boolean[] initialIsVirus = new boolean[n + 1];
        
        initialVirus.add(infection);
        initialIsVirus[infection] = true;

        dfs(0, k, initialVirus, initialIsVirus);

        return result;
    }

    static void dfs(int depth, int k, List<Integer> currentVirus, boolean[] currentIsVirus) {
        result = Math.max(result, currentVirus.size());

        if (depth == k || result == N) {
            return;
        }

        for (int type = 1; type <= 3; type++) {
            List<Integer> nextVirus = new ArrayList<>(currentVirus);
            boolean[] nextIsVirus = currentIsVirus.clone();

            if (spread(type, nextVirus, nextIsVirus)) {
                dfs(depth + 1, k, nextVirus, nextIsVirus);
            }
        }
    }

    static boolean spread(int type, List<Integer> virus, boolean[] isVirus) {
        boolean changed = false;
        Queue<Integer> q = new ArrayDeque<>();
        
        // 현재 감염된 모든 노드들을 시작점으로 큐에 삽입
        for (int v : virus) {
            q.offer(v);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int[] edge : graph.get(curr)) {
                int nextNode = edge[0];
                int edgeType = edge[1];

                // 선택한 파이프 타입과 일치하고, 아직 감염되지 않은 노드라면 확산
                if (edgeType == type && !isVirus[nextNode]) {
                    isVirus[nextNode] = true;
                    virus.add(nextNode);
                    q.offer(nextNode);
                    changed = true;
                }
            }
        }
        return changed;
    }
}