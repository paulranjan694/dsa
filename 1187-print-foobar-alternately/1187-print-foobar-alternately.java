class FooBar {
    private int n;
    private boolean printFoo1 = true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(printFoo1 != true){
                    wait();
                }

        	    printFoo.run();
                printFoo1 = false;
                notify();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(printFoo1 != false){
                    wait();
                }

        	    printBar.run();
                printFoo1 = true;
                notify();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	
        }
    }
}