class FreqStack {
    //List<Integer> list;
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> group;
    int maxfreq = -1;
    public FreqStack() {
        //list = new ArrayList<>();
        freq = new HashMap<>();
        group = new HashMap<>();
        maxfreq=0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val,0) +1;
        freq.put(val,f);
        if(f>maxfreq){
            maxfreq = f;
        }
        group.computeIfAbsent(f, a -> new Stack<Integer>()).push(val);
    }
    
    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x,freq.get(x)-1);
        if(group.get(maxfreq).size()==0){
            maxfreq--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */