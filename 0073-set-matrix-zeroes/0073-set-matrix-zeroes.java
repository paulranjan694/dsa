class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean fillcol=false, fillrow=false;
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
               fillcol = true;
               break;
            }
        }

        for(int j=0;j<m;j++){
            if(matrix[0][j]==0){
               fillrow = true;
               break;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //fill zeros
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0] == 0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }



        if(fillcol){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }

        if(fillrow){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
    }
}