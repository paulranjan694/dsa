class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> dp = new ArrayList<>();
        
        
        for(int j=0;j<n;j++){
            dp.add(j, triangle.get(n-1).get(j));
        }

        for(int i = n-2;i>=0;i--){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<=i;j++){
                int down = dp.get(j);
                int diagonal = dp.get(j+1);

                int mini = Math.min(down,diagonal) + triangle.get(i).get(j);
                curr.add(j,mini);
            }
            dp = curr;
        }
        return dp.get(0);
    }
}