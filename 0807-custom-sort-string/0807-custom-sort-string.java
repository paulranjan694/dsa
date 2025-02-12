class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            //map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            if(freq[c-'a']==0){
              break;
            }
           for(int j=0;j<freq[c-'a'];j++){
              sb.append(c);
            }
            freq[c-'a']=0;
        }
        
        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i];j++){
                sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }
}