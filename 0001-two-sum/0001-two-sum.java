class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int newTarget = target - nums[i];
            int index = map.getOrDefault(newTarget,-1);
            if(index >= 0){
                return new int[] {index,i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }
}