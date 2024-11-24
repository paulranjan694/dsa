class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0, n = gas.length,total=0, curr = 0;
        for(int i = 0; i<n;i++){
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];

            if(curr < 0){
                ans = i+1;
                curr = 0;
            }
        }

        return total < 0 ? -1 :ans;
    }
}