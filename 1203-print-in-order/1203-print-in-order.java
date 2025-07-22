class Foo {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition secondCond = lock.newCondition();
    private final Condition thirdCond = lock.newCondition();

    private int step=1;
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            step=2;
            secondCond.signal();
        }finally{
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            while(step!=2){
                secondCond.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            step=3;
            thirdCond.signal();
        }finally{
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            while(step!=3){
                thirdCond.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            step=3;
            thirdCond.signal();
        }finally{
            lock.unlock();
        }

    }
}