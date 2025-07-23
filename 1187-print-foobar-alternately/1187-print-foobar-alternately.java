class FooBar {
    private int n;
    private volatile boolean printfoo = true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(!printfoo){
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                printfoo=false;
                notify();

            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this){
                while(printfoo){
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
        	    printBar.run();
                printfoo = true;
                notify();
            }
            
        }
    }
}