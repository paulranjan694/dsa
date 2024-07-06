class Solution {
    public int longestPalindrome(String s) {
                HashMap<Character,Integer> map = new HashMap<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int oddCount = 0;
        for(Character k : map.keySet()){
            int val = map.get(k);
            if(val % 2 == 0){
                ans+=val;
            }else{
                ans+=((val/2)*2);
                oddCount++;
            }
        }

        if(oddCount > 0)
            ans++;
        
        return ans;
    }
}