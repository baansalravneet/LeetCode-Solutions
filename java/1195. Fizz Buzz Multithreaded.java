class FizzBuzz {
    private int n;
    private int current;

    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
    }

    // printFizz.run() outputs "fizz".
    synchronized public void fizz(Runnable printFizz) throws InterruptedException {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 != 0) {
                current++;
                printFizz.run();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    synchronized public void buzz(Runnable printBuzz) throws InterruptedException {
        while (current <= n) {
            if (current % 3 != 0 && current % 5 == 0) {
                current++;
                printBuzz.run();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    synchronized public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 == 0) {
                current++;
                printFizzBuzz.run();
                notifyAll();
            } else {
                wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    synchronized public void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            if (current % 3 != 0 && current % 5 != 0) {
                printNumber.accept(current);
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}
