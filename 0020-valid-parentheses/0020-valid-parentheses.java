class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.empty()) return false;
                if(ch == ')'){
                    if(st.peek() != '(') return false;
                }else if(ch == '}'){
                    if(st.peek() != '{') return false;
                }else{
                    if(st.peek() != '[') return false;
                }
                st.pop();
            }
        }
        return st.empty() ? true : false;
    }
}