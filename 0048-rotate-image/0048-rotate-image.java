class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n;i++){
            for(int j=i+1; j < n; j++){
                if(i!=j){
                    swap(matrix,i,j,j,i);
                }
            }
        }

        for(int i = 0; i < n;i++){
            reverse(matrix[i]);
        }
    }

    private void reverse(int[] nums){
        int s=0;
        int e = nums.length-1;
        while(s<=e){
            int t = nums[s];
            nums[s]=nums[e];
            nums[e] = t;
            s++;e--;
        }
    }

    private void swap(int[][] nums, int i, int j, int k, int m){
        int t = nums[i][j];
        nums[i][j]=nums[k][m];
        nums[k][m] = t;
    }
}