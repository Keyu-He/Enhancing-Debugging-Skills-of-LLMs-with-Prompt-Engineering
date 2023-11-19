class Solution {
    String ans;

    public String crackSafe(int n, int k) {
        int minLen = (int) Math.pow(k, n) + (n - 1);

        dfs("", n, k, new HashSet<String>(), minLen);
        return ans;
    }

    private void dfs(String s, int n, int k, HashSet<String> visited, int minLen) {
        if (s.length() == minLen) {
            ans = s;
            return;
        }
        if (s.length() > minLen) {
            return;
        }

        for (int i = 0; i < k; i++) {
            s += String.valueOf(i);
            String lastN = s.substring(Math.max(0, s.length() - n), s.length());
            if (visited.contains(lastN)) {
                s = s.substring(0, s.length() - 1);
                continue;
            }
            if (lastN.length() == n) {
                visited.add(lastN);
            }

            dfs(s, n, k, visited, minLen);
            if (visited.size() != minLen - n + 1) {
                return;
            }
            visited.remove(lastN);
            s = s.substring(0, s.length() - 1);
        }

    }
}
