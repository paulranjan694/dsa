class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0,high = m-1, mini=-10000000;
        
        while(low <= high){
            int mid = (low + high)/2;
            int maxRowIndex = findMaxRow(mat,n,m,mid);
            int left = mid -1 >= 0 ? mat[maxRowIndex][mid-1] : mini;
            int right = mid + 1 < m ? mat[maxRowIndex][mid+1] : mini;
            if(mat[maxRowIndex][mid] >= left && mat[maxRowIndex][mid] >= right){
                return new int[]{maxRowIndex,mid};
            }else if(mat[maxRowIndex][mid] < left){
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        
        return new int[]{};
    }
    
    private int findMaxRow(int[][] mat, int n, int m, int col){
        int max=Integer.MIN_VALUE,index=-1;
        for(int i=0;i<n;i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                index=i;
            }
        }
        return index;
    }
}