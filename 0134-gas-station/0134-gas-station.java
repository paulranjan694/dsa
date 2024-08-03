class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0,curr=0,ans=0;
        for(int i=0;i<gas.length;i++){
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];

            if(curr < 0){//if curr is -ve, that means the index is not the right index to start off and we can't traverse whole arr
                curr=0;
                ans=i+1;
            }
        }
        return total < 0 ? -1 : ans;//if total diff of gas and cost is -ve, we can traverse whole arr, so return -1
    }
}