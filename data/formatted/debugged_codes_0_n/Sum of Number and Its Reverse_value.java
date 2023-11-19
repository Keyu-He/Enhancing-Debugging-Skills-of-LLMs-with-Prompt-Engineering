class Solution {
    static HashSet<Integer> set = new HashSet<>();

    static {
        for (int i = 0; i <= 100000; i++) {
            set.add(i + Integer.parseInt(new StringBuilder(Integer.toString(i)).reverse().toString()));
        }
    }

    public boolean sumOfNumberAndReverse(int num) {
        return set.contains(num);
    }
}