class Solution {
    public boolean checkValidString(String s) {
        int op=0;
        int cl=0;

        int len = s.length()-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '*'){
                op++;
            }else{
                op--;
            }

            if(op < 0)
                return false;

            if(s.charAt(len-i) == ')' || s.charAt(len-i) == '*'){
                cl++;
            }else{
                cl--;
            }

            if(cl < 0)
                return false;
        } 
        return true;
    }
}