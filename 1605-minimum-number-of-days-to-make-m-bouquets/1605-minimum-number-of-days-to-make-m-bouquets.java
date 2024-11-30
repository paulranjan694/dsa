class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max =Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int e: bloomDay){
            max=Math.max(max,e);
            min=Math.min(min,e);
        }

        int low = min,high = max,ans=-1;
        while(low <= high){
            long mid = (long)low + (high - low)/2;
            if(isPossible(bloomDay,m,k,mid)){
                ans = (int)mid;
                high = (int)mid-1;
            }else{
                low = (int)mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] bloomDay, int m, int k, long day){
        int n=bloomDay.length;
        long cnt=0,total=0;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                cnt++;
            }else{
                total+=(int)(cnt/k);
                cnt=0;
            }
        }
        total+=(int)(cnt/k);
        return m<=total;
    }
}