class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int total=0,ans=0,n=capacity.length;
        for(int e:apple){
            total += e;
        }

        for(int i = n-1;i>=0;i--){
            if(total >= capacity[i]){
                ans++;
                total -= capacity[i];
            }else{
                break;
            }
        }

        if(total > 0){
            ans++;
        }

        return ans;
    }
}