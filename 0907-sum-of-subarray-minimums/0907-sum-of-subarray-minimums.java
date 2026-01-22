class Solution {
    private final int MOD = 1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        int sum=0,n=arr.length;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        for(int i=0;i<n;i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            long freq = (1L*right*left)%MOD;
            sum += (freq * arr[i]) % MOD;
            sum %= MOD;
        }
        return sum;
    }

    private int[] findNSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] findPSE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pse = new int[n];
 

        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            pse[i] = st.empty()? -1 : st.peek(); 
            st.push(i);
        }

        return pse;
    }
}