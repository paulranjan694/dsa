class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0,ans=0;
        for(int e : nums){
            sum += e;
            ans += map.getOrDefault(sum-k, 0);
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}