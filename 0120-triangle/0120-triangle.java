class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        return minTotal(triangle, n-1,n,dp);
    }

    private int minTotal(List<List<Integer>> triangle, int n, int idx, int[][] dp){
        //if(n < 0 || idx < 0 || idx >triangle.get(n).size()) return 0;
        if(n==0){
            dp[n][idx] = triangle.get(n).get(0);
            return triangle.get(n).get(0);
        }

        int min = Integer.MAX_VALUE;
        if(idx >= 0 && dp[n][idx] != -1) return dp[n][idx];
        if(idx >= 0 && idx < triangle.get(n).size()){
            int path1 = Integer.MAX_VALUE ,path2 = Integer.MAX_VALUE;
            if(idx < triangle.get(n-1).size())
                path1 = minTotal(triangle,n-1,idx,dp) + triangle.get(n).get(idx);

            if(idx - 1 >= 0 && idx-1 < triangle.get(n-1).size())
                path2 = minTotal(triangle,n-1,idx-1,dp) + triangle.get(n).get(idx);

            min = Math.min(min,path1);
            min = Math.min(min,path2);
        }else{
            for(int i=0;i<triangle.get(n).size();i++){
                int path1 = Integer.MAX_VALUE ,path2 = Integer.MAX_VALUE;
                if(i < triangle.get(n-1).size())
                    path1 = minTotal(triangle,n-1,i,dp) + triangle.get(n).get(i);

                if(i - 1 >= 0 && i-1 < triangle.get(n-1).size())
                    path2 = minTotal(triangle,n-1,i-1,dp) + triangle.get(n).get(i);

                min = Math.min(min,path1);
                min = Math.min(min,path2);
            }
        }
        
        dp[n][idx] = min;
        return min;
    }
}