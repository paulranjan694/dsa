class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();

        int i=0,j=0,n=pushed.length;
        while(i<n && j<n){
            if(pushed[i]==popped[j]){
                j++;
                while(!st.empty() && pushed[st.peek()] == popped[j]){
                    st.pop();
                    j++;
                }
            }else{
                st.push(i);
            }
            i++;
        }

        while(j<n){
            if(!st.empty() && pushed[st.peek()] == popped[j]){
                st.pop();
            }
            j++;
        }

        return st.empty()?true:false;
    }
}