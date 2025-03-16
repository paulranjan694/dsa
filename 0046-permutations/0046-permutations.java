class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUtils(nums,result,new ArrayList<>(), new HashSet<Integer>());
        return result;
    }

    private void permuteUtils(int[] nums, List<List<Integer>> result, List<Integer> ds, Set<Integer> set){
        //base condition
        if(ds.size()==nums.length){
            List<Integer> newds = new ArrayList<>(ds);
            result.add(newds);
            return;
        }

        for(int num : nums){
            if(set.contains(num)){
                continue;
            }

            ds.add(num);
            set.add(num);
            permuteUtils(nums, result, ds, set);
            ds.remove(ds.size()-1);
            set.remove(num);
        }
    }
}