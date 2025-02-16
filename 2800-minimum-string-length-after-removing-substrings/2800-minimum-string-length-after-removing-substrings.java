class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(!st.empty() && ((st.peek() == 'A' && arr[i]=='B') || (st.peek() == 'C' && arr[i]=='D'))){
                st.pop();
            }else{
                st.push(arr[i]);
            }
        }
        return st.size();
    }
}