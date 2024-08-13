class Solution {
    public final int mod = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (long)(n+1)/2;
        long odd = (long)n/2;

        long evenPow = pow(5,even) % mod;
        long oddPow = pow(4,odd) % mod;

        return (int)((evenPow * oddPow) % mod);
    }

    public long pow(int x,long n){
        if(n==0) return 1;
        if(n==1) return x;

        long p = (pow(x,(n/2))) % mod;
        if(n%2==0){
            p *=p;
        }else{
            p *= ((p * x) % mod);
        }

        return p%mod;
    }


}