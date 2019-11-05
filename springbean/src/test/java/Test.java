import aop.DynamicProxy;
import aop.StaticProxy;
import bean.SpringBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.Person;
import service.impl.Boy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author wangpeijin
 * @Date 2019/10/30 14:28
 * @Version 1.0
 **/
public class Test {

    private static Map<String, Object> map = new HashMap<>(16);

    static {
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "v4");
        map.put("k5", "v5");
        map.put("k6", "v6");
        map.put("k7", "v7");
        map.put("k8", "v8");
        map.put("k9", "v9");
    }

    @org.junit.Test
    public void beanTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringBean bean = (SpringBean) context.getBean("spring-bean");
        bean.test();
        context.close();
    }

    @org.junit.Test // 静态代理
    public void staticProxy() {
        Person person = new StaticProxy();
        person.sleep();
    }

    @org.junit.Test // 动态代理
    public void dynamicProxy() {
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class[]{Person.class}, new DynamicProxy(Boy.class));
        person.sleep();
    }

    @org.junit.Test
    public void map() {
        map.forEach((k, v) -> System.out.printf("k: %s,v: %s %n", k, v));
    }
}
