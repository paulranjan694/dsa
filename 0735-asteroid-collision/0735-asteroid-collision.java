class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length; 
        for(int i=0;i<n;i++){
            while(!st.empty() && i<n && (st.peek()>0 && arr[i]<0) && Math.abs(st.peek()) <= Math.abs(arr[i])){
                int e = st.pop();
                if(Math.abs(e) == Math.abs(arr[i]))
                    i++;
            }

            if(!st.empty() && i<n && ((st.peek()>0 && arr[i]>0) || (st.peek()<0 && arr[i]<0)|| (st.peek()<0 && arr[i]>0))){
                st.push(arr[i]);
            }

            if(st.empty() && i<n) st.push(arr[i]);
        }

        int[] ans = new int[st.size()];
        int idx=ans.length-1;
        while(!st.empty()){
            ans[idx--] = st.pop();
        }

        return ans;
    }
}