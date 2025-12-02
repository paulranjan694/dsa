class Solution {
    private final int MOD = 1_000_000_007;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> mapOfPoints = new HashMap<>();
        for(int i=0;i<points.length;i++){
            mapOfPoints.put(points[i][1], mapOfPoints.getOrDefault(points[i][1], 0)+1);
        }
        
        long sumOfLines = 0, total=0;

        for(int numOfPoints : mapOfPoints.values()){
            long points_ncr = ((long)numOfPoints * (numOfPoints-1))/2;
            total += ((int)points_ncr * sumOfLines) % MOD;
            sumOfLines += points_ncr;
            sumOfLines %= MOD;
            total %= MOD;
        }
        return (int)total;
    }
}

/**
[1,0] - 2
    2,0 3,0 
2,0
    3,0 
2,2

*/