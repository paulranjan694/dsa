class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length ,m = matrix[0].length;
        int i=0,j=m-1;
        while(i<n){
            if(target > matrix[i][j]){
                i++;
            }else if(target < matrix[i][j]){
                return bsearch(matrix[i], 0,j-1,target);
            }else{
                return true;
            }
        }
        return false;
    }

     public boolean bsearch(int[] arr,int s,int e,int k){
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid] == k){
                return true;
            }else if(arr[mid] > k){
                e = mid-1;
            }else{
                s=mid+1;
            }
        }
        return false;
    }
}