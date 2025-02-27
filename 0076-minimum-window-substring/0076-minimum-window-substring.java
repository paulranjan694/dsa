class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        String answer = "";
        int left=0,right=0,startIndex=-1,minLength=Integer.MAX_VALUE,n=s.length(),m=t.length(),count=0;
        if(n<m) return answer;

        for(int i = 0;i<m;i++){
            char ch1 = t.charAt(i);
            hash[ch1]++;
        }

        while(right < n){
            char ch = s.charAt(right);
            if(hash[ch] > 0) count++;
            hash[ch]--;

            while(count==m){
                if(minLength > (right-left+1)){
                    minLength = right - left + 1;
                    startIndex=left;
                }
                char c = s.charAt(left);
                hash[c]++;
                if(hash[c] > 0) count--;
                left++;
            }
            right++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex,startIndex+minLength);
    }
}