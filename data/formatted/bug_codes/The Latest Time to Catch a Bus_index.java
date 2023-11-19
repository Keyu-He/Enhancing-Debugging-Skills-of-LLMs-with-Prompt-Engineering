class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        HashSet<Integer> set = new HashSet<>();
        for (int val : passengers) {
            set.add(val);
        }
        int n = buses.length;
        int m = passengers.length;
        int solb = capacity;
        int lastPerson = 0;
        int i = 0, j = 0;
        while (i < n && j < m) {
            int cc = capacity;
            while (j < m && cc > 0 && buses[m] >= passengers[j]) {
                cc--;
                lastPerson = passengers[j];
                j++;
            }
            i++;
            solb = cc;
        }
        int x = lastPerson;
        if (solb > 0 || i != n) {
            x = buses[n - 1];
        }
        while (set.contains(x) == true) {
            x--;
        }
        return x;
    }
}