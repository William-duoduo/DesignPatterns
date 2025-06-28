package main.java.StaticFactoryMethod.factory;

import main.java.StaticFactoryMethod.domain.Ship;
import main.java.StaticFactoryMethod.domain.Transport;
import main.java.StaticFactoryMethod.domain.Truck;

public class TransportFactory {

    //和工厂模式相比，将创建对象的方法修改为静态方法
    public static Transport getTransport(String transportType) {
        //交通方式异常返回null
        if (transportType == null || transportType.isEmpty()) {
            return null;
        }
        //使用轮船
        if (transportType == "ship") {
            return new Ship();
        }
        //使用货车
        if (transportType == "truck") {
            return new Truck();
        }
        //匹配失败的类型返回null
        return null;
    }
}
