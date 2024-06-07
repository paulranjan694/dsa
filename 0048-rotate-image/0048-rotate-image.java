class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for(int i=0,j=0;i<n&&j<n;i++,j++){
            for(int k=j;k<n;k++){
                if(i!=k){
                    swap(matrix,i,k,k,i);
                }
            }
        }
        

        for(int i=0;i<n;i++){
            reverse(matrix[i],0,n-1);
        }
    }

    public void swap(int[][] matrix, int k,int l,int m,int p){
        int t = matrix[k][l];
        matrix[k][l] = matrix[m][p];
        matrix[m][p] = t;
    }

    public void reverse(int[] a,int s,int e){
        while(s<=e){
            int t = a[s];
            a[s] = a[e];
            a[e] = t;
            s++;e--;
        }
    }
}