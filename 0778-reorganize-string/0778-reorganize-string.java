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
        // Map<Character,Integer> freq = new HashMap<>();
        // for(int i=0;i<string1.length();i++){
        //   char ch = string1.charAt(i);
        //   freq.put(ch,freq.getOrDefault(ch,0)+1);
        // }

        int[] freq = new int[26];

        for(int i=0;i<string1.length();i++){
          char ch = string1.charAt(i);
          freq[ch-'a']++;
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
        Pair carry = null;
        while(!pq.isEmpty()){
          Pair p = pq.poll();
          if(prev != null && prev.ch == p.ch){
            return "";
          }
          sb.append(p.ch);
          prev=p;
          if(carry != null){
            pq.add(carry);
          }
          if(p.freq-1 > 0){
            p.freq = p.freq-1;
            carry = p;
          }else{
            carry = null;
          }
        }
        
        if(carry != null && prev != null && carry.ch == prev.ch){
          return "";
        }
        
    
        return sb.toString();
    }
}