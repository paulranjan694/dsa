class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,results,result,0);
        return results;
    }
    private void helper(int[] nums, List<List<Integer>> results, List<Integer> result, int idx){
        if(idx>=nums.length){
            results.add(new ArrayList<>(result));
            return;
        }

        result.add(nums[idx]);//pick
        helper(nums,results,result,idx+1);
        result.remove(result.size()-1);

        while(idx+1 < nums.length && nums[idx] == nums[idx+1]){
            idx++;
        }

        helper(nums,results,result,idx+1);
    }
}