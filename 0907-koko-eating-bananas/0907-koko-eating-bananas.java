class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxElement = Integer.MIN_VALUE;
        for(int ele : piles){
            maxElement = Math.max(maxElement, ele);
        }

        int low = 1, high = maxElement,ans=Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low) /2;
            if(findRequiredTime(piles,mid) <= h){
                ans = Math.min(ans,mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public int findRequiredTime(int[] piles, int k){
        int time=0;
        for(int i=0;i<piles.length;i++){
            time+=Math.ceil((double)piles[i]/k);
        }
        return time;
    }
}