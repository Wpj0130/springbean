package base;

/**
 * @Description java 内部类和静态内部类的区别
 * @Author wangpeijin
 * @Date 2019/11/1 15:26
 * @Version 1.0
 **/
public class Clazz {

    /**
     * 1.静态内部类可以有静态成员(方法，属性)，而非静态内部类则不能有静态成员(方法，属性)。
     * <p>
     * 2.静态内部类只能够访问外部类的静态成员,而非静态内部类则可以访问外部类的所有成员(方法，属性)。
     * <p>
     * 3.实例化一个非静态的内部类的方法：
     * <p>
     * a.先生成一个外部类对象实例 Clazz clazz = new Clazz();
     * <p>
     * b.通过外部类的对象实例生成内部类对象 Clazz.InnerClass innerClass = clazz.new InnerClass();
     * <p>
     * 4.实例化一个静态内部类的方法：
     * <p>
     * a.不依赖于外部类的实例,直接实例化内部类对象 Clazz.StaticInnerClass staticInnerClass = new Clazz.StaticInnerClass();
     * <p>
     * b.调用内部静态类的方法或静态变量,通过类名直接调用 Clazz.StaticInnerClass.size | Clazz.StaticInnerClass.getMessage()
     */

    private String name;

    private static String color;

    private static void test() {
        System.out.println("这是外部类的静态方法");
    }

    public static void main(String[] args) {

        Clazz clazz = new Clazz();

        // 内部类创建实例
        Clazz.InnerClass innerClass = clazz.new InnerClass();

        // 静态内部类创建实例
        Clazz.StaticInnerClass staticInnerClass = new Clazz.StaticInnerClass();
        System.out.println(StaticInnerClass.size);
        StaticInnerClass.getMessage();
    }

    // 内部类可以声明访问权限
    private class InnerClass {

        // private static Boolean isHave;

        private Integer age;

        public InnerClass() {
            System.out.println("这是内部类");
            // 内部类访问外部类的静态方法
            test();
        }
    }

    public static class StaticInnerClass {

        private String work;

        private static int size;

        public StaticInnerClass() {
            System.out.println("这是静态内部类");
            // 静态内部类访问外部类的静态方法
            test();
        }

        private static void getMessage() {
            System.out.println("静态内部类的方法");
        }
    }
}
