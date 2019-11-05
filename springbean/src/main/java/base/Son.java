package base;

/**
 * @Description 子类
 * @Author wangpeijin
 * @Date 2019/11/1 10:20
 * @Version 1.0
 **/
public class Son extends Father {

    /*
     * <p>继承特性
     * 1、子类拥有父类非private的属性和方法；
     *
     * 2、子类可以拥有完全属于自己的属性和方法（对父类扩展）；
     *
     * 3、Java是单继承(每个子类只能继承一个父类)；但是Java可以是多重继承（如A继承B，B继承C）
     * </p>
     */

    /**
     * <p>
     * 多态的三个必要条件
     * 1、继承（extends）
     * 2、重写（子类重写父类的同名方法）
     * 3、父类引用指向子类的对象
     * <p>
     * 子类继承父类，重写父类的方法，当子类对象调用重写的方法时，
     * 调用的是子类的方法，而不是父类的方法，当想要调用父类中被重写的方法时，则需使用关键字super
     * </p>
     */

    private String work;

    public Son(String name, Integer age, String work) {
        super(name, age);
        this.work = work;
    }

    private void work() {
        System.out.println("儿子在工作");
    }

    @Override
    public void sleep() {
        System.out.println("儿子在睡觉");
    }
}

