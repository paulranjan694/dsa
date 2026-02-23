class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k) return false;
        Set<String> binStr = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        //generateBinaryString(sb, k, binStr); 
        
        Set<String> generatedSubString = new HashSet<>();

        //sb = new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append(s.charAt(i));
        }
        generatedSubString.add(sb.toString());

        for(int i=k,j=0;i<s.length();i++,j++){
            sb.deleteCharAt(sb.length()-k);
            sb.append(s.charAt(i));
            generatedSubString.add(sb.toString());
        }

        
        return generatedSubString.size() == (int)Math.pow(2,k);
    }

    private void generateBinaryString(StringBuilder sb, int k, Set<String> bin){
        if(sb.length() == k){
            bin.add(sb.toString());
            return;
        }

        if(sb.length() > k){
            return;
        }

        sb.append(0);
        generateBinaryString(sb, k, bin);
        sb.deleteCharAt(sb.length()-1);
        sb.append(1);
        generateBinaryString(sb, k, bin);

        sb.deleteCharAt(sb.length()-1);
    }


}