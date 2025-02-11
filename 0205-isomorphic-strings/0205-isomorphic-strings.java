class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapping1 = new int[256];
        int[] mapping2 = new int[256];
        for(int i=0;i<s.length();i++){
          char ch1 = s.charAt(i);
          char ch2 = t.charAt(i);
          if(mapping1[ch1] == 0 && mapping2[ch2]==0){
            mapping1[ch1]=ch2;
            mapping2[ch2]=ch1;
          }else{
            if(!(mapping1[ch1] == ch2 && mapping2[ch2]==ch1)){
              return false;
            }
          }
        }
        return true;
    }
}