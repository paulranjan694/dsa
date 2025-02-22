class Solution {
    public int findBestValue(int[] arr, int target) {
        int max = Integer.MIN_VALUE;
        for(int e : arr){
            max= Math.max(max,e);
        }
        int left=0,right=max,minDif = Integer.MAX_VALUE,ans=0;
        while(left<=right){
            int mid = left + (right - left)/2;
            int sum = isPossible(arr,mid);
            if(sum <= target){
                left=mid+1;
            }else{
                right = mid-1;
            }

            if(Math.abs(sum-target) < minDif || (Math.abs(sum-target) == minDif && mid < ans)){
                minDif = Math.abs(sum-target);
                ans=mid;
            }
        }
        return ans;
    }

    private int isPossible(int[] arr, int element){
        int sum = 0;
        for(int e : arr){
           sum += Math.min(e,element);
        }
        return sum;
    }
}