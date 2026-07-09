import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSizes = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) continue;

            int count = 0;
            int curIdx = i;

            while (!visited[curIdx]) {
                visited[curIdx] = true;
                count++;
                curIdx = cards[curIdx] - 1;
            }

            groupSizes.add(count);
        }

        if (groupSizes.size() < 2) {
            return 0;
        }

        Collections.sort(groupSizes);
        int n = groupSizes.size();
        return groupSizes.get(n - 1) * groupSizes.get(n - 2);
    }
}