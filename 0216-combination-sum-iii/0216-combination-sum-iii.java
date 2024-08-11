class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        utils(k,n,1,0,new ArrayList<Integer>(),ans);
        return ans;
    }

    public void utils(int k, int n, int num, int sum, List<Integer> ds,List<List<Integer>> ans){
        //base cond
        if(k==ds.size()){
            if(n==sum){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(sum>n || num>9) return;

        ds.add(num);
        utils(k,n,num+1,sum+num,ds,ans);
        ds.remove(ds.size()-1);

        utils(k,n,num+1,sum,ds,ans);
    }
}