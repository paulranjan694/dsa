class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(solve(landStartTime,landDuration, waterStartTime, waterDuration), solve(waterStartTime, waterDuration, landStartTime, landDuration));
    }

    private int solve(int[] firstStartTime, int[] firstDuration, int[] secondStartTime, int[] secondDuration){
        int firstEnd = Integer.MAX_VALUE;

        for(int i=0;i<firstStartTime.length;i++){
            firstEnd = Math.min(firstEnd,firstStartTime[i]+firstDuration[i]);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<secondStartTime.length;i++){
            ans = Math.min(ans,Math.max(firstEnd,secondStartTime[i])+secondDuration[i]);
        }
        return ans;
    }
}