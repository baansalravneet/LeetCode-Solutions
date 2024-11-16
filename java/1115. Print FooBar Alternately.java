class FooBar {
    private int n;
    private boolean foo;

    public FooBar(int n) {
        this.n = n;
        this.foo = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(this) {
                while (!foo) {
                    wait();
                }
                printFoo.run();
                foo = !foo;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(this) {
                while (foo) {
                    wait();
                }
                printBar.run();
                foo = !foo;
                notifyAll();
            }
        }
    }
}
