class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = candidates.length;
        utils(candidates, target, n-1, res,ds);
        return res;
    }

    private void utils(int[] arr, int tar, int idx, List<List<Integer>> res, List<Integer> ds){
    

        if(tar == 0){
            res.add(new ArrayList<>(ds));
            return;
        }

        if(tar < 0 || idx < 0) return;

        if(tar-arr[idx] >= 0){
            ds.add(arr[idx]);
            utils(arr, tar-arr[idx], idx, res, ds);
            ds.remove(ds.size()-1);
        }

        utils(arr, tar, idx-1, res, ds);
    }
}