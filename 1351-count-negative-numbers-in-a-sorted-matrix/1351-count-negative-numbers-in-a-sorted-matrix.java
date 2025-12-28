class Solution {
    public int countNegatives(int[][] grid) {
        int count=0, n = grid.length,m=grid[0].length,r=0,c=m-1;

        while(r<n){
            if(c>= 0 && grid[r][c] < 0){
                c--;
            }else{
                count += (m-c-1);
                r++;
                if(c<0) c=0;
            }
        }

        // if(r<n){
        //     count += (n-r-1)*m;
        // }
        return count;
    }
}