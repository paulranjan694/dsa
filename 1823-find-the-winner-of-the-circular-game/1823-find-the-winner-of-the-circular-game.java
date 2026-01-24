class Solution {
    public int findTheWinner(int n, int k) {
        
        return utils(n,k)+1;
    }

    private int utils(int n, int k){
        if(n==1) return 0;

        return (utils(n-1,k)+k) % n;
    }
}