class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        //if(n==1) return 1;

        Arrays.sort(nums);

        int i=0, min = Integer.MAX_VALUE;

        while(i<n){
            int found = bsearch(nums, (long)nums[i] * k, i, n-1);
            //System.out.println(nums[i] * k+" "+nums[i]+" "+found+ " "+i);
            if(found != -1){
                int ans = i+(n-1-found);
                min = Math.min(min, ans);
            }
            i++;
        }
        return min==Integer.MAX_VALUE ? 0: min;
    }

    private int bsearch(int[] nums, long target, int start, int end){
        int ans=-1;
        while(start<=end){
            int mid = (start + end)/2;
            if((long)nums[mid] <= target){
                ans=mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        return ans;
    }
}