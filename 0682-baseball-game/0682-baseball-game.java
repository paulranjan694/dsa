class Solution {
    public int calPoints(String[] operations) {
        int ans=0;
        Stack<Integer> st = new Stack();
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("+")){
                int b = st.pop();
                int c = st.peek() + b;
                st.push(b);
                st.push(c);
            }else if(operations[i].equals("D")){
                int ele = st.peek();
                st.push(2*ele);
            }else if(operations[i].equals("C")){
                st.pop();
            }else{
                st.push(Integer.parseInt(operations[i]));
            }
        }

        while(!st.empty()){
            ans+= st.pop();
        }
        return ans;
    }
}