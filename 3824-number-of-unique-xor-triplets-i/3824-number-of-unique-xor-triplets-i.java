class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<3) return n;

        int cnt=0;
        while((1<<cnt) <= n){
            cnt++;
        }
        return 1 << cnt;
    }
}