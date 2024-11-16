class Solution {
    //tc - O(log(m*n))
     //sc - O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int len = m * n;
        int s = 0, e = len-1;
        while(s<=e){
            int mid = (s+e)/2;
            int i = mid / n;
            int j = mid % n;
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return false;
    }

    //tc - O(row + log(col))
    //sc - O(1)
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0;i<m;i++){
            if(matrix[i][n-1] >target){
                return bSearch(matrix[i], 0, n-2, target);
            }else if(matrix[i][n-1] == target){
                return true;
            }
        }
        return false;
    }

    boolean bSearch(int[] arr, int s, int e, int target){
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return false;
    }
}