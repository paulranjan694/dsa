class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                res.add(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }

        return res;
    }
}