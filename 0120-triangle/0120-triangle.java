class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
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
}