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
        
        for(int j=0;j<n;j++){
            dp.get(n-1).add(j, triangle.get(n-1).get(j));
        }

        for(int i = n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int down = dp.get(i+1).get(j);
                int diagonal = dp.get(i+1).get(j+1);

                int mini = Math.min(down,diagonal) + triangle.get(i).get(j);
                dp.get(i).add(j,mini);
            }
        }
        return dp.get(0).get(0);
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