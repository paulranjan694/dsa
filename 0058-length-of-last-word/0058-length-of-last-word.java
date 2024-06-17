class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length(),count=0;
        if(n==0) return 0;
        if(n==1) return 1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) != ' '){
                count++;
            }

            if(count>0 && s.charAt(i) == ' '){
                return count;
            }
        }
        return count;
    }
}