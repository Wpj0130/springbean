package service.impl;

import service.Person;

/**
 * @Description
 * @Author wangpeijin
 * @Date 2019/10/31 11:15
 * @Version 1.0
 **/
public class Boy implements Person {

    @Override
    public void sleep() {
        System.out.println("男孩开始睡觉。。");
    }
}
