class MedianFinder {

    Queue<Integer> smallheap = null;
    Queue<Integer> largeheap = null;

    public MedianFinder() {
        smallheap = new PriorityQueue<>(Collections.reverseOrder());
        largeheap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(smallheap.isEmpty() || smallheap.peek() >= num){
            smallheap.offer(num);
        }else{
            largeheap.offer(num);
        }
        
        if(smallheap.size() > largeheap.size() + 1){
            largeheap.offer(smallheap.poll());
        }else if(smallheap.size() < largeheap.size()){
            smallheap.offer(largeheap.poll());
        }
    }
    
    public double findMedian() {
        return smallheap.size() > largeheap.size() ? smallheap.peek() : (smallheap.peek() + largeheap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */