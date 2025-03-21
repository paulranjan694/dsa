class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length(),n=s.length(),m=p.length();
        List<Integer> res = new ArrayList<>();
        // Map<Character,Integer> smap = new HashMap<>();
        // Map<Character,Integer> pmap = new HashMap<>();
        int[] smap = new int[26];
        int[] pmap = new int[26];

        for(int i=0;i<m;i++){
            char c = p.charAt(i);
            pmap[c-'a']++;
            //pmap.put(c,pmap.getOrDefault(c, 0) + 1);
        }
      
        for(int i=0;i<n;i++){
            Arrays.fill(smap,0);
            for(int j=i;j<i+k && j < n;j++){
                char ch = s.charAt(j);
                smap[ch-'a']++;
            }
            if(areEquals(pmap,smap)){
                res.add(i);
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