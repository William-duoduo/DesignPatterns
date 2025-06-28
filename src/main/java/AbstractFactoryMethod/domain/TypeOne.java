package main.java.AbstractFactoryMethod.domain;

public class TypeOne implements OfficeChair {
    @Override
    public void showType() {
        System.out.println("A类型");
    }

    @Override
    public void showFeatures() {
        System.out.println("多挡位调节");
    }
}
