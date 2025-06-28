package main.java.StaticFactoryMethod.domain;


public class Ship implements Transport {
    //重写接口Transport中声明的交付方法
    @Override
    public void deliver() {
        System.out.println("轮船走海路交付货物");
    }
}
