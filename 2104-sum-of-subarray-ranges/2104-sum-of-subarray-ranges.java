class Solution {
    
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public long sumSubarrayMaxs(int[] arr) {
        long sum=0;
        int n=arr.length;
        int[] nge = findNGEE(arr);
        int[] pge = findPGE(arr);

        for(int i=0;i<n;i++){
            int left = i-pge[i];
            int right = nge[i]-i;
            long freq = (1L*right*left);
            sum += (freq * arr[i]);
        }
        return sum;
    }

    public long sumSubarrayMins(int[] arr) {
        long sum=0;
        int n=arr.length;
        int[] nse = findNSEE(arr);
        int[] pse = findPSE(arr);

        for(int i=0;i<n;i++){
            int left = i-pse[i];
            int right = nse[i]-i;
            long freq = (1L*right*left);
            sum += (freq * arr[i]);
        }
        return sum;
    }

    private int[] findNGEE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            nge[i] = st.empty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    private int[] findPGE(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] pge = new int[n];
 

        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            pge[i] = st.empty()? -1 : st.peek(); 
            st.push(i);
        }

        return pge;
    }

    private int[] findNSEE(int[] arr){
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