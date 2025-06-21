package main.java.FactoryMethod;

import main.java.FactoryMethod.domain.Transport;
import main.java.FactoryMethod.factory.TransportFactory;

public class FactoryMethodTest {
    public static void main(String[] args) {
        //工厂方法模式是一种创建型设计模式， 其在父类中提供一个创建对象的方法， 允许子类决定实例化对象的类型。
        /*
        问题场景如下：
        一个月前，你开发的物流管理系统正式上线投入公司生产，主要经营陆地运输相关业务。
        由于系统稳定性较强，公司决定拓展海外订单，于是系统需要增加运输方式且后续还有可能拓展其他交通方式。
        但是系统在开发之初只考虑了货车运输这一种方案，这个问题亟待解决。
         */

        /*
        分析：问题重点是实体类货车（Truck）和业务代码高度耦合，需要搭建一个可维护性强的模式去创建交通方式。
         */

        /*
        代码实现：工厂模式下，只需要考虑添加Ship实体类、在工厂中添加判断及其业务代码。
         */

        TransportFactory tf = new TransportFactory();
        Transport truck = tf.getTransport("truck");
        truck.deliver();
        Transport ship = tf.getTransport("ship");
        ship.deliver();

    }
}
