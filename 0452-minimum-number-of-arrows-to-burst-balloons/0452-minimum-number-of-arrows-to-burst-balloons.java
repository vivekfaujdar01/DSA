class Solution {
    // this is a overlapping problem
    // we sort the array by Xend and check if two balloons are in overlapping region 
    // if yes then we need only 1 arrow for shot them 
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;

        long arrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}