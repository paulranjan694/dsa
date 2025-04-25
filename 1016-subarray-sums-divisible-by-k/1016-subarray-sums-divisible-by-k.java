class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length,answer = 0,prefixSum=0;
        for(int num:nums){
            prefixSum += num;
            int mod = prefixSum % k;
            if(mod<0) mod += k;
            answer += map.getOrDefault(mod, 0);
            map.put(mod,map.getOrDefault(mod, 0)+1);
        }

        return answer;
    }
}