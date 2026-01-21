class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        

        Arrays.sort(costs,(a,b) -> (a[0]-a[1]) - (b[0] - b[1]));

       
        int m=n/2, min=0;

        for(int i=0;i<m;i++){
            min += costs[i][0] + costs[m+i][1];
        }

        return min;
     
    }
}