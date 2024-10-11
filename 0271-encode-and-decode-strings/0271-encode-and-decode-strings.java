public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String st : strs){
            int len = st.length();
            sb.append(len);
            sb.append("#");
            sb.append(st);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> decodedStr = new ArrayList<>();
        int prev = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '#'){
                String newStr = getString(s, prev,i);
                int len = Integer.parseInt(newStr);
                newStr = getString(s, i+1, i+1+len);
                decodedStr.add(newStr);
                i = i+1+len;
                prev=i;
            }
        }
        return decodedStr;
    }

    private String getString(String s, int start,int end){
        StringBuilder sb = new StringBuilder();
        for(int i= start; i < end; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));