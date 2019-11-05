package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description
 * @Author wangpeijin
 * @Date 2019/10/30 14:23
 * @Version 1.0
 **/
public class MyBeanPostProcess implements BeanPostProcessor {


    // 第六步和第九步可以结合aop，在初始化执行之前或者执行之后执行一些操作
    // 6.如果Bean实现了BeanPostProcessor接口，Spring就将调用他们的postProcessBeforeInitialization()方法,执行初始化之前的操作
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【第六步】---如果Bean实现BeanPostProcessor,则调用postProcessBeforeInitialization()方法,执行初始化之前的操作");
        return bean;
    }

    // 9.如果Bean实现了BeanPostProcessor接口，Spring就将调用他们的postProcessAfterInitialization()方法,执行初始化之后的操作
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【第九步】---如果Bean实现BeanPostProcessor,则调用postProcessAfterInitialization()方法,执行初始化之后的操作");
        return bean;
    }
}
