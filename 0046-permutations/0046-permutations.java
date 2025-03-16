class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUtils(nums,result,0);
        return result;
    }

    private void permuteUtils(int[] nums, List<List<Integer>> result, int currIndex){
        //base condition
        if(currIndex==nums.length){
            List<Integer> list= new ArrayList<>();
            for(int num : nums)
                list.add(num);
            result.add(list);
            return;
        }

        for(int index = currIndex;index<nums.length;index++){
            swap(nums,currIndex,index);
            permuteUtils(nums, result, currIndex+1);
            swap(nums,currIndex,index);
        }
    }

    private void swap(int[] nums, int i, int j){
       int t = nums[i];
       nums[i]=nums[j];
       nums[j]=t;
    }
}