package main.java.FactoryMethod.factory;

import main.java.FactoryMethod.domain.Ship;
import main.java.FactoryMethod.domain.Transport;
import main.java.FactoryMethod.domain.Truck;

public class TransportFactory {

    public Transport getTransport(String transportType) {
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
