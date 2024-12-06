class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxsum = 0,sum=0,n=cardPoints.length;
        for(int l = 0;l<k;l++){
           sum+=cardPoints[l];
           maxsum=sum;
        }

        int r = n-1;
        for(int l = k-1;l>=0;l--){
            sum-=cardPoints[l];
            sum+=cardPoints[r];
            maxsum=Math.max(maxsum,sum);
            r--;
        } 
        return maxsum;
    }
}