package space.harbour.java.class9.AbstractFactory;

public class ConcreteFactoryTwo implements AbstractFactory {

    @Override
    public AbstractProduct getProduct() {
        return new ConcreteProductTwo();
    }
}
