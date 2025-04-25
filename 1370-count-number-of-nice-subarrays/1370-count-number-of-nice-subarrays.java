class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length,answer = 0,prefixSum=0;
        for(int num:nums){
            prefixSum += num % 2 == 1 ? 1 : 0;
            answer += map.getOrDefault(prefixSum-k, 0);
            map.put(prefixSum,map.getOrDefault(prefixSum, 0)+1);
        }

        return answer;
    }
}