class Solution {

    //tab
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        Arrays.fill(prev,-1);

        for(int i=0;i<triangle.get(n-1).size();i++){
            prev[i] = triangle.get(n-1).get(i);
        }

        for(int i = n-2;i>=0;i--){
            int[] curr = new int[n];
            Arrays.fill(curr,-1);
            for(int j = i;j >= 0;j--){
                int down = triangle.get(i).get(j) + prev[j];
                int diagonal = triangle.get(i).get(j) + prev[j+1];

                int min = Math.min(down,diagonal);
                curr[j] = min;
            }
            prev=curr;
        }

        return prev[0];
    }

    public int minimumTotal_memoization(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return utils(triangle, 0,0,dp);
    }

    private int utils(List<List<Integer>> triangle, int r, int c,int[][] dp){
        if(r == triangle.size()-1){
             dp[r][c] = triangle.get(r).get(c);
            return triangle.get(r).get(c);
        }

        if(dp[r][c] != -1) return dp[r][c];

        int down = triangle.get(r).get(c) + utils(triangle, r+1, c,dp);
        int diagonal = triangle.get(r).get(c) + utils(triangle, r+1, c+1,dp);

        int min = Math.min(down,diagonal);
        dp[r][c] = min;
        return dp[r][c];
    }
}