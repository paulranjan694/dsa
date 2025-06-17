class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexedmap = new HashMap<Integer,Integer>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(indexedmap.containsKey(target-nums[i])){
                return new int[]{i,indexedmap.get(target-nums[i])};
            }
            indexedmap.put(nums[i],i);
        }
        return new int[0];
    }
}