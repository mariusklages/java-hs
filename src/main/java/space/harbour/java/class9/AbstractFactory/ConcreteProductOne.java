package space.harbour.java.class9.AbstractFactory;

public class ConcreteProductOne implements AbstractProduct {

    @Override
    public void doSomething() {
        System.out.println("Hello from concrete product One");
    }
}
