class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide = 0;

        for(int i = 0; i < n;i++){
            int x1 = bottomLeft[i][0], y1 = bottomLeft[i][1], x2 = topRight[i][0], y2 = topRight[i][1];
            for(int j=i+1; j<n;j++){
                int x3 = bottomLeft[j][0], y3 = bottomLeft[j][1], x4 = topRight[j][0], y4 = topRight[j][1];

                long side = findMaxLength(x1, y1, x2, y2, x3, y3, x4, y4);
                maxSide = Math.max(maxSide,side);
            }
        }

        return maxSide*maxSide;
    }

    private long findMaxLength(int x1,int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        int top_x2 = Math.min(x2,x4);
        int bottom_x1 = Math.max(x1,x3);
        int top_y2 = Math.min(y2,y4);
        int bottom_y1 = Math.max(y1,y3);

        int w = top_x2 - bottom_x1;
        int h = top_y2 - bottom_y1;

        long len = Math.min((long)w,h);

        return len;

    }
}