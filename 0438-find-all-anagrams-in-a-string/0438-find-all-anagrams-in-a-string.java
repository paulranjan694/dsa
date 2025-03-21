class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length(),n=s.length(),m=p.length();
        List<Integer> res = new ArrayList<>();
        if(n<m) return res;
        // Map<Character,Integer> smap = new HashMap<>();
        // Map<Character,Integer> pmap = new HashMap<>();
        int[] smap = new int[26];
        int[] pmap = new int[26];

        for(int i=0;i<m;i++){
            char c = p.charAt(i);
            pmap[c-'a']++;
            //pmap.put(c,pmap.getOrDefault(c, 0) + 1);
        }

        int l=0,r=0;
        while(r<k){
            char ch = s.charAt(r);
            smap[ch-'a']++;
            r++;
        }

        if(areEquals(pmap,smap)){
            res.add(0);
        }

        while(r<n){
            char ch = s.charAt(r);
            char c = s.charAt(l);
            smap[ch-'a']++;
            smap[c-'a']--;
            r++;
            l++;

            if(areEquals(pmap,smap)){
                res.add(r-k);
            }
        }
      
        return res;
    }

    private boolean areEquals(int[] pmap, int[] smap){
        for(int i = 0;i<26;i++){
            if(pmap[i] != smap[i]){
                return false;
            }
        }
        return true;
    }
}