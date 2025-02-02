class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];

        for(int i = 0;i<n;i++){
            if(st.empty()){
                st.push(i);
            }else{
                while(!st.empty() && temperatures[st.peek()] < temperatures[i]){
                    int idx = st.pop();
                    ans[idx] = i-idx;
                }
                st.push(i);
            }
        }
        return ans;
    }
}