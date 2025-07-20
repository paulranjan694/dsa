class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length,m=grid[0].length;
        if(n==0 || m==0 || grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return -1;
        }

        int[] dx = new int[]{1,0,1,-1,0,-1,1,-1};
        int[] dy = new int[]{1,1,0,0,-1,-1,-1,1};

        int[][] res = new int[n][m];
        for(int[] r : res){
            Arrays.fill(r,Integer.MAX_VALUE);
        }
        res[0][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((int[] a, int[] b) -> a[0]-b[0]);

        minHeap.add(new int[]{0,0,0});
        grid[0][0]=1;

        while(!minHeap.isEmpty()){
            int[] pair = minHeap.poll();
            int d = pair[0];
            int x = pair[1];
            int y = pair[2];

            if(x==n-1 && y == m-1){
                return d+1;
            }

            for(int i=0;i<8;i++){
                int x_ = x+dx[i];
                int y_ = y+dy[i];

                if(x_ >= 0 && x_ < n && y_>=0 && y_ < m && grid[x_][y_]==0){
                    if(res[x_][y_] > d+1){
                        res[x_][y_] = d+1;
                        minHeap.add(new int[]{d+1, x_,y_});
                    }
                    grid[x_][y_]=1;
                }
            }
        }
        return  -1;
    }
}