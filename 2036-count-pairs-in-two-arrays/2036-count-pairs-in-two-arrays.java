class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long[] a1 = new long[n];

        for(int i=0;i<n;i++){
            a1[i] = nums1[i]-nums2[i];
        }

        Arrays.sort(a1);
        long ans=0;
        int left = 0,right=a1.length-1;
        while(left<=right){
            if(a1[left] + a1[right] > 0){
                ans += right-left;
                right--;
            }else{
                left++;
            }
        }
        // for(int i =0;i<n;i++){
        //     if(a1[i]>0){
        //         ans+=n-i-1;
        //     }else{
        //         int left = i+1,right=a1.length-1;
        //         while(left<=right){
        //             int mid = left + (right - left)/2;
        //             if(a1[i]+a1[mid] > 0){
        //                 right = mid-1;
        //             }else{
        //                 left = mid+1;
        //             }
        //         }
        //         ans += n-left;
        //     }
            
        // }
        return ans;
    }
}