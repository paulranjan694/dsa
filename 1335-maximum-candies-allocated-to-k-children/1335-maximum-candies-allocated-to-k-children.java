class Solution {
    public int maximumCandies(int[] arr, long k) {
        long totalCandi = 0, max=Integer.MIN_VALUE;

        for(int cand : arr){
            totalCandi += cand;
            max = Math.max(max, cand);
        }
        if(totalCandi < k) return 0;

        long low = 1, high = max;
        int answer=0;

        while(low<=high){
            long mid = (low+high)/2;

            if(isPossible(arr, mid, k)){
                answer = (int)mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return answer;
    }

    private boolean isPossible(int[] arr, long mid, long k) {
        long numOfDiv = 0;
        for(int cand : arr){
            numOfDiv += cand/mid;
        }
        return numOfDiv >= k;
    }
}