class H2O {

    private CyclicBarrier cyclicBarrier;
    private Semaphore hydSemaphore,oxySemaphore;

    public H2O() {
        cyclicBarrier = new CyclicBarrier(3);
        hydSemaphore = new Semaphore(2);
        oxySemaphore = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		try {
            hydSemaphore.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            cyclicBarrier.await();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            hydSemaphore.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            oxySemaphore.acquire(1);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            cyclicBarrier.await();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            oxySemaphore.release(1);
        }
    }
}