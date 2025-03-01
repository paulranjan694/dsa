class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length,right=0,left=0;
        if(n==1) return false;
        Map<Integer,Integer> hash = new HashMap<>();
        while(right <= k && right < n){
            if(hash.containsKey(nums[right])){
                return true;
            }
            hash.put(nums[right],hash.getOrDefault(nums[right], 0)+1);
            right++;
        }

        while(right<n){
            hash.put(nums[left],hash.get(nums[left])-1);
            if(hash.get(nums[left])==0){
                hash.remove(nums[left]);
            }
            left++;

            if(hash.containsKey(nums[right])){
                return true;
            }
            hash.put(nums[right],hash.getOrDefault(nums[right], 0)+1);
            right++;
        }
        return false;
    }
}