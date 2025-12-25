class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long ans=0;
        int pick=0;

        Arrays.sort(happiness);

        for(int i = n-1;i>=0 && pick < k;i--){
            int val = happiness[i]-pick;
            if(val <= 0) break;
            ans += val;
            pick++;
        }

        
        return ans;
    }
}