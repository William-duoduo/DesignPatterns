package main.java.AbstractFactoryMethod.domain;

public class TypeTwo implements OfficeChair {
    @Override
    public void showType() {
        System.out.println("类型B");
    }

    @Override
    public void showFeatures() {
        System.out.println("外观奢华");
    }
}
