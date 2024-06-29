class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n1=nums1.length,n2=nums2.length;
        int[] right = new int[n2];
        st.push(nums2[n2-1]);
        right[n2-1]=-1;
        for(int i=n2-2;i>=0;i--){
            while(!st.empty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.empty())
                right[i]=-1;
            else
                right[i]=st.peek();

            st.push(nums2[i]);
        }

        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<n2;i++){
            map.put(nums2[i],right[i]);
        }

        int[] ans = new int[n1];
        int idx=0;
        for(int e:nums1){
            ans[idx++]=map.get(e);
        }
        return ans;

    }
}