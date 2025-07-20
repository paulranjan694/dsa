class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length,m=grid[0].length;
        if(n==0 || m==0 || grid[0][0] == 1 || grid[n-1][m-1] == 1){
            return -1;
        }

        int[][] directions = {
            { 1, 1 },
            { 0, 1 },
            { 1, 0 },
            { -1, 0 },
            { -1, -1 },
            { 1, -1 },
            { 0, -1 },
            { -1, 1 }
        };

        Queue<int[]> minHeap = new LinkedList<>();
        minHeap.add(new int[]{0,0});

        int level=0;

        while(!minHeap.isEmpty()){
            int size = minHeap.size();
            while(size-- > 0){
                int[] pair = minHeap.poll();
                int x = pair[0];
                int y = pair[1];
        

                if(x==n-1 && y == m-1){
                    return level+1;
                }

                for(int[] dir : directions){
                    int x_ = x+dir[0];
                    int y_ = y+dir[1];

                    if(x_ >= 0 && x_ < n && y_>=0 && y_ < m && grid[x_][y_]==0){
                        minHeap.add(new int[]{x_,y_});
                        grid[x_][y_]=1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}