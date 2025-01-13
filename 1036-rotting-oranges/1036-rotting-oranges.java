class Pair{
    int r, c;
    Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        boolean one = false, two=false;
        for(int i=0;i < n; i++){
            for(int j=0; j < m;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i,j));
                    two=true;
                }else if(grid[i][j]==1){
                    one=true;
                }
            }
        }

        if(one == false && two == false) return 0;

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int time=0;
        while(!queue.isEmpty()){
            int len = queue.size();
            while(len-- > 0){
                Pair p = queue.poll();
                int row = p.r;
                int col = p.c;

                for(int i=0;i<4;i++){
                    int newRow = row + dx[i];
                    int newCol = col + dy[i];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1){
                        queue.add(new Pair(newRow,newCol));
                        grid[newRow][newCol] = 2;
                    }
                }
            }
            time++;
        }

        for(int i=0;i < n; i++){
            for(int j=0; j < m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return time-1;
    }
}