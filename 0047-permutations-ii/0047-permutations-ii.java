class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUtils(nums,result,0, new HashSet<String>());
        return result;
    }

     private void permuteUtils(int[] nums, List<List<Integer>> result, int currIndex, Set<String> ds){
        //base condition
        if(currIndex==nums.length){
            List<Integer> list= new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int num : nums){
                list.add(num);
                sb.append(num);
            }

            String permuateString = sb.toString();
            if(!ds.contains(permuateString)){
                result.add(list);
                ds.add(permuateString);
            }
            return;
        }

        for(int index = currIndex;index<nums.length;index++){
            swap(nums,currIndex,index);
            permuteUtils(nums, result, currIndex+1,ds);
            swap(nums,currIndex,index);
        }
    }

    private void swap(int[] nums, int i, int j){
       int t = nums[i];
       nums[i]=nums[j];
       nums[j]=t;
    }
}