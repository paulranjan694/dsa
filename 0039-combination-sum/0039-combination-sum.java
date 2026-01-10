class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int n = candidates.length;
        utils(candidates, target, n-1, res,ds);
        return res;
    }

    private void utils(int[] arr, int tar, int idx, List<List<Integer>> res, List<Integer> ds){
        if(idx<0) return;
        if(idx==0){
            if(arr[idx]==tar){
                List<Integer> list = new ArrayList<>(ds);
                list.add(arr[idx]);
                res.add(list);
                return;
            }
        }

        if(tar == 0){
            List<Integer> list = new ArrayList<>(ds);
            res.add(list);
            return;
        }

        if(tar-arr[idx] >= 0){
            ds.add(arr[idx]);
            utils(arr, tar-arr[idx], idx, res, ds);

            ds.remove(ds.size()-1);
        }

        utils(arr, tar, idx-1, res, ds);
    }
}