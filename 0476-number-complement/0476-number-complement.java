class Solution {
    public int findComplement(int n) {
        if(n==0) return 1;
        int ans=0,bitIndex=0;
        while(n>1){
            if((n & 1) == 0){
                ans += (1<<bitIndex);
            }
            n = n>>1;
            bitIndex++;
        }
        return ans;
    }
}