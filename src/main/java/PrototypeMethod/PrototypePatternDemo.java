package main.java.PrototypeMethod;

// 地址类，需要支持深拷贝
class Address implements Cloneable {
    private String street;
    private String city;
    private String zipcode;

    public Address(String street, String city, String zipcode) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    // 深拷贝：重写 clone 方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Getters and Setters
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}

// 员工类，实现 Cloneable 接口
class Employee implements Cloneable {
    private String name;
    private String department;
    private Address address;

    public Employee(String name, String department, Address address) {
        this.name = name;
        this.department = department;
        this.address = address;
    }

    // 重写 clone 方法，实现深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee emp = (Employee) super.clone();
        emp.address = (Address) address.clone(); // 拷贝嵌套对象
        return emp;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", address=" + address +
                '}';
    }
}

// 测试类
public class PrototypePatternDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("Main St", "New York", "10001");
        Employee emp1 = new Employee("Alice", "Engineering", address);
        Employee emp2 = (Employee) emp1.clone();

        // 修改克隆对象的地址信息
        emp2.getAddress().setCity("San Francisco");

        System.out.println("Original object:");
        System.out.println(emp1);

        System.out.println("\nCloned object:");
        System.out.println(emp2);
    }
}