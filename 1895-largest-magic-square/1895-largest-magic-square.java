class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] rowPrefixSum = new int[n][m];
        int[][] colPrefixSum = new int[n][m];

        //row prefix sum
        for(int i=0;i<n;i++){
            rowPrefixSum[i][0] = grid[i][0];
            for(int j=1;j<m;j++){
                rowPrefixSum[i][j] = rowPrefixSum[i][j-1] + grid[i][j];
            }
        }

        //col prefix sum
        for(int j=0;j<m;j++){
            colPrefixSum[0][j] = grid[0][j];
            for(int i=1;i<n;i++){
                colPrefixSum[i][j] = colPrefixSum[i-1][j] + grid[i][j];
            }
        }

        int maxSidePossible = Math.min(n,m);

        for(int edge=maxSidePossible; edge>=2;edge--){
            for(int i=0;i+edge<=n;i++){
                for(int j=0;j+edge<=m;j++){

                    int sum = rowPrefixSum[i][j+edge-1] - (j > 0 ? rowPrefixSum[i][j-1] : 0);
                    boolean equals = true;
                    for(int ii=i+1;ii<i+edge;ii++){
                        int rowSum = rowPrefixSum[ii][j+edge-1] - (j > 0 ? rowPrefixSum[ii][j-1] : 0);
                        if(sum != rowSum){
                            equals = false;
                            break;
                        }
                    }
                    if(!equals) continue;

                    for(int jj=j;jj<j+edge;jj++){
                        int colSum = colPrefixSum[i+edge-1][jj] - (i > 0 ? colPrefixSum[i-1][jj] : 0);
                        if(sum != colSum){
                            equals = false;
                            break;
                        }
                    }

                    if(!equals) continue;

                    int d1=0,d2=0;
                    for(int k=0;k<edge;k++){
                        d1 += grid[i+k][j+k];
                        d2 += grid[i+k][j + edge - 1 - k];
                    }

                    if(d1 == sum && d2 ==sum){
                        return edge;
                    }

                }
            }
        }
        
        return 1;
    }
}