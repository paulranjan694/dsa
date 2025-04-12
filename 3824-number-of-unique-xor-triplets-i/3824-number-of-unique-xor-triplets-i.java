class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<3) return n;

        int cnt=0;
        while(n > 0){
            n = n >> 1;
            cnt++;
        }
        return 1 << cnt;
    }
}