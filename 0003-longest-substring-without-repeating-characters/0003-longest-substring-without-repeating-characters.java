class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hash = new HashSet<>();
        int left=0,right=0,maxlen=0,n=s.length();
        while(right < n){
            char ch = s.charAt(right);
            if(!hash.contains(ch)){
                hash.add(ch);
                //maxlen = Math.max(maxlen,right-left+1);
            }else{
                while(hash.contains(ch)){
                    char c = s.charAt(left);
                    hash.remove(c);
                    left++;
                }
                hash.add(ch);
                //maxlen = Math.max(maxlen,right-left+1);
            }
            maxlen = Math.max(maxlen,right-left+1);
            right++;
        }
        return maxlen;
    }
}