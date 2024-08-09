class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<=rows-3;i++){
            for(int j=0;j<=cols-3;j++){
                if(isMagicSquare(grid,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid,int r, int c){
        //checking magic square grid property - Range -> [1-9] and no duplicates
        int[] visited = new int[10];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num = grid[r+i][c+j];
                if(num < 1 || num > 9 || visited[num] == 1)
                    return false;
                else
                    visited[num] = 1;
            }
        }

        int sum = grid[r][c]+grid[r][c+1]+grid[r][c+2];

        //checking rows and cols sum
        for(int i=0;i<3;i++){
            if(grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != sum)
                return false;

            if(grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i] != sum)
                return false;
        }

        //checking diagonal sum
        if(grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != sum)
            return false;

        //checking anti-diagonal sum
        if(grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != sum)
            return false;

        return true;
    }
}