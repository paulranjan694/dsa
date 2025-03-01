class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int left=0,right=0,points=0,n=calories.length,sum=0;
        while(right<n){
            while(right-left+1 > k){
                sum -= calories[left];
                left++;
            }
            sum+=calories[right];
            if(right-left+1 == k){
                if(sum < lower) points--;
                if(sum > upper) points++;
            }
            right++;
        }
        return points;
    }
}