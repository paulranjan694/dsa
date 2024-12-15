class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length, count=0,sum=0;
        hm.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            count+= hm.getOrDefault(sum-k,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}