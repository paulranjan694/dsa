class MyQueue {
    Stack<Integer> ip=null;
    Stack<Integer> op=null;

    public MyQueue() {
        ip = new Stack<>();
        op = new Stack<>();
    }
    
    public void push(int x) {
        ip.push(x);
    }
    
    public int pop() {
        if(op.empty()){
            while(!ip.empty()){
                op.push(ip.pop());
            }
            return op.empty() ? -1 : op.pop();
        }else{
            return op.pop();
        }
    }
    
    public int peek() {
        if(op.empty()){
            while(!ip.empty()){
                op.push(ip.pop());
            }
            return op.empty() ? -1 : op.peek();
        }else{
            return op.peek();
        }
    }
    
    public boolean empty() {
        if(op.empty() && ip.empty()){
           return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */