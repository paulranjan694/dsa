class Solution {
    public String removeKdigits(String s, int k) {
        if(s.length() <= k) return "0";
        
        Stack<Integer> st = new Stack<>();
        
        int idx=0, n = s.length();
        char[] arr = s.toCharArray();
        
        while(idx < n && k > 0){
            while(!st.isEmpty() && (arr[st.peek()]-'0') > (arr[idx]-'0')){
                st.pop();
                k--;
                
                if(k==0) break;
            }
            
            st.push(idx);
            idx++;
        }

        if(k!=0){
            while(!st.isEmpty() && k >0){
                st.pop();
                k--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        int i=n-1;
        while(i>=idx){
            sb.append(arr[i--]);
        }
        
        while(!st.isEmpty()){
            sb.append(arr[st.pop()]);
        }
        
        String ss = sb.reverse().toString();
        i=0;
        while(i<ss.length()-1 && ss.charAt(i) == '0'){
            i++;
        }
        
        ss=i < ss.length() ?  ss.substring(i) : ss ;
        return ss;
    }
}