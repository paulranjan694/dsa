class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        utils(n,k,1,ans, new ArrayList<>());
        return ans;
    }

    public void utils(int n, int k, int curr, List<List<Integer>> ans, List<Integer> ds){

        if(curr > n){
            if(ds.size() == k){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(ds.size() == k){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(curr);
        utils(n,k,curr+1,ans,ds);
        ds.remove(ds.size()-1);

         utils(n,k,curr+1,ans,ds);
    }  
}