class Solution {
    public int minimumPushes(String word) {
        int len=word.length();
        int i=1,ans=0;
        while(len > 8){
            ans += (8*i);
            len-=8;
            i++;
        }

        if(len % 8 == 0){
             ans += (8*i);
        }else{
            ans += ((len%8) * i);
        }
        return ans;
    }
}