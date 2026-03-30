import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int stage;
        long totalCost;
        int[] hints;

        public Node(int stage, long totalCost, int[] hints) {
            this.stage = stage;
            this.totalCost = totalCost;
            this.hints = hints;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.totalCost, o.totalCost);
        }
    }

    public long solution(int[][] cost, int[][] hint) {
        Map<String, Long> minCostMap = new HashMap<>();
        int n = cost.length;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, new int[n + 1]));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.stage == n) return curr.totalCost;

            String stateKey = generateKey(curr.stage, curr.hints, n);
            
            if (minCostMap.getOrDefault(stateKey, Long.MAX_VALUE) <= curr.totalCost) continue;
            minCostMap.put(stateKey, curr.totalCost);

            // 현재 스테이지에서 사용 가능한 힌트권 개수
            int available = curr.hints[curr.stage + 1];
            int maxUse = Math.min(available, n - 1);

            for (int use = 0; use <= maxUse; use++) {
                long solveCost = cost[curr.stage][use];
                long nextBaseCost = curr.totalCost + solveCost;

                int[] nextHintsBase = curr.hints.clone();
                nextHintsBase[curr.stage + 1] = 0;

                pq.add(new Node(curr.stage + 1, nextBaseCost, nextHintsBase));

                if (curr.stage < n - 1) {
                    int[] bundle = hint[curr.stage];
                    long bundlePrice = bundle[0];
                    
                    int[] nextHintsWithBundle = nextHintsBase.clone();
                    for (int i = 1; i < bundle.length; i++) {
                        nextHintsWithBundle[bundle[i]]++;
                    }
                    
                    pq.add(new Node(curr.stage + 1, nextBaseCost + bundlePrice, nextHintsWithBundle));
                }
            }
        }

        return -1;
    }

    private String generateKey(int stage, int[] hints, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(stage).append("_");

        for (int i = stage + 1; i <= n; i++) {
            sb.append(hints[i]).append(",");
        }
        return sb.toString();
    }
}