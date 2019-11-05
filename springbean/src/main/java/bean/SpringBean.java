package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Description
 * @Author wangpeijin
 * @Date 2019/10/30 10:39
 * @Version 1.0
 **/
public class SpringBean implements BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {

    private String name;

    // 1.bean对象的实例化
    public SpringBean() {
        System.out.println("========Spring中Bean的生命周期========");
        System.out.println("【第一步】---实例化bean");
    }

    // 2.封装属性，也就是设置properties中的属性值
    public void setName(String name) {
        this.name = name;
        System.out.println("【第二步】---填充属性,name:" + name);
    }

    // 3.如果bean实现了BeanNameAware，则执行setBeanName方法,也就是bean中的id值
    @Override
    public void setBeanName(String s) {
        System.out.println("【第三步】---如果Bean实现BeanNameAware,则调用setBeanName方法,设置spring容器bean名称(XML中id值):" + s);
    }

    // 4.如果Bean实现了BeanFactoryAware接口的话，Spring将调用setBeanFactory()方法，将BeanFactory容器实例传入

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【第四步】---如果Bean实现BeanFactoryAware,则调用setBeanFactory()方法,将BeanFactory容器实例传入");
    }

    // 5.如果Bean实现了ApplicationContextAware接口的话，Spring将调用Bean的setApplicationContext()方法，将bean所在应用上下文引用传入进来
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【第五步】---如果Bean实现ApplicationContextAware,则调用setApplicationContext()方法,将bean所在应用上下文引用传入进来");
    }

    // 7.如果Bean实现了InitializingBean接口，Spring将调用afterPropertiesSet()方法。类似的，如果bean使用init-method声明了初始化方法，该方法也会被调用
    @Override
    public void afterPropertiesSet() {
        System.out.println("【第七步】---如果Bean实现InitializingBean,则调用afterPropertiesSet()方法,执行自定义初始化,检查是否设置了所有属性");
    }

    // 8.调用<bean　init-method="">执行指定的初始化方法
    public void init() {
        System.out.println("【第八步】---调用<bean init-method='init'>执行指定的初始化方法");
    }

    // 10.执行自身的业务方法
    public void test() {
        System.out.println("【第十步】---执行自身的业务方法");
    }

    // 11.如果bean实现了DisposableBean，则执行spring的的销毁方法
    @Override
    public void destroy() {
        System.out.println("【第十一步】---如果bean实现了DisposableBean，则调用spring的的销毁方法");
    }

    // 12.调用<bean　destory-method="">执行自定义的销毁方法
    public void destory() {
        System.out.println("【第十二步】---执行自己配置的销毁方法");
    }

}
