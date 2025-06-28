package main.java.AbstractFactoryMethod.factory;

import main.java.AbstractFactoryMethod.domain.OfficeChair;
import main.java.AbstractFactoryMethod.domain.TypeOne;
import main.java.AbstractFactoryMethod.domain.TypeTwo;

public class SonFactoryB implements AbstractSonFactory {
    @Override
    public OfficeChair produceChairs() {
        return new TypeTwo();
    }
}
