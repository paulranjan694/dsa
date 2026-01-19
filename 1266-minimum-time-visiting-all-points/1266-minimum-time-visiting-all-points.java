class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int dist=0;

        for(int i=1;i<points.length;i++){
            int x1 = points[i-1][0];
            int y1 = points[i-1][1];

            int x2 = points[i][0];
            int y2 = points[i][1];

            int maxOfX = Math.abs(x2-x1);
            int maxOfY = Math.abs(y2-y1);

            dist += Math.max(maxOfX,maxOfY);
        }

        return dist;
    }
}