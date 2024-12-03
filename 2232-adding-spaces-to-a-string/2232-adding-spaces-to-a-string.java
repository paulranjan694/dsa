class Solution {
    public String addSpaces(String s, int[] spaces) {
        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        int n = s.length(),m=spaces.length;
        while(i<n && j<m){
            if(i == spaces[j]){
                sb.append(" ");
                j++;
            }else{
                sb.append(s.charAt(i));
                i++;
            }
        }

        while(i<n){
            sb.append(s.charAt(i));
            i++;
        }

        return sb.toString();

    }
}