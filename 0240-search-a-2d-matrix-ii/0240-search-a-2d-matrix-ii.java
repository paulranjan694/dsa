class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length,m=matrix[0].length,i=n-1,j=0;
        while(i>=0 && j<m){
            if(target == matrix[i][j]){
                return true;
            }else if(target > matrix[i][j]){
                j++;
            }else{
                i--;
            }
        }
        return false;
    }
}