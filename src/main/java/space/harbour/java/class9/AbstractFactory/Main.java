package space.harbour.java.class9.AbstractFactory;

public class Main {

    public static void main(String[] args) {

        AbstractFactory factory;
        if (System.nanoTime() % 2 == 1)
            factory = new ConcreteFactoryOne();
        else
            factory = new ConcreteFactoryTwo();

        AbstractProduct product = factory.getProduct();
        product.doSomething();
    }
}
