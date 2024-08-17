class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        utils(nums,ans,new ArrayList<Integer>(),new HashSet<Integer>());
        return ans;
    }

    public void utils(int[] nums, List<List<Integer>> ans, ArrayList<Integer> ds, HashSet<Integer> set){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int num:nums){
            if(!set.contains(num)){
                ds.add(num);
                set.add(num);
                utils(nums,ans,ds,set);
                ds.remove(ds.size()-1);
                set.remove(num);
            }
        }
    }
}