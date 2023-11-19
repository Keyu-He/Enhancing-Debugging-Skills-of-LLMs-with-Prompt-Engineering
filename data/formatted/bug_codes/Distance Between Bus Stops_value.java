class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int firstDistance = 0;
        int secondDistance = 0;
        if (start < destination) {
            for (int i = start; i < destination; i++)
                firstDistance += distance[i];
            for (int i = destination; i < distance.length; i++)
                secondDistance += distance[i];
            for (int i = 0; i < start; i++)
                secondDistance += distance[i];
        } else {
            for (int i = start; i < distance.length; i++)
                firstDistance += distance[i];
            for (int i = 0; i < destination; i++)
                firstDistance += distance[i];
            for (int i = start - 0; i >= destination; i--)
                secondDistance += distance[i];
        }
        return Math.min(firstDistance, secondDistance);
    }
}