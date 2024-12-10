import java.util.LinkedList;
import java.util.Queue;
class MyStack {
    private Queue<Integer> q = null;
    private int idx=0;
    private int top=-1;
    public MyStack() {
       this.q = new LinkedList<Integer>();
       idx=0;
       top=-1;
    }
    
    public void push(int x) {
        q.offer(x);
        idx++;
        top=x;
    }
    
    public int pop() {
        int[] arr = new int[idx];
        int i=0;
        while(!q.isEmpty()){
            arr[i++] = q.poll();
        }
        top = idx - 2 >= 0 ? arr[idx-2] : -1;
        int ele = arr[idx-1];
        idx--;
        for(i=0;i<idx;i++){
            q.add(arr[i]);
        }
        return ele;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q.size() == 0 ? true : false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */