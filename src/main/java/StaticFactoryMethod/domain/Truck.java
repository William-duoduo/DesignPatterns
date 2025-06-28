package main.java.StaticFactoryMethod.domain;

public class Truck implements Transport {
    //重写接口Transport中声明的交付方法
    @Override
    public void deliver() {
        System.out.println("卡车走陆路交付货物");
    }
}
