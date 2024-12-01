class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] arr = new int[n+m];

        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(nums1[i] <= nums2[j]){
                arr[k++] = nums1[i];
                i++;
            }else if(nums1[i] > nums2[j]){
                arr[k++] = nums2[j];
                j++;
            }
        }

        while(i<n){
            arr[k++] = nums1[i];
            i++;
        }

        while(j<m){
            arr[k++] = nums2[j];
            j++;
        }

        int m1 = (k-1)/2;
        //if(m1==0) return arr[0];
        if((k-1) % 2 == 0){
            return (double)arr[m1];
        }else{
            double sum = (double)arr[m1] + (double)arr[m1+1];
            return ((sum) /(double)2);
        }
        //return 1.0;
    }
}