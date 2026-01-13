class Solution {
    public boolean lemonadeChange(int[] arr) {
        int five = 0,ten=0;
        
        for(int e : arr){
            if(e==5){
                five++;
            }else if(e==10){
                if(five==0){
                    return false;
                }
                five--;
                ten++;
            }else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }else if(five>=3){
                    five -=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}