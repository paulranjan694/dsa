class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length ,m = matrix[0].length;
        int i=n-1,j=0;
        boolean ans = false;
        while(i>=0 && j<m){
            if(target == matrix[i][j]){
                return true;
            }else if(ans == false && target > matrix[i][j]){
                //ans = ans || bsearch(matrix[i], j+1,m-1,target);
                j++;
            }else
            i--;
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