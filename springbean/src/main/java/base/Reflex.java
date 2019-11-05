package base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author wangpeijin
 * @Date 2019/11/4 10:11
 * @Version 1.0
 **/
public class Reflex {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // 反射获取Class

        // 方法1
        // Class<? extends Father> aClass1 = new Father().getClass();

        // 方法2
        // Class<Father> fatherClass = Father.class;

        // 方法3
        Class<?> aClass = Class.forName("base.Father");

        System.out.println("类的名字:" + aClass.getName());

        Method[] methods = aClass.getMethods();
        System.out.println("类的方法:");
        for (Method method : methods) {
            String name = method.getName();
            System.out.print(name + "   ");
            // if ("sleep".equals(name)) {
            //     通过反射调用方法
            //     method.invoke(aClass.newInstance(), "小明");
            // }
        }

        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println("类的属性:");
        for (Field field : declaredFields) {
            System.out.print(field.getName() + "   ");
        }
    }
}
