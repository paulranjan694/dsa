class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int cnt = 0, sum = 0, n = nums.length;
        hm.put(0,1);

        for(int i = 0; i < n; i++){
            sum+=nums[i];
            if(hm.containsKey(sum-k)){
                cnt += hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;

    }
}