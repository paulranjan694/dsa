class BoundedBlockingQueue {
    private Deque<Integer> queue = null;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private int max=30;

    private Condition isFull = writeLock.newCondition();
    private Condition isEmpty = writeLock.newCondition();
    
    public BoundedBlockingQueue(int capacity) {
        queue = new ArrayDeque<>();
    }
    
    public void enqueue(int element) throws InterruptedException {
        writeLock.lock();
        try{
            while(queue.size() == max){
                isFull.await();
            }
            queue.addFirst(element);
            isEmpty.signal();
        }finally{
            writeLock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        writeLock.lock();
        try{
            while(queue.size() == 0){
                isEmpty.await();
            }
            int item = queue.removeLast();
            isFull.signal();
            return item;
        }finally{
            writeLock.unlock();
        }
    }
    
    public int size() {
        readLock.lock();
        try{
            return queue.size();
        }finally{
            readLock.unlock();
        }
    }
}