class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] prefixSum = new int[m][n];

        boolean oneLength = false;
        for(int i=0;i<m;i++){
            prefixSum[i][0] = mat[i][0];
            if(mat[i][0] <= threshold){
                oneLength = true;
            }
            for(int j=1;j<n;j++){
                prefixSum[i][j] = prefixSum[i][j-1] + mat[i][j];
                if(mat[i][j] <= threshold){
                    oneLength = true;
                }
            }
        }

        for(int edge = Math.min(m,n);edge>=2;edge--){
            for(int i=0;i+edge<=m;i++){
                for(int j=0;j+edge<=n;j++){
                    int sum=0;
                    for(int k = i;k<i+edge;k++){
                        sum += prefixSum[k][j+edge-1] - (j>0 ? prefixSum[k][j-1] : 0);
                        if(sum > threshold)break;
                    }
                    if(sum > threshold) continue;
                    if(sum <= threshold) return edge;
                }
            }
        }

        return oneLength ? 1 : 0;
    }
}