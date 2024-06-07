class Solution {
    public void setZeroes(int[][] matrix) {
                boolean row=false,col=false;
        int n=matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<m;i++){
            if(matrix[0][i] == 0){
                row=true;
                break;
            }
        }

        for(int i=0;i<n;i++){
            if(matrix[i][0] == 0){
                col=true;
                break;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j]=0;
                }
            }
        }

        if(row==true){
            for(int i=0;i<m;i++){
                matrix[0][i] = 0;
            }
        }

        if(col==true){
            for(int i=0;i<n;i++){
                matrix[i][0] = 0;
            }
        }
    }
}