class Solution {
    public int minimumPushes(String word) {
         int ans=0;
        int temp=word.length();
        int i=1;
        while(temp>8){
            ans=ans+(8*i);
            temp=temp-8;
            i++;
        }
        if(temp%8==0){
            ans=ans+(8*i);
        }
        else {
            ans = ans + ((temp % 8) * i);
        }return ans;
    }
}