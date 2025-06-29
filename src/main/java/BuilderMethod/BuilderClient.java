package main.java.BuilderMethod;

// ================== 产品类 ==================
// Computer 是最终要构建的复杂对象，由多个部分组成。
class Computer {
    private String cpu;
    private int ram;
    private String storage;

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setRAM(int ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + "GB, Storage=" + storage + "]";
    }
}

// ================== 建造者接口 ==================
// ComputerBuilder 定义了构建 Computer 各个部分的方法。
interface ComputerBuilder {
    void buildCPU();      // 构建 CPU
    void buildRAM();      // 构建 RAM
    void buildStorage();  // 构建 存储设备
    Computer getComputer(); // 返回构建好的对象
}

// ================== 具体建造者 - 办公电脑 ==================
// OfficeComputerBuilder 实现 ComputerBuilder 接口，用于构建办公用电脑。
class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    public void buildCPU() {
        computer.setCPU("Intel i5");
    }

    public void buildRAM() {
        computer.setRAM(8);
    }

    public void buildStorage() {
        computer.setStorage("512GB SSD");
    }

    public Computer getComputer() {
        return computer;
    }
}

// ================== 具体建造者 - 游戏电脑 ==================
// GamingComputerBuilder 实现 ComputerBuilder 接口，用于构建游戏用电脑。
class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    public void buildCPU() {
        computer.setCPU("AMD Ryzen 9");
    }

    public void buildRAM() {
        computer.setRAM(32);
    }

    public void buildStorage() {
        computer.setStorage("2TB NVMe SSD");
    }

    public Computer getComputer() {
        return computer;
    }
}

// ================== 指挥者 ==================
// Director 负责控制构建流程，使用 Builder 接口来逐步构建对象。
class Director {
    public Computer constructComputer(ComputerBuilder builder) {
        builder.buildCPU();     // 构建 CPU
        builder.buildRAM();     // 构建 RAM
        builder.buildStorage(); // 构建存储设备
        return builder.getComputer(); // 返回最终对象
    }
}

// ================== 客户端代码 ==================
public class BuilderClient {
    public static void main(String[] args) {
        Director director = new Director();

        // 使用办公电脑建造者构建电脑
        Computer officePC = director.constructComputer(new OfficeComputerBuilder());
        System.out.println("办公电脑配置: " + officePC);

        // 使用游戏电脑建造者构建电脑
        Computer gamingPC = director.constructComputer(new GamingComputerBuilder());
        System.out.println("游戏电脑配置: " + gamingPC);
    }
}