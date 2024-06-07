class Solution {
    public String reverseWords(String s) {
        String[] str=s.split(" ");
        if(str.length == 0) return s;
        String ans="";
        for(int i=str.length-1;i>=0;i--){
            if(str[i].equals(""))
                continue;
            ans+=" "+str[i];     
        }

        return ans.trim();
    }
}