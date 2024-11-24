class Solution {
    public int firstMissingPositive(int[] nums) {
        int max = 0, n= nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            set.add(nums[i]);
        }

        for(int i = 1; i <= max;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max+1;
    }
}