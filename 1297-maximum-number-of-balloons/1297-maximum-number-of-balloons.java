class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        int len=text.length();
        for(int i=0;i<len;i++){
            char ch = text.charAt(i);
            freq[ch-'a']++;
        }

        int[] index = {0,1,11,13,14};

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<index.length;i++){
            if(index[i]==11 || index[i]==14){
                ans=Math.min(ans,(freq[index[i]]/2));
            }else{
                ans=Math.min(ans,freq[index[i]]);
            }
        }

        if(ans==Integer.MAX_VALUE)
            return 0;
        return ans;
    }
}