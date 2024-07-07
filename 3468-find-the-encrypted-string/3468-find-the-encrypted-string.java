class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int n = arr.length;

        for(int i=0;i<n;i++){
            sb.append(arr[(i+k)%n]);
        }

        return sb.toString();
    }
}