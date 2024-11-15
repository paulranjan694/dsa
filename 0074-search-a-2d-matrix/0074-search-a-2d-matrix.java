class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0;i<m;i++){
            if(matrix[i][n-1] >target){
                if(bSearch(matrix[i], 0, n-1, target) == true){
                    return true;
                }else{
                    return false;
                }
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