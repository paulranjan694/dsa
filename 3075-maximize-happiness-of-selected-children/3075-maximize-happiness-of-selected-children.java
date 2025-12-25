class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long ans=0;
        int pick=0;

        Arrays.sort(happiness);

        for(int i = n-1;i>=0 && pick < k;i--){
            ans += Math.max(happiness[i]-pick,0);
            pick++;
        }

        
        return ans;
    }
}