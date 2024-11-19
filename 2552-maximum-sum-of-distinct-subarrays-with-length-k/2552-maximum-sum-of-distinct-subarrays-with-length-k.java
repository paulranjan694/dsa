class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();

        int l = 0,r=0,n=nums.length;
        long max=0,sum=0;

        for(r=0;r<n;r++){
            if(hm.size() == k){
                max=Math.max(max,sum);
                int prev = nums[l];
                l++;
                sum-=prev;
                hm.remove(prev);
            }

            int curr = nums[r];
            while(hm.containsKey(curr)){
                int prev = nums[l];
                l++;
                sum-=prev;
                hm.remove(prev);
            }

            sum+= curr;
            hm.put(curr,1);

        }
        if(hm.size() == k)
            max=Math.max(max,sum);
        return max;
    }
}