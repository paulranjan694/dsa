class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                int a = st.pop();
                int res=0;
                if(s.equals("+")){
                    res = a + st.peek();
                }else if(s.equals("-")){
                    res = st.peek() - a;
                }else if(s.equals("/")){
                    res = st.peek() / a;
                }else{
                    res = a * st.peek();
                }
                st.pop();
                st.push(res);
            }else{
                st.push(Integer.valueOf(tokens[i]));
            }
        }

        return st.peek();
    }
}