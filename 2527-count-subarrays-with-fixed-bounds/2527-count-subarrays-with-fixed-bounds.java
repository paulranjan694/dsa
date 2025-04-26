class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minPos=-1,maxPos=-1,invalidIndex=-1,n=nums.length;
        long ans=0;

        for(int i=0;i<n;i++){
            if(nums[i] < minK || nums[i] > maxK){
                invalidIndex=i;
            }

            if(nums[i] == minK){
                minPos = i;
            }

            if(nums[i] == maxK){
                maxPos = i;
            }

            ans += Math.max(0, Math.min(maxPos,minPos)-invalidIndex);
        }
        return ans;
    }
}