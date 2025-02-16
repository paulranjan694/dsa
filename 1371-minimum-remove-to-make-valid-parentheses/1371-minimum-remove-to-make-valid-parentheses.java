class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Pair<Character,Integer>> st = new Stack<Pair<Character,Integer>>();
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(!st.empty() && arr[i] == ')' && st.peek().getKey() == '('){
                sb.append(arr[i]);
                st.pop();
            }else if(arr[i] == '('){
                sb.append(arr[i]);
                Pair<Character,Integer> p = new Pair<Character,Integer>(arr[i],sb.length()-1);
                st.push(p);
            }else if(arr[i] >= 'a' && arr[i]<='z'){
                sb.append(arr[i]);
            }
        }

        while(!st.empty()){
            sb.deleteCharAt(st.pop().getValue());
        }

        return sb.toString();
    }
}