class Solution {
    public int[][] generateMatrix(int n) {
        int left=0,top=0,right=n-1,bottom=n-1;
        int[][] ans = new int[n][n];

        int count = 1;

        while(count <= n*n){
            //top row
            for(int i=left;i<=right;i++){
               ans[top][i]=count++;
            }
            top++;
           

            //right col
            for(int i=top;i<=bottom;i++){
                 ans[i][right]=count++;
            }
            right--;
                        
            //bottom row
            for(int i=right;i>=left;i--){
                 ans[bottom][i]=count++;
            }
            bottom--;
           
            //left col
            for(int i=bottom;i>=top;i--){
                 ans[i][left]=count++;
            }
            left++;
        }
        return ans;
    }
}