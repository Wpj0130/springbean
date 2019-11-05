package base;

/**
 * @Description java泛型
 * 泛型，即“参数化类型”。一提到参数，最熟悉的就是定义方法时有形参，然后调用此方法时传递实参。
 * 那么参数化类型怎么理解呢？顾名思义，就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，
 * 此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）。
 * 泛型的本质是为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型）。
 * 也就是说在泛型使用过程中，操作的数据类型被指定为一个参数，这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法
 * <p>
 * class 类名称 <泛型标识：可以随便写任意标识号，标识指定的泛型的类型>{
 * private 泛型标识（成员变量类型）  var;
 * }
 * @Author wangpeijin
 * @Date 2019/11/1 15:56
 * @Version 1.0
 **/
public class Generic<T> {

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    //泛型构造方法形参key的类型也为T，T的类型由外部指定
    public Generic(T key) {
        this.key = key;
    }


    //泛型方法getKey的返回值类型为T，T的类型由外部指定
    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
    //** 泛型的类型参数只能是类类型，不能是简单类型
    //** 不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错
    // if(xxx instanceof Generic<T>){}

    private void method(Generic<?> obj) {
        System.out.println("泛型参数:" + obj.getKey());
    }

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * <p>
     * 说明：
     * <p>
     * 1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * <p>
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * <p>
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * <p>
     * 4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */

    public <T> T genericMethod(Class<T> tClass) throws InstantiationException, IllegalAccessException {
        return tClass.newInstance();
    }
}
