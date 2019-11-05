package aop;

import service.Person;
import service.impl.Boy;

/**
 * @Description 静态代理
 * @Author wangpeijin
 * @Date 2019/10/31 11:08
 * @Version 1.0
 **/
public class StaticProxy implements Person {

    private Person person;

    public StaticProxy() {
        person = new Boy();
    }

    public void sleep() {
        System.out.println("【静态代理】---睡觉前洗澡澡。。");

        person.sleep();

        System.out.println("【静态代理】---睡觉后打呼噜。。");
    }
}
