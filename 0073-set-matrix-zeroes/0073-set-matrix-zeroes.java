class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowzero = false,colzero=false;
        int n = matrix.length;
        for(int i=0;i<n;i++){
            if(matrix[i][0] == 0){
                rowzero=true;
                break;
            }
        }

        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                colzero=true;
                break;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(rowzero==true){
            for(int i=0;i<n;i++){
                matrix[i][0] = 0;
            }
        }

        if(colzero==true){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
    }
}