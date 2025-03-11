public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0,power=31;
        while(n!=0){
            res+=(n&1) << power;
            n= n>>>1;
            power--;
        }
        return res;
    }
}