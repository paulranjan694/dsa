class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length,m=heights[0].length;

        int[][] distance = new int[n][m];
        
        int[][] directions = {
            { 0, 1 },
            { 1, 0 },
            { -1, 0 },
            { 0, -1 }
        };

        for(int[] dis : distance){
            Arrays.fill(dis,Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minheap = new PriorityQueue<>((int[] a, int[] b) -> a[0] - b[0]);

        minheap.add(new int[]{0,0,0});
        distance[0][0] = 0;

        while(!minheap.isEmpty()){
            int[] pair = minheap.poll();

            int d = pair[0];
            int x = pair[1];
            int y = pair[2];

            for(int[] dir : directions){
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if(x_ >= 0 && x_ < n && y_ >= 0 && y_ < m){
                    int absDis = Math.abs(heights[x][y] - heights[x_][y_]);
                    int tD = Math.max(d,absDis);

                    if(distance[x_][y_] > tD){
                        distance[x_][y_] = tD;
                        minheap.add(new int[]{tD,x_,y_});
                    }
                }
            }
        }
        return distance[n-1][m-1];
    }
}