class Solution {
    public long numberOfSubstrings(String s) {
        long n = s.length();
        if(n==1) return 1;
        Map<Character,Long> hm = new HashMap<>();
        long count=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                long f= hm.get(ch);
                long prev = (f*(f-1))/2;
                f++;
                long curr = (f*(f-1))/2;
                count+=curr-prev;
                hm.put(ch,f);
            }else{
                hm.put(ch,(long)1);
            }
        }

        return count+n;
    }
}