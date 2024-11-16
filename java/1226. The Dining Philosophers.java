class DiningPhilosophers {
    boolean[] hungry;
    boolean[] turn;

    public DiningPhilosophers() {
        hungry = new boolean[5];
        turn = new boolean[5];
    }

    // call the run() method of any runnable to execute its code
    synchronized public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        hungry[philosopher] = true;
        int leftPhil = (philosopher+1)%5;
        int rightPhil = (philosopher-1+5)%5;
        turn[leftPhil] = true;
        turn[rightPhil] = true;
        if ((hungry[leftPhil] && turn[leftPhil]) || (hungry[rightPhil] && turn[rightPhil])) {
            this.wait();
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        hungry[philosopher] = false;
        this.notifyAll();
    }
}
