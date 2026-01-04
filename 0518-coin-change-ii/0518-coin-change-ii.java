class Solution {
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount+1];
        
        int n = coins.length;

        //base case
        prev[0] = 1;
        for(int A = 1; A<=amount;A++){
            if(A % coins[0] == 0){
                prev[A] = 1;
            }
        }

        

        for(int idx=1;idx<n;idx++){
            int[] curr = new int[amount+1];
            curr[0] = 1;
            for(int A = 1;A<=amount;A++){
                int take = 0;
                if(A>= coins[idx]){
                    take = curr[A-coins[idx]];
                }

                int notTake = prev[A];

                curr[A] = take + notTake;
            }
            prev = curr;
        }

        return prev[amount];
    }
}