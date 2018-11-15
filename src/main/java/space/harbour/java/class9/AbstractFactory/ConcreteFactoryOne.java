package space.harbour.java.class9.AbstractFactory;

public class ConcreteFactoryOne implements AbstractFactory {

    @Override
    public AbstractProduct getProduct() {
        return new ConcreteProductOne();
    }
}
