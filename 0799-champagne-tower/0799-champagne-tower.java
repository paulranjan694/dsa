class Solution {
    double[][] memo;
    public double champagneTower(int poured, int query_row, int query_glass) {
        memo = new double[101][101];
        for(double[] t : memo){
            Arrays.fill(t,-1);
        }
        return Math.min(1.0,solve(poured,query_row,query_glass));
    }

    private double solve(int poured, int i, int j){
        if(i<0||j<0||i<j){
            return 0.0;
        }

        if(i==0 && j==0){
            return memo[i][j]=poured;
        }

        if(memo[i][j] != -1) return memo[i][j];

        double leftUp = (solve(poured, i-1,j-1) - 1) /2.0;
        double rightUp = (solve(poured, i-1,j) - 1)/2.0;
        if(leftUp < 0) leftUp = 0.0;
        if(rightUp < 0) rightUp = 0.0;
        return memo[i][j]= leftUp + rightUp;
    }
}