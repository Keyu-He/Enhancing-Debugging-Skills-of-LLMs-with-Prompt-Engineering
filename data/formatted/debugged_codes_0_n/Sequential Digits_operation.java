```java
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int lowSize = String.valueOf(low).length(), highSize = String.valueOf(high).length();
        List<Integer> output = new ArrayList<>();

        for (int size = lowSize; size <= highSize; size++) {
            int seedNumber = getSeedNumber(size);
            int increment = getIncrement(size);
            int limit = (int) Math.pow(10, size);
            while (true) {
                if (seedNumber >= low && seedNumber <= high)
                    output.add(seedNumber);
                if (seedNumber % 10 == 9 || seedNumber > high) break;
                seedNumber += increment;
            }
        }
        return output;
    }

    private int getSeedNumber(int size) {
        int seed = 1;
        for (int i = 1; i <= size; i++) //changed i = 2 to i = 1
            seed = 10 * seed + i;
        return seed;
    }

    private int getIncrement(int size) {
        int increment = 1;
        for (int i = 1; i <= size; i++) //changed i = 2 to i = 1
            increment = 10 * increment + 1; //changed -1 to +1
        return increment;
    }
}
```