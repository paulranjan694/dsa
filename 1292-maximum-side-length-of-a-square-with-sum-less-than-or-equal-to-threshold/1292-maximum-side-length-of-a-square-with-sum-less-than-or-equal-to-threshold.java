class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] prefixSum = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                prefixSum[i][j] = mat[i][j];
                if(i>0){
                    prefixSum[i][j] += prefixSum[i-1][j];
                }

                if(j>0){
                    prefixSum[i][j] += prefixSum[i][j-1];
                }

                if(i>0 && j>0){
                    prefixSum[i][j] -= prefixSum[i-1][j-1];
                }
            }
        }

        int best = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int limit = Math.min(m-i,n-j);
        
                for(int k = 0;k<limit;k++){
                    int r = i+k,c=j+k;
                    int sum = squareSum(i,j,r,c, prefixSum);
                    if(sum <= threshold){
                        best = Math.max(best,k+1);
                    }else{
                        break;
                    }
                }
            }
        }
        return best;
    }

    private int squareSum(int i, int j, int r, int c, int[][] prefixSum){
        int sum = prefixSum[r][c];

        if(i>0){
            sum -= prefixSum[i-1][c];
        }

        if(j > 0){
            sum -= prefixSum[r][j-1];
        }

        if(i>0 && j>0){
            sum += prefixSum[i-1][j-1];
        }

        return sum;
    }

}