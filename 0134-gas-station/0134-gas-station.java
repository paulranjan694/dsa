class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,curr=0,ans=0;
        for(int i=0;i<gas.length;i++){
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];

            if(curr < 0){
                curr=0;
                ans=i+1;
            }
        }
        return total < 0 ? -1 : ans;
    }
}