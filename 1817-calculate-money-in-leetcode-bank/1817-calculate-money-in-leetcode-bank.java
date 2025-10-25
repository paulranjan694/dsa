class Solution {
    public int totalMoney(int n) {
        int money = 0, start=1;
        while(n>=0){
            int curr=start;
            for(int day=1;day<=Math.min(7,n);day++){
                money += curr;
                curr++;
            }

            n=n-7;
            start++;
        }
        return money;
    }
}

/**

10

10/7 = 1.4 ~2


 */