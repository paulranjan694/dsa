class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count=0,count10=0;

        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5){
                count++;
            }
            else if(bills[i] == 10){
                if(count < 1)
                    return false;
                count -= 1;
                count10++;
            }else if(bills[i] == 20){
                if(count10 > 0){
                    count10--;
                    if(count < 1)
                        return false;
                    count--;
                }else{
                    if(count >= 3 )
                        count -= 3;
                    else
                        return false;
                }
            } 
        }

        return true;
    }
}