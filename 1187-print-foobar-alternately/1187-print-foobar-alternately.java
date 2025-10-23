class FooBar {
    private int n;
    private boolean printFoo1 = true;
    ReentrantLock lock = new ReentrantLock();
    Condition cond1 = lock.newCondition();
    Condition cond2 = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            lock.lock();
            while(printFoo1 != true){
                cond1.await();
            }

            printFoo.run();
            printFoo1 = false;
            cond2.signal();
            lock.unlock();
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
           lock.lock();
                while(printFoo1 != false){
                    cond2.await();
                }

        	    printBar.run();
                printFoo1 = true;
                cond1.signal();
               lock.unlock();
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	
        }
    }
}