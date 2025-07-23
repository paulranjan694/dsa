class ZeroEvenOdd {
    private int n;

    private int current=1;

    private ReentrantLock lock = new ReentrantLock();
    private Condition oddCondition = lock.newCondition();
    private Condition evenCondition = lock.newCondition();
    private Condition zeroCondition = lock.newCondition();

    private boolean zeroTurn=true;

    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            lock.lock();
            try{

                while(!zeroTurn){
                    zeroCondition.await();
                }
                printNumber.accept(0);
                zeroTurn=false;
                if(current % 2 == 0){
                    evenCondition.signal();
                }else{
                    oddCondition.signal();
                }
            }finally{
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(true){
            lock.lock();
            try{
                if(current > n) {
                    zeroCondition.signal();
                    oddCondition.signal();
                    evenCondition.signal();
                    return;
                }
                while(zeroTurn || current % 2 != 0){
                    if(current > n) {
                        zeroCondition.signal();
                        oddCondition.signal();
                        evenCondition.signal();
                        return;
                    }
                    evenCondition.await();
                }
                if(current > n) {
                    zeroCondition.signal();
                    oddCondition.signal();
                    evenCondition.signal();
                    return;
                }
                printNumber.accept(current++);
                zeroTurn=true;
                zeroCondition.signal();
            }finally{
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(true){
            lock.lock();
            try{
                if(current > n) {
                    zeroCondition.signal();
                    oddCondition.signal();
                    evenCondition.signal();
                    return;
                }
                while(zeroTurn || current % 2 == 0){
                    if(current > n) {
                        zeroCondition.signal();
                        oddCondition.signal();
                        evenCondition.signal();
                        return;
                    }
                    oddCondition.await();
                }
                printNumber.accept(current++);
                if(current > n) {
                    zeroCondition.signal();
                    oddCondition.signal();
                    evenCondition.signal();
                    return;
                }
                zeroTurn=true;
                zeroCondition.signal();
            }finally{
                lock.unlock();
            }
        }
    }
}