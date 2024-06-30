class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans=0,n = tickets.length;
        for(int i=0;i<n;i++){
            if(tickets[k]<=tickets[i]){
                ans+=tickets[k];
                if(i>k) ans--;
            }else{
                ans+=tickets[i];
            }
        }

        return ans;
    }
}