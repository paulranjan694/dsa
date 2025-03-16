class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder("(");
        solve(n,result,sb,1,0);
        return result;
    }

    private void solve(int n, List<String> result, StringBuilder sb, int openCount, int closeCount){
        //base condn
        if(sb.length()== 2*n){
            result.add(sb.toString());
            return;
        }

        if(openCount < n){
            sb.append('(');
            openCount++;
            solve(n,result,sb,openCount,closeCount);
            sb.deleteCharAt(sb.length()-1);
            openCount--;
        }


        if(openCount > closeCount){
            sb.append(')');
            closeCount++;
            solve(n,result,sb,openCount,closeCount);
            sb.deleteCharAt(sb.length()-1);
            closeCount--;
        }

    }
}