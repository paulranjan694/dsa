class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            String c = s.charAt(i)+"";
            if("]".equals(c)){
                StringBuilder tsb = new StringBuilder();
                while(!st.empty() && !st.peek().equals("[")){
                    tsb.insert(0, st.pop());
                }
                if(!st.empty() && st.peek().equals("[")){
                    st.pop();
                }
                String str = tsb.toString();
                int multiplier = Integer.parseInt(st.pop());
                StringBuilder tempstr = new StringBuilder();
                while(multiplier-- > 0){
                    tempstr.append(str);
                }
                st.push(tempstr.toString());

            }else{
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    String num="";
                    while(i<s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                        num+=s.charAt(i);
                        i++;
                    }
                    st.push(num);
                    i--; 
                }else{
                    st.push(c);
                }
            }
        }
        while(!st.empty()){
            sb.insert(0, st.pop());
        }
        return sb.toString();

    }
}