class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans=-1;
        int s = 1, e = maxElement(piles);
        while(s<=e){
            int mid = (s+e)/2;
            if(isPossible(piles,h,mid)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }

        }
        return ans;
    }

    public int maxElement(int[] piles){
        int max=Integer.MIN_VALUE;
        for(int e : piles){
            max=Math.max(e,max);
        }
        return max;
    }

    public boolean isPossible(int[] piles,int h, int speed){
        int count=0;
         for(int e : piles){
            count+=Math.ceil((double)e/(double)speed);
        }
        return count <= h;
    }


}