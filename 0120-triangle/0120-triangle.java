class Solution {
    int NEG = -1_000_00;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<=i;j++){
                list.add(NEG);
            }
            dp.add(list);
        }
        return utils(triangle, n,0,0, dp);
    }

    private int utils(List<List<Integer>> triangle, int n, int r, int c, List<List<Integer>> dp){
        if(r==n-1){
            dp.get(r).set(c,triangle.get(r).get(c));
            return triangle.get(r).get(c);  
        }
        
        if(dp.get(r).get(c) != NEG) return dp.get(r).get(c);


        int mini = Math.min(utils(triangle, n, r+1, c, dp), utils(triangle, n, r+1, c+1, dp)) + triangle.get(r).get(c);
        dp.get(r).set(c,mini);
        return mini;
    }
}