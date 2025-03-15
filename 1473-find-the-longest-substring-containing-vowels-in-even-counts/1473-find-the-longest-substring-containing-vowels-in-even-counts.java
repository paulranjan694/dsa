class Solution {
    public int findTheLongestSubstring(String s) {
        int[] charmap = new int[26];
        charmap['a'-'a']=1;
        charmap['e'-'a']=2;
        charmap['i'-'a']=4;
        charmap['o'-'a']=8;
        charmap['u'-'a']=16;

        int[] mp = new int[32];
        Arrays.fill(mp,-1);

        int maxlen=0,prefixXor=0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            prefixXor ^= charmap[ch-'a'];
            if(mp[prefixXor] == -1 && prefixXor!=0){
                mp[prefixXor]=i;
            }else{
                maxlen=Math.max(maxlen,i-mp[prefixXor]);
            }
        }
        return maxlen;
    }
}