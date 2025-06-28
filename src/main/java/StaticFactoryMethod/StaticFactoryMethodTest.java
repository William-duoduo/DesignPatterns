package main.java.StaticFactoryMethod;

import main.java.StaticFactoryMethod.domain.Transport;
import main.java.StaticFactoryMethod.factory.TransportFactory;

public  class StaticFactoryMethodTest {
    public static void main(String[] args) {
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
        代码实现：和工厂模式基本一致，省略了创建工厂对象的步骤和系统开销。
         */

        Transport truck = TransportFactory.getTransport("truck");
        truck.deliver();
        Transport ship = TransportFactory.getTransport("ship");
        ship.deliver();

    }
}
