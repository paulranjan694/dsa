class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n1=nums1.length, n2=nums2.length;
        int[] arr = new int[n2];
        for(int i=0;i<n2;i++){
            hm.put(nums2[i],i);
            while(!st.empty() && nums2[st.peek()] < nums2[i]){
                int idx = st.pop();
                arr[idx] = nums2[i];
            }
            st.push(i);
        }
        while(!st.empty()){
            int idx = st.pop();
            arr[idx] = -1;
        }

        int[] ans = new int[n1];
        for(int i=0;i<n1;i++){
            ans[i] = arr[hm.get(nums1[i])];
        }
        return ans;
    }
}