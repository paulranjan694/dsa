class Solution {
    public String reverseWords(String s) {
        String t="";
        String res="";
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch==' '){
               if(t.length()>0){
                res+=" "+reverse(t);
                t="";
               }
            }else{
                t+=ch;
            }
        }
        res+=" "+reverse(t);
        return res.trim();
    }

    public String reverse(String s){
        int i=0,j=s.length()-1;
        char[] ar = s.toCharArray();
        while(i<=j){
            char t = ar[i];
            ar[i]=ar[j];
            ar[j]=t;
            i++;j--;
        }

        String r = new String(ar);
        return r;
    }
}