class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum=0;

        for(int num : nums){
            int divSum=0,divCount=0;
            for(int div = 1; div*div <= num;div++){
                if(num % div == 0){
                    divSum += div;
                    int q = num/div;
                    if(div!=q){
                        divSum += q;
                        divCount++;
                    }
                    divCount++;

                
                }
            }

            if(divCount == 4){
                sum += divSum;
            }
        }

        return sum;
    }
}