class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinationSum(candidates, target, ans, new ArrayList<Integer>(),0);
        return ans;
    }

    public void generateCombinationSum(int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> ds, int idx){
        //base cond
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < candidates.length;i++){
            if(i>idx && candidates[i-1]==candidates[i]) continue;
            if(candidates[i] > target) break;

            ds.add(candidates[i]);
            generateCombinationSum(candidates, target-candidates[i], ans,ds,i+1);
            ds.remove(ds.size()-1);
        }
    }

}