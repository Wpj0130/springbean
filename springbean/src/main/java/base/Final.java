package base;

/**
 * @Description 谈谈final、finally、finalize的区别
 * @Author wangpeijin
 * @Date 2019/11/1 14:57
 * @Version 1.0
 **/
// 1、final类不能被继承,没有子类,final类中的方法默认是final的
public final class Final {

    // 2、final成员变量表示常量,只能被赋值一次,赋值后值不再改变
    // final修饰的变量有三种：静态变量、实例变量和局部变量
    private static final String FINAL = "final方法不能被子类的方法覆盖,但可以被继承";

    // 3、final方法不能被子类的方法覆盖,但可以被继承
    public final void finalMethod(final String name) {
        try {
            System.out.println(FINAL);
            // name = "tom";  // 修饰参数时,只能读取,不能修改
            System.out.println(name);
        } finally {
            System.out.println("finally是关键字,在异常处理中,try子句中执行需要运行的内容," +
                    "catch子句用于捕获异常,finally子句表示不管是否发生异常,都会执行。" +
                    "finally可有可无。但是try...catch必须成对出现");
        }
    }


    // 4、final不能用于修饰构造方法
    // public final Final() {
    // }

    /**
     * finalize() 方法名,Object类的方法,Java技术允许使用finalize()方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作
     * 这个方法是由垃圾收集器在确定这个对象没有被引用时对这个对象进行调用
     * finalize()方法是在垃圾收集器删除对象之前对这个对象调用的子类覆盖finalize()方法以整理系统资源或者执行其他清理操作
     */
    @Override
    protected void finalize() {
        System.out.println("对象被释放--》" + this);
    }

    public static void main(String[] args) {
        Final aFinal = new Final();
        aFinal.finalMethod("巴扎黑");
        aFinal = null; // 断开引用
        System.gc(); // 强制性释放空间
        // Runtime.getRuntime().gc();
    }

}

