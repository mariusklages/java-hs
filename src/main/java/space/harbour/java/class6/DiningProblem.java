package space.harbour.java.class6;

public class DiningProblem {

    static class Philosopher implements Runnable {
        private String name;
        private Object leftFork;
        private Object rightFork;

        public Philosopher(String name, Object leftFork, Object rightFork) {
            this.name = name;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        private  void think() throws InterruptedException {
            System.out.println(name + " thinking...");
            Thread.sleep((long) Math.random() * 1_000);
        }

        private  void eat() throws InterruptedException {
            System.out.println(name + " eating...");
            Thread.sleep((long) Math.random() * 1_000);
        }


        @Override
        public void run() {
            try {
                while (true) {
                    think();
                    synchronized (leftFork) {
                        System.out.println(name + " picking left fork...");
                        synchronized (rightFork) {
                            System.out.println(name + " picking right fork...");
                            eat();
                        } // grabbing and putting down a fork is implemented by synchronized
                        System.out.println(name + " putting dong right fork...");
                    }       // only one can have the left fork/ right fork
                    System.out.println(name + " putting down  left fork...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        final int N = 5;
        Philosopher[] philosophers = new Philosopher[N];
        Object[] forks = new Object[N];

        for (int i = 0; i < N; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < N; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % N];

            philosophers[i] = new Philosopher("Philosopher " + (i + 1), leftFork, rightFork);

            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }
}
