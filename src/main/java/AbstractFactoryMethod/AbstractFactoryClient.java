package main.java.AbstractFactoryMethod;

// ================== 抽象产品 A ==================
// Button 是一个抽象产品接口，表示 UI 中的按钮组件。
interface Button {
    void render(); // 渲染按钮
}

// ================== 抽象产品 B ==================
// TextBox 是另一个抽象产品接口，表示 UI 中的文本框组件。
interface TextBox {
    void render(); // 渲染文本框
}

// ================== 具体产品 A1 ==================
// WindowsButton 是 Button 的一种具体实现，代表 Windows 风格的按钮。
class WindowsButton implements Button {
    public void render() {
        System.out.println("Render a Windows button.");
    }
}

// ================== 具体产品 A2 ==================
// MacButton 是 Button 的另一种实现，代表 Mac 风格的按钮。
class MacButton implements Button {
    public void render() {
        System.out.println("Render a Mac button.");
    }
}

// ================== 具体产品 B1 ==================
// WindowsTextBox 是 TextBox 的一种实现，代表 Windows 风格的文本框。
class WindowsTextBox implements TextBox {
    public void render() {
        System.out.println("Render a Windows text box.");
    }
}

// ================== 具体产品 B2 ==================
// MacTextBox 是 TextBox 的另一种实现，代表 Mac 风格的文本框。
class MacTextBox implements TextBox {
    public void render() {
        System.out.println("Render a Mac text box.");
    }
}

// ================== 抽象工厂 ==================
// UIFactory 是一个抽象工厂接口，声明了创建一系列 UI 组件的方法。
interface UIFactory {
    Button createButton();   // 创建按钮
    TextBox createTextBox(); // 创建文本框
}

// ================== 具体工厂 1 ==================
// WindowsUIFactory 实现 UIFactory 接口，专门用于创建 Windows 风格的 UI 组件。
class WindowsUIFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public TextBox createTextBox() {
        return new WindowsTextBox();
    }
}

// ================== 具体工厂 2 ==================
// MacUIFactory 实现 UIFactory 接口，专门用于创建 Mac 风格的 UI 组件。
class MacUIFactory implements UIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public TextBox createTextBox() {
        return new MacTextBox();
    }
}

// ================== 客户端代码 ==================
public class AbstractFactoryClient {
    public static void main(String[] args) {
        // 可以根据需求切换不同的具体工厂
        UIFactory factory = new WindowsUIFactory(); // 或 new MacUIFactory();

        Button button = factory.createButton();     // 获取按钮
        TextBox textBox = factory.createTextBox();  // 获取文本框

        button.render();   // 输出对应平台的按钮样式
        textBox.render();  // 输出对应平台的文本框样式
    }
}