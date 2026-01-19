class Solution {
    public String removeKdigits(String s, int k) {
        if(s.length() <= k) return "0";
        
        Stack<Character> st = new Stack<>();
        
        int idx=0, n = s.length();
        char[] arr = s.toCharArray();
        
        while(idx < n){
            while(!st.isEmpty() && k > 0 && st.peek() > arr[idx]){
                st.pop();
                k--;
                
                if(k==0) break;
            }
            
            st.push(arr[idx]);
            idx++;
        }

     
        while(!st.isEmpty() && k >0){
            st.pop();
            k--;
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        String ss = sb.reverse().toString();
        int i=0;
        while(i<ss.length()-1 && ss.charAt(i) == '0'){
            i++;
        }
        
        ss=ss.substring(i);
        return ss;
    }
}