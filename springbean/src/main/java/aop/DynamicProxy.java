package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description 动态代理
 * @Author wangpeijin
 * @Date 2019/10/31 11:21
 * @Version 1.0
 **/
public class DynamicProxy implements InvocationHandler {

    /**
     * 需要代理的目标对象
     */
    private Object target;

    /**
     * 目标对象构造器
     */
    public DynamicProxy(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (Exception e) {
            System.out.println("获取实例失败");
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置增强
        before();

        // 代理对象
        Object result = method.invoke(target, args);

        // 后置增强
        after();

        // 返回代理对象
        return result;
    }

    private void before() {
        System.out.println("【动态代理】---睡觉前洗澡澡。。");
    }

    private void after() {
        System.out.println("【动态代理】---睡觉后打呼噜。。");
    }
}
