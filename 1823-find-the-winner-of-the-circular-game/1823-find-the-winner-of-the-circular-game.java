class Solution {
    public int findTheWinner(int n, int k) {
        return utils(n,k)+1;
    }
    private int utils(int n, int k){
        //base case: if only 1 remaining, index would be 0
        if(n==1) return 0;

        int idx = utils(n-1,k);
        int orgIdx = (idx + k) % n; // doing +k, to the idx to get the original index and doing %n so that it should go beyond n
        return orgIdx;
    }
}