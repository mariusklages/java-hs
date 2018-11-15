package space.harbour.java.class9.Singleton;

public class Singleton {
    private static Singleton INSTANCE;

    private Singleton(){}

    public static Singleton getInstance(){
        if (INSTANCE == null)
            synchronized (INSTANCE) {
                if (INSTANCE == null)
                    INSTANCE = new Singleton();
            }

        return INSTANCE;
    }

    public void doSomething(){
        System.out.println("Something cool!");
    }

}
