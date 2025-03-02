class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length,m=matrix[0].length;
        int top = 0, bottom=n-1,left=0,right=m-1, iteration=0;
        while(iteration < (n*m)){

            //top row
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
                iteration++;
                if(iteration >= (n*m)){
                    return result;
                }
            }
            top++;

            //right
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
                iteration++;
                 if(iteration >= (n*m)){
                    return result;
                }
            }
            right--;

            //bottom
            for(int i=right;i>=left;i--){
                result.add(matrix[bottom][i]);
                iteration++;
                 if(iteration >= (n*m)){
                    return result;
                }
            }
            bottom--;

            //left
            for(int i=bottom;i>=top;i--){
                result.add(matrix[i][left]);
                iteration++;
                 if(iteration >= (n*m)){
                    return result;
                }
            }
            left++;
        }
        return result;
    }
}