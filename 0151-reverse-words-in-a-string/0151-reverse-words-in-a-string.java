class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        
        int j=n-1;
        for(int i=n-1;i>=0;i--){
            while(i>=0 && s.charAt(i) == ' '){
                i--;
                //j=i;
            }
            j=i;
            StringBuilder tsb = new StringBuilder();
            while(i>=0 && s.charAt(i) != ' '){
                tsb.append(s.charAt(i));
                i--;
            }

            sb.append(tsb.reverse());
            sb.append(' ');
            // if(i>=0){
            //     sb.append(s.substring(i,j+1));
            //     //sb.append(' ');
            // }

        }
        return sb.toString().trim();
    }
}