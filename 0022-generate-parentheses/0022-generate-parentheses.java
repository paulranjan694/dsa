class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrackSol(n,0,0, ans,"");
        return ans;
    }

    public void backtrackSol(int n, int open, int close, List<String> ans, String s){
        if(s.length() == 2*n){
            ans.add(s);
            return;
        }

        if(open<n){
            backtrackSol(n, open+1,close,ans,s+"(");
        }

         if(open>close){
            backtrackSol(n, open,close+1,ans,s+")");
        }


    }
}