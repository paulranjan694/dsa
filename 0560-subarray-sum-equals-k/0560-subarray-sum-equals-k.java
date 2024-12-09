class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        int n = nums.length, sum=0,ans=0;
        hm.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            //if(sum==k) ans++;
            if(hm.containsKey(sum-k)){
                ans+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}