class Solution {
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        Set<String> vis = new HashSet<>();
        int mra = getMinRemoval(s);
        
        solve(s,set,mra, vis);

        List<String> res = new ArrayList<>();
        for(String itr : set){
            res.add(itr); 
        }

        return res;
    }

    private void solve(String s, Set<String> set, int mra, Set<String> vis){
        if(mra < 0) return;
        if(vis.contains(s)) return;
        vis.add(s);
        if(mra==0){
            int mr = getMinRemoval(s);
            if(mr==0){
                set.add(s);
            }
            return;
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
            if(i>0 && s.charAt(i)==s.charAt(i-1)) continue;
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            solve(left+right,set,mra-1, vis);
        }
    }

    private int getMinRemoval(String s){
        Stack<Character> st = new Stack<>();

        char[] arr = s.toCharArray();

        for(char c : arr){
            if(c == ')'){
                if(!st.empty() && st.peek() == '('){
                    st.pop();
                }else{
                    st.push(c);
                }
            }else if(c == '('){
                st.push(c);
            }
        }

        return st.size();
    }
}