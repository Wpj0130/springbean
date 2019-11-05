package base;

/**
 * @Description int与Integer的区别
 * int与Integer的基本使用对比 :
 * <p>
 * Integer是int的包装类;int是基本数据类型;
 * <p>
 * Integer变量必须实例化后才能使用;int变量不需要;
 * <p>
 * Integer实际是对象的引用,指向此new的Integer对象;int是直接存储数据值 ;
 * <p>
 * Integer的默认值是null;int的默认值是0
 * @Author wangpeijin
 * @Date 2019/11/1 16:53
 * @Version 1.0
 **/
public class IntegerAndInt {

    public static void main(String[] args) {
        /*
         * 1、由于Integer变量实际上是对一个Integer对象的引用
         * 所以两个通过new生成的Integer变量永远是不相等的（因为new生成的是两个对象,其内存地址不同）
         */
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(100);
        System.out.println(i1 == i2);  // false

        /*
         * 2、Integer变量和int变量比较时,只要两个变量的值是向等的,则结果为true
         * 因为包装类Integer和基本数据类型int比较时,java会自动拆包装为int,然后进行比较,实际上就变为两个int变量的比较
         */
        int i = 100;
        System.out.println(i == i1); // true

        /*
         *3、非new生成的Integer变量和new Integer()生成的变量比较时,结果为false
         * 因为非new生成的Integer变量指向的是java常量池中的对象,而new Integer()生成的变量指向堆中新建的对象,两者在内存中的地址不同
         */
        Integer i3 = 100;
        System.out.println(i1 == i3); // false

        /*
         *4、对于两个非new生成的Integer对象,进行比较时,如果两个变量的值在区间-128到127之间,则比较结果为true,
         * 如果两个变量的值不在此区间,则比较结果为false
         */
        Integer i4 = 100;
        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i3 == i4); // true
        System.out.println(i5 == i6); // false
        /*
         * 解析原因：归结于java对于Integer与int的自动装箱与拆箱的设计,是一种模式：叫享元模式(flyweight)
         * 加大对简单数字的重利用,Java定义在自动装箱时对于值从–128到127之间的值,
         * 它们被装箱为Integer对象后,会存在内存中被重用,始终只存在一个对象。
         * 而如果超过了从–128到127之间的值,被装箱后的Integer对象并不会被重用,即相当于每次装箱时都新建一个 Integer对象
         */


        /*
         * Java两种数据类型
         * 1、基本数据类型   分为boolean、byte、int、char、long、short、double、float
         * 2、引用数据类型   分为数组、类、接口
         */

        // 自动装箱
        Integer num = 13; // Integer num = new Integer(13);
        // 自动拆箱
        int n = num;
    }

}
