class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = s.length(), max=0;
        char[] arr = s.toCharArray();

        for(int i=0;i<n;i++){
            if(arr[i] == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    max=Math.max(max, i-st.peek());
                }
            }
        }
        return max;
    }
}