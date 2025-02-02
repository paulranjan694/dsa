class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='*'){
                if(!st.empty()){
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.empty()){
            sb.append(st.pop());
        }

        if(sb.length()==0)
            return "";

        String res = sb.reverse().toString();
        return res;
    }
}