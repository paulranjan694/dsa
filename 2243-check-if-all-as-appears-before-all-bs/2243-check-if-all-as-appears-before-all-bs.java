/**
    check if pair(s[i-1] > s[i]) exists, that means b exists before a

    tc - o(n)
    sc - o(1)
 */
class Solution {
    public boolean checkString(String s) {
        int n = s.length();
    
        for(int i=1;i<n;i++){
            if(s.charAt(i-1) > s.charAt(i)){
                return false;
            }
        }
        return true;
    }
}