class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();
        findSubSets(nums,setsList,new ArrayList<>(),0);
        return setsList;
    }

    private void findSubSets(int[] nums, List<List<Integer>> setsList, List<Integer> ds, int index ){
        //base condition
        if(index >= nums.length){
            List<Integer> newds = new ArrayList<>(ds);
            setsList.add(newds);
            return;
        }

        findSubSets(nums, setsList, ds, index+1);
        ds.add(nums[index]);
        findSubSets(nums, setsList, ds, index+1);
        ds.remove(ds.size()-1);
    }
}