package base;

/**
 * @Description java中重载与重写的区别
 * <p>
 * 重写与重载的区别在于 :
 * 重写多态性起作用，对调用被重载过的方法可以大大减少代码的输入量，同一个方法名只要往里面传递不同的参数就可以拥有不同的功能或返回值。
 * 用好重写和重载可以设计一个结构清晰而简洁的类，可以说重写和重载在编写代码过程中的作用非同一般
 * </p>
 * @Author wangpeijin
 * @Date 2019/11/1 16:41
 * @Version 1.0
 **/
public class OverLoad extends Father {
    /**
     * 重载的规则：
     * 1、必须具有不同的参数列表 *
     * <p>
     * 2、可以有不同的返回类型,只要参数列表不同就可以了
     * <p>
     * 3、可以有不同的访问修饰符
     * <p>
     * 4、可以抛出不同的异常
     */

    private void eat() throws ClassCastException {
        System.out.println("吃饭中");
    }

    private void eat(String name) throws Exception {
        System.out.println(name + "在吃饭");
    }

    public String eat(String name, int age) {
        System.out.println(age + "岁的" + name + "在吃饭");
        return name;
    }


    /**
     * 父类与子类之间的多态性,对父类的函数进行重新定义。
     * 如果在子类中定义某方法与其父类有相同的名称和参数,我们说该方法被重写 (Overriding)
     * 在Java中,子类可继承父类中的方法,而不需要重新编写相同的方法
     */
    @Override
    public void sleep() {
        System.out.println("重写父类的方法");
    }
}
