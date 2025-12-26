class Solution {
    public int findKthPositive(int[] arr, int k) {
        int curr=1,n=arr.length;

        for(int i=0;i<n && k > 0;){
            if(curr == arr[i]){
                i++;
            }else{
                k--;
                if(k==0) break;
            }
            curr++;
        }

        while(k-- > 0){
            if(k==0) break;
            curr++;
        }

        return curr;
    }
}