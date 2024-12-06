class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length(),l=0,r=0,maxlen=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        while(r<n){
            char ch = s.charAt(r);
            int fr = hm.getOrDefault(ch,0);
            hm.put(ch,fr+1);
            if(hm.size() > k){
                char ch1 = s.charAt(l);
                int f = hm.getOrDefault(ch1,0);
                if(f>1){
                    hm.put(ch1,f-1);
                }else if(f==1){
                    hm.remove(ch1);
                }
                l++;
            }
            if(hm.size() <= k)
                maxlen = Math.max(maxlen,(r-l+1));
            r++;
        }
        return maxlen;
    }
}