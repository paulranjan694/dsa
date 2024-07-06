class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrackSol(n,0,0, ans,new StringBuilder());
        return ans;
    }

    public void backtrackSol(int n, int open, int close, List<String> ans, StringBuilder s){
        if(s.length() == 2*n){
            ans.add(s.toString());
            return;
        }

        if(open<n){
            s.append("(");
            backtrackSol(n, open+1,close,ans,s);
            s.deleteCharAt(s.length()-1);
        }

         if(open>close){
            s.append(")");
            backtrackSol(n, open,close+1,ans,s);
            s.deleteCharAt(s.length()-1);
        }


    }
}