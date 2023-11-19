class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] index = new int[26];
        String corak = "croak";
        for (int i = 0; i < corak.length(); ++ i)
            index[corak.charAt(i) - 'a'] = i;

        int ans = 0, sum = 0;
        int[] count = new int[5];

        for (char c : croakOfFrogs.toCharArray()) {
            int i = index[c - 'a'];
            if (c != 'c') {
                if (count[i - 1]-- <= 0) return - 1;
                sum--;
            }
            if (c != 'k') {
                count[i]++;
                sum++;
            }
            ans = Math.max(ans, sum);
        }
        return sum == 0 ? ans : - 1;
    }
}