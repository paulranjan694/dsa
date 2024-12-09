class Solution {
    public String minWindow(String s, String t) {
        int n1=s.length(),n2=t.length();
        if(n2 > n1) return "";

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n2;i++){
            char ch = t.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }
        int minlen=Integer.MAX_VALUE, startIdx=-1, l=0,r=0,cnt=0;
        while(r<n1){
            char c = s.charAt(r);
            int f = hm.getOrDefault(c,0);
            if(f>0) cnt++;
            hm.put(c,hm.getOrDefault(c,0)-1);
            
            while(cnt==n2){
                if(minlen > (r-l+1)){
                    minlen = (r-l+1);
                    startIdx = l;
                }
                char cr = s.charAt(l);
                hm.put(cr,hm.getOrDefault(cr,0)+1);
                int f1 = hm.getOrDefault(cr,0);
                if(f1>0) cnt--;
                l++;
            }
            r++;
        }

        return startIdx == -1 ? "" : s.substring(startIdx,startIdx+minlen);
    }
}