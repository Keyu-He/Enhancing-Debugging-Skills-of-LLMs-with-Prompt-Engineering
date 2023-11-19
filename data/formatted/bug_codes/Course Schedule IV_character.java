class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int e[] : prerequisites) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
        }

        List<Boolean> list = new ArrayList<>();
        for (int[] q : queries) {
            list.add(isPre(q[0], q[1], graph, new HashSet<>()));
        }
        return list;
    }

    private boolean isPre(int src, int dst, Map<Integer, List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(src)) return false;
        visited.add(src);
        for (int neigh : adj.getOrDefault(src, new ArrayList<>())) {
            if (neigh == dst || isPre(neigh, dst, adj, visited)) return true;
        }
        return false;
    }
}