class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalAbsoluteSum = 0, totalNegCount=0, absMinNeg=1_000_000;
        int n = matrix.length, m = matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] < 0){
                    totalNegCount++;
                }
                absMinNeg = Math.min(absMinNeg, Math.abs(matrix[i][j]));
                totalAbsoluteSum += Math.abs(matrix[i][j]);
            }
        }

        if(totalNegCount % 2 != 0){
            totalAbsoluteSum -= 2*absMinNeg;
        }

        return totalAbsoluteSum;
    }
}