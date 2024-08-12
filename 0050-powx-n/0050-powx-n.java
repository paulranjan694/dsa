class Solution {
    public double myPow(double x, int n) {
        boolean odd = false, negative = false;
        long y = (long)n;
        //if(n%2!=0) odd = true;
        if(n < 0) negative = true;

        //if(odd) n-=1;
        if(negative) y =(y*-1);

        double pow = findPow(x,y);

        //if(odd) pow *= n;
        if(negative) pow = 1.0/pow;

        return pow;
    }

    double findPow(double x, long n){
        if(x==1) return x;
        if(n==0) return 1;
        if(n==1) return x;

        double p = 0.0;
        if(n%2!=0){
            n-=1;
            p=findPow(x,(n/2));
            p=p*p*x;
        }else{
            p=findPow(x,(n/2));
            p=p*p;
        }
        
        return p;
    }
}