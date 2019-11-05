package base;

import com.google.common.base.Objects;

/**
 * @Description Java 中的 ==, equals 与 hashCode 的区别与联系
 * <p>
 * == : 该操作符生成的是一个boolean结果,它计算的是操作数的值之间的关系
 * <p>
 * equals : Object的实例方法,比较两个对象的content是否相同
 * <p>
 * hashCode : Object的native方法,获取对象的哈希值,用于确定该对象在哈希表中的索引位置,它实际上是一个int型整数
 * @Author wangpeijin
 * @Date 2019/11/1 16:15
 * @Version 1.0
 **/
public class Compare {

    private String name;

    private int age;

    /*
     * 一、关系操作符  ==
     *   1、基本数据类型变量  比较值
     *   2、引用类型变量     比较对象在内存中的地址
     */
    public static void main(String[] args) {
        int a = 128;
        double b = 128D;

        Integer c = 128;
        Integer d = new Integer(128);

        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println(a == d);

        String s = "hello";
        String hello = new String("hello");
        String t = "hello";

        System.out.println(s == hello);
        System.out.println(s == t);

    }
    /*
     * 二、equals
     * 针对引用对象,比较的是 指针(地址)
     * 但在String、Dubbo等封装类中,重写了equals方法,是比较对象的值
     */

    /*
     * 三、hashCode
     * 是一个本地方法,返回对象的地址
     */

    /*
     * hashCode和equlas的关系
     *
     * 1、如果两个对象相同（即用equals比较返回true）,那么它们的hashCode值一定要相同；
     *
     * 2、如果两个对象的hashCode相同,它们并不一定相同(即用equals比较返回false)
     *
     * 原因：从散列的角度考虑,不同的对象计算哈希码的时候,可能引起冲突,大家一定还记得数据结构中。
     *
     * 为什么必须要重写hashcode方法?
     * 其实简单的说就是为了保证同一个对象,保证在equals相同的情况下hashcode值必定相同,
     * 如果重写了equals而未重写 hashcode方法,可能就会出现两个没有关系的对象equals相同的(因为equal都是根据对象的特征进行重写的),
     * 但hashcode确实不相同的
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 先直接比较是否是同一对象
        if (o == null || getClass() != o.getClass()) return false; // 再比较是否是同一类型
        Compare compare = (Compare) o;
        return age == compare.age && //最后比较值是否相等
                Objects.equal(name, compare.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }
}
