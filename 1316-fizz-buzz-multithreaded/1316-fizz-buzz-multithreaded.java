class FizzBuzz {
    private int n;
    private volatile int count = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true){
            synchronized(this){
                while(count <= n && (count % 3 != 0 || count % 5 == 0)){
                    wait();
                }
                if(count > n) {
                    notifyAll();
                    return;
                }

                printFizz.run();
                count++;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true){
            synchronized(this){
                while(count <= n && (count % 3 == 0 || count % 5 != 0)){
                    wait();
                }
                if(count > n) {
                    notifyAll();
                    return;
                }

                printBuzz.run();
                count++;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true){
            synchronized(this){
                while(count <= n && (count % 3 != 0 || count % 5 != 0)){
                    wait();
                }
                if(count > n) {
                    notifyAll();
                    return;
                }

                printFizzBuzz.run();
                count++;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(count <= n){
            synchronized(this){
                while(count <= n && (count % 3 == 0 || count % 5 == 0)){
                    wait();
                }
                if(count > n) {
                    notifyAll();
                    return;
                }

                printNumber.accept(count);
                count++;
                notifyAll();
            }
        }
    }
}