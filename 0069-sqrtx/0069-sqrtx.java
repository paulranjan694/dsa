class Solution {
    public int mySqrt(int x) {
        int low = 1, high = x, ans=0;
        
        while(low <= high){
            int mid = low+ (high - low)/2;
            long prod = (long)mid * mid;
            if(prod == x){
                return mid;
            }else if(prod > x){
                high = mid - 1;
            }else{
                low = mid + 1;
                ans=mid;
            }
        }
        return ans;
    }
}