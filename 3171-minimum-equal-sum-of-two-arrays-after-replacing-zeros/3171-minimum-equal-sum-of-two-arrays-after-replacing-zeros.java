class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long s1=0,s2=0,z1=0,z2=0;

        for(int i=0;i<nums1.length;i++){
            s1+=nums1[i];
            if(nums1[i]==0){
                z1++;
            }
        }

        for(int i=0;i<nums2.length;i++){
            s2+=nums2[i];
            if(nums2[i]==0){
                z2++;
            }
        }


        // if((z1==0 && z2!=0) || (z1!=0 && z2==0)){
        //     return -1;
        // }
        long ans=0;
        long ts1=s1+z1,ts2=s2+z2;
        if(s1==s2){
            if((z1==0 && z2!=0) || (z1!=0 && z2==0)){
                return -1;
            }else{
                s1 += Math.max(z1,z2);
                ans=s1;
            }
        }else if(ts1>ts2){
            s1 += z1;
            if(z2==0){
                ans=-1;
            }else if(z2!=0 && (s1-s2)/z2 == 0){
                ans=-1;
            }else{
                ans=s1;
            }
        }else{
            s2 += z2;
            if(z1==0){
                ans=-1;
            }else if(z1!=0 && (s2-s1)/z1 == 0){
                ans=-1;
            }else{
                ans=s2;
            }
        }
        return ans;
    }
}