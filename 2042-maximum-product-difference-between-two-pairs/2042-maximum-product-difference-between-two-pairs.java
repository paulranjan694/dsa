class Solution {
    public int maxProductDifference(int[] nums) {
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE,maxIndex=-1,minIndex=-1,n=nums.length;
        for(int i=0;i<n;i++){
            if(max1 < nums[i]){
                max1=nums[i];
                maxIndex=i;
            }
        }

        for(int i=0;i<n;i++){
            if(max1 >= nums[i] && nums[i] > max2 && maxIndex!=i){
                max2=nums[i];
            }
        }

        for(int i=0;i<n;i++){
            if(min1 > nums[i]){
                min1=nums[i];
                minIndex=i;
            }
        }

        for(int i=0;i<n;i++){
            if(min1 <= nums[i] && nums[i] < min2 && minIndex!=i){
                min2=nums[i];
            }
        }


        return (max1*max2) - (min1*min2);

    }
}