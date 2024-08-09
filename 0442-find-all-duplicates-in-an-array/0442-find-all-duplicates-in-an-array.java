class Solution {
    // public List<Integer> findDuplicates(int[] nums) {
    //     List<Integer> res = new ArrayList<>();

    //     HashSet<Integer> set = new HashSet<>();

    //     for(int i=0;i<nums.length;i++){
    //         if(set.contains(nums[i])){
    //             res.add(nums[i]);
    //         }else{
    //             set.add(nums[i]);
    //         }
    //     }

    //     return res;
    // }

    //optimizing to constant space
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0){
                res.add(index+1);
            }else
                nums[index] = -1 * nums[index];
        }

        return res;
    }
}