public class Main {

    public static void main(String[] args) {
        try {
            long i = Runtime.getRuntime().freeMemory();
            int[] a = new int[1000];
            for (int j = 0; j < 1000; j++) {
                a[j] = j;
            }

            System.out.println(i - Runtime.getRuntime().freeMemory());
            System.gc();
            Thread.sleep(10);


            long l = Runtime.getRuntime().freeMemory();
            Object[] o = new Object[100];
            o[0] = new Object();
            System.out.println(l - Runtime.getRuntime().freeMemory());
            System.gc();
            Thread.sleep(10);

            long k = Runtime.getRuntime().freeMemory();
            String[] s = new String[2];
            s[0] = "abc";
            s[1] = "xyz";
            System.out.println(k - Runtime.getRuntime().freeMemory());
            System.gc();;
            Thread.sleep(10);
        } catch (Exception e) {

        }
    }
}