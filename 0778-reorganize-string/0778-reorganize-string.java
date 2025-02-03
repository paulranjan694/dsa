class Solution {
        static class Pair{
      char ch;
      int freq;
      
      Pair(char ch,int f){
        this.ch=ch;
        this.freq = f;
      }
    }
    public String reorganizeString(String string1) {
        int[] freq = new int[26];
        int maxfreq=-1, n=string1.length();

        for(int i=0;i<string1.length();i++){
          char ch = string1.charAt(i);
          freq[ch-'a']++;
          maxfreq = Math.max(maxfreq,freq[ch-'a']);
        }
        if(maxfreq > (n+1)/2){
            return "";
        }
        
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        
        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                Pair temp = new Pair((char)(i+'a'),freq[i]);
                pq.add(temp);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        Pair prev=null;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            sb.append(p.ch);
            if(prev!=null && prev.freq > 0){
                pq.add(prev);
            }   
            p.freq--;
            prev = p.freq > 0 ? p: null;
        }
        
        return sb.toString();
    }
}