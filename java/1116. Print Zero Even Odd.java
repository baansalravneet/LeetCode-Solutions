class ZeroEvenOdd {
    private int n;
    private int current;
    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(0);
    private Semaphore even = new Semaphore(0);
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.current = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean turn = false;
        for (int i = 0; i < n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (turn) even.release();
            else odd.release();
            turn = !turn;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}
