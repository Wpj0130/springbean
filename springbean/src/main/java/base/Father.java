package base;

/**
 * @Description 父类
 * @Author wangpeijin
 * @Date 2019/11/1 10:18
 * @Version 1.0
 **/
public class Father {

    /**
     * 封装
     * A、使用访问权限修饰符private 在定义JavaBean时对于成员变量使用private进行修饰，
     * 同时对外提供set、get方法 使用了private修饰的成员在其他类中不能直接访问，此时需要使用set、get方法进行
     * B、定义一个Java类与Java的方法就是最简单最常见的面向对象的封装操作，这些操作符合隐藏实现细节，提供访问方式的思路
     */

    private String name;
    public Integer age;

    private void eat() {
        System.out.println("父亲在吃饭");
    }

    public void sleep() {
        System.out.println("父亲在睡觉");
    }

    public Father() {
    }

    public Father(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /*
     * 面向对象六大原则
     *
     * 1、单一职责原则(Single-Resposibility Principle)
     *
     * 2、开放封闭原则(Open-Closed principle)
     *
     * 3、Liskov替换原则(Liskov-Substituion Principle)
     *
     * 4、依赖倒置原则(Dependecy-Inversion Principle)
     *
     * 5、接口隔离原则(Interface-Segregation Principle)
     *
     * 6、良性依赖原则
     */
}
