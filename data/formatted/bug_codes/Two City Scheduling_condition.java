class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> Integer.compare(c2[1] - c2[0], c1[1] - c1[0]));
        int minCost = 0;
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            minCost += i > n / 2 ? costs[i][0] : costs[i][1];
        }
        return minCost;
    }
}
