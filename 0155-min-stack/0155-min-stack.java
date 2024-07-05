class MinStack {

    Stack<Integer> st = null;
    Stack<Integer> min = null;
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(!min.empty() && min.peek() >= val){
            min.push(val);
        }
        if(min.empty()) 
            min.push(val);
    }
    
    public void pop() {
        
        if(!st.empty()){
            int e = st.pop();
            if(!min.empty() && min.peek() == e){
                min.pop();
            }
        }
    }
    
    public int top() {
        if(st.empty())
            return -1;
        return st.peek();
    }
    
    public int getMin() {
        if(min.empty())
            return -1;
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */