class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int e : piles){
            max = Math.max(max,e);
        }
        
        int low=1,high=max,ans=-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(isPossible(piles, h, mid)){
                ans=mid;
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] arr, int k, int m){
        long hours = 0;
        for(int b : arr){
            hours += b/m;
            hours += (b%m == 0) ? 0 : 1;
        }
        
        return hours<=k;
    }
}