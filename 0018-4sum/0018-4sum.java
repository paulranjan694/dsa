class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i< n; i++){
           while(i>0 && i<n && nums[i-1] == nums[i]) i++;
           for(int j = i+1; j<n;j++){
               while(j>i+1 && j<n && nums[j-1] == nums[j]) j++;
                int left = j+1, right = n-1;
                while(left < right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum == (long)target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left], nums[right]));
                        left++;
                    while(left < right && nums[left -1] == nums[left]) left++;
                    }else if(sum > (long)target){
                        right--;
                    }else{
                        left++;
                    }
                }
           }
        }
        return res;
    }
}