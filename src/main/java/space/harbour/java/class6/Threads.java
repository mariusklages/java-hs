package space.harbour.java.class6;

public class Threads {

    static int i;

    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < 10; j++) {
                i++;
                System.out.println(i);
            }
        }
    }


    static class Thread2 extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < 10; j++) {
                i--;
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }
}
