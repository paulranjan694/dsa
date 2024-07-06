class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        return backtrackSol(n,0,0, ans,"");
    }

    public List<String> backtrackSol(int n, int open, int close, List<String> ans, String s){
        if(s.length() == 2*n){
            ans.add(s);
            return ans;
        }

        //  List<String> list1 = new ArrayList<>();
        //  List<String> list2 = new ArrayList<>();
        if(open<n){
            backtrackSol(n, open+1,close,ans,s+"(");
        }

         if(open>close){
            backtrackSol(n, open,close+1,ans,s+")");
        }

        // for(String e:list1){
        //     ans.add(e);
        // }
        
        // for(String e:list2){
        //     ans.add(e);
        // }


        return ans;

    }
}