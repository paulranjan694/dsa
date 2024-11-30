class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE, sum=0;
        for(int i=0;i<weights.length;i++){
            max=Math.max(max,weights[i]);
            sum+=weights[i];
        }

        int low = max,high = sum,ans=-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible(weights,mid,days)){
                ans=mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] weights, int capacity, int days){
        int dayCap = 0,total=1;
        for(int i=0;i<weights.length;i++){
            if(dayCap + weights[i] > capacity){
                total++;
                dayCap=weights[i];
            }else {
                dayCap += weights[i];
            }
        }
        //if(dayCap != 0 && dayCap < capacity) total++;
        return total <= days;
    }
}