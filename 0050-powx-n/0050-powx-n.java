class Solution {
    //tc - logn
    // sc - 1
    public double myPow(double x, int n) {
        long tempn = n;
        if(tempn < 0) tempn *= -1;
        double ans = 1.0;

        while(tempn>0){
            //odd case
            if(tempn%2 != 0){
                ans *= x;
                tempn-=1;
            }else{//even case
                x *= x;
                tempn/=2;
            }
        }

        if(n<0) return ((double)1.0/(double)ans);
        return ans;


    }

    //tc - logn
    // sc - logn - recursive stack space
    public double myPow2(double x, int n) {
        boolean isNegative = false;

        if(n < 0){
            isNegative = true;
            n*=-1;
        }

       double pow = powUtils(x,n);

       if(isNegative){
            return 1/pow;
       }
       return pow;
    }

    public double powUtils(double x, int n){
        //base case
        if(n == 0) return 1.0;

        double pow = 1.0;
        boolean isOdd = false;

        if(n%2 != 0){
           isOdd = true;
        }

        double tempPow = powUtils(x,n/2);
        pow *= (tempPow * tempPow);

        if(isOdd){
            pow*=x;
        }

        return pow;
    }
}