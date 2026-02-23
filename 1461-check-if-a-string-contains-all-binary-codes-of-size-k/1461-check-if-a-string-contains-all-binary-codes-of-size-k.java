class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k) return false;
        StringBuilder sb = new StringBuilder();
        int reqSubArrays = (int)Math.pow(2,k);
        
        Set<String> generatedSubString = new HashSet<>();

        for(int i=0;i<k;i++){
            sb.append(s.charAt(i));
        }
        generatedSubString.add(sb.toString());

        for(int i=k,j=0;i<s.length();i++,j++){
            sb.deleteCharAt(sb.length()-k);
            sb.append(s.charAt(i));
            generatedSubString.add(sb.toString());

            if(generatedSubString.size() == reqSubArrays){
                return true;
            }
        }

        return generatedSubString.size() == reqSubArrays;
    }

}