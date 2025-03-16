class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUtils(nums,result,0);
        return result;
    }

     private void permuteUtils(int[] nums, List<List<Integer>> result, int currIndex){
        //base condition
        if(currIndex==nums.length){
            List<Integer> list= new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            result.add(list);
            return;
        }

        Set<Integer> uniqueSet = new HashSet<>();

        for(int index = currIndex;index<nums.length;index++){
            //if(isDuplicate(nums,currIndex,index)) continue;
            if(uniqueSet.contains(nums[index])) continue;
            uniqueSet.add(nums[index]);
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

    // private boolean isDuplicate(int[] nums,int start,int end){
    //     for(int i=start;i<end;i++){
    //         if(nums[i] == nums[end]){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}