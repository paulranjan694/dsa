class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int numOfSubset = 1 << n;
        List<List<Integer>> ans = new ArrayList<>();
        for(int num=0;num<numOfSubset;num++){
            List<Integer> sublist = new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num & (1<<i)) != 0) sublist.add(nums[i]);
            }
            ans.add(sublist);

        }
        return ans;
    }
}