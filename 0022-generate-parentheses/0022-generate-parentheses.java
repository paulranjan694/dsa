class Solution {
    public List<String> generateParenthesis(int n) {
        int open=0,close=0;
        List<String> ans= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        utils(open,close,ans,sb,n);
        return ans;
    }

    public void utils(int open, int close, List<String> ans, StringBuilder sb, int n){
        if(open==n && close == n){
            ans.add(sb.toString());
            return;
        }
        if(open<=n){
            sb.append("(");
            utils(open+1,close,ans,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open>close){
            sb.append(")");
            utils(open,close+1,ans,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
      
    }
}