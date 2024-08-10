class Solution {
    public static Set<String> set = new HashSet<>(); 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        utils(nums,0,ans,new ArrayList<>());
        return ans; 
    }

    public void utils(int[] nums, int idx, List<List<Integer>> ans, ArrayList<Integer> ds){
       
            ans.add(new ArrayList<>(ds));
  

        for(int i =idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            utils(nums, i+1, ans, ds);
            ds.remove(ds.size()-1);

        }
    }
}