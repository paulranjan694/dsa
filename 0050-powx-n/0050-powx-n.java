class Solution {
    public double myPow(double x, int n) {
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