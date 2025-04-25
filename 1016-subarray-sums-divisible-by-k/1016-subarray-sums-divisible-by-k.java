class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] map = new int[k];
        map[0]=1;
        int n = nums.length,answer = 0,prefixSum=0;
        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            int mod = prefixSum % k;
            if(mod<0) mod += k;
            answer += map[mod];
            map[mod]++;
        }

        return answer;
    }
}