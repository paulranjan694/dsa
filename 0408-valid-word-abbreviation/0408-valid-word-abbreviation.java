class Solution {
    public boolean validWordAbbreviation(String w, String a) {
        int i=0,j=0,m=w.length(),n=a.length();
        
        while(i<m && j<n){
            String s="";
            int temp=j;
            while(temp<n && isNum(a.charAt(temp))){
                if(s.equals("") && a.charAt(temp)=='0') return false;
                s+=a.charAt(temp);
                temp++;
            }

            if(temp!=j){
                j+=temp-j;
            }

            if(!s.equals("")){
                i += Integer.parseInt(s);
            }

            if(i<m && j<n){
                if(w.charAt(i)!=a.charAt(j)){
                  return false;
                }
                i++;
                j++;
            }
        }
        return i==m && j==n;
    }

    public boolean isNum(char ch){
        return ch >='0' && ch<='9';
    }
}