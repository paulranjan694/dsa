class ZeroEvenOdd {
    private int n;
    private int num=1;
    ReentrantLock lock = new ReentrantLock();
    Condition cond1 = lock.newCondition();
    Condition cond2 = lock.newCondition();
    Condition cond3 = lock.newCondition();

    private boolean pzero=true;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
       for(int i=0;i<n;i++){
            try {
                lock.lock();
                while(pzero == false){
                    if(num > n){
                        cond1.signal();
                        cond2.signal();
                        cond3.signal();
                        return;
                    }
                    cond1.await();
                }

                if(num > n){
                    cond1.signal();
                    cond2.signal();
                    cond3.signal();
                    return;
                }

                printNumber.accept(0);
                pzero = false;
                if (num % 2 == 0)
                    cond2.signal();
                else
                    cond3.signal();
            }finally{
                lock.unlock();
            }
       }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(true){
            try{
            lock.lock();
            while(pzero == true || num % 2 != 0){
                if(num > n){
                    cond1.signal();
                    cond2.signal();
                    cond3.signal();
                    return;
                }
                cond2.await();
            }
            if(num > n){
                cond1.signal();
                cond2.signal();
                cond3.signal();
                return;
            }

            printNumber.accept(num++);
            pzero = true;
            cond1.signal();
            }finally{
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
         while(true){
            try{
                lock.lock();
                while(pzero == true || num % 2 == 0){
                    if(num > n){
                        cond1.signal();
                        cond2.signal();
                        cond3.signal();
                        return;
                    }
                    cond3.await();
                }

                if(num > n){
                    cond1.signal();
                    cond2.signal();
                    cond3.signal();
                    return;
                }

                printNumber.accept(num++);
                pzero = true;
                cond1.signal();
            }finally{
                lock.unlock();
            }
         }
    }
}