class Solution {
    public boolean validWordAbbreviation(String w, String a) {
        int i=0,j=0,m=w.length(),n=a.length();
        
        while(i<m && j<n){
            int num=0;
            int temp=j;

            while(temp<n && isNum(a.charAt(temp))){
                if(num==0 && a.charAt(temp)=='0') return false;
                num=num*10+a.charAt(temp)-'0';
                temp++;
            }

            if(temp!=j){
                j+=temp-j;
            }

           i+=num;
           num=0;

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