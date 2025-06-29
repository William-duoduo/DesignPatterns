package main.java.AbstractFactoryMethod;

import main.java.AbstractFactoryMethod.domain.OfficeChair;
import main.java.AbstractFactoryMethod.factory.AbstractSonFactory;
import main.java.AbstractFactoryMethod.factory.SonFactoryA;

public class AbstractFactoryMethodTest {
    public static void main(String[] args) {
        //抽象工厂：这个设计模式的工厂包括产品都是抽象接口。
        /*
        问题场景如下：
        某制造业公司接到一笔订单，要求生产一批类型不等的办公椅，因时间紧迫，公司决定将订单拆分给子公司产线同时生产。
         */

        /*
        分析：这个场景相对复杂，办公椅类型和子公司全部位置，需要分别定义工厂和办公椅的抽象接口
         */
        AbstractSonFactory sfa = new SonFactoryA();
        OfficeChair ac = sfa.produceChairs();
        ac.showType();
        ac.showFeatures();
    }
}
