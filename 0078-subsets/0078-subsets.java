class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        utils(nums,0,ans,new ArrayList<>());
        return ans;
    }

    public void utils(int[] nums, int idx, List<List<Integer>> ans, ArrayList<Integer> ds){
        if(idx == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        utils(nums, idx+1, ans, ds);
        ds.add(nums[idx]);
        utils(nums, idx+1, ans, ds);
        ds.remove(ds.size()-1);
    }
}