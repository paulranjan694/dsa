class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i< n; i++){
           //if(i-1 >= 0 && nums[i]==nums[i-1]) continue;
           while(i>0 && i<n && nums[i-1] == nums[i]) i++;
            int left = i+1, right = n-1;
            while(left < right){
                if(nums[i]+nums[left]+nums[right] == 0){
                    // List<Integer> list = new ArrayList<>();
                    // list.add(nums[i]);
                    // list.add(nums[left]);
                    // list.add(nums[right]);
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                   while(left < right && nums[left -1] == nums[left]) left++;
                }else if(nums[i]+nums[left]+nums[right] > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}