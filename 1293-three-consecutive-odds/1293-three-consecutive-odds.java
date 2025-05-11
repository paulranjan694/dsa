class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int right=0,n=arr.length,oddCount=0;
        if(n<3) return false;

        while(right<n){
            if(arr[right] % 2 != 0){
                oddCount++;
                if(oddCount==3){
                    return true;
                }
            }else{
                oddCount=0;
            }
            right++;
        }
        return oddCount==3;
    }
}