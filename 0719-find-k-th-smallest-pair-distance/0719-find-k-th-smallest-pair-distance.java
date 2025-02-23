class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0,right=nums[n-1]-nums[0],ans=-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(countPairs(nums,mid) < k){
                left=mid+1;
            }else{
                ans=mid;
                right=mid-1;
            }
        }
        return ans;
    }

    private int countPairs(int[] nums, int D){
        int i=0,j=1,count=0,n=nums.length;
        while(j<n){
            while(nums[j]-nums[i] > D){
                i++;
            }
            count += (j-i);
            j++;
        }
        return count;
    }
}