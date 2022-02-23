package com.study.testng;

import org.testng.annotations.Test;

public class DependTest {
/**
 * 登陆失败了 怎么购买东西
 * ***/
    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();

    }
    // @Test(dependsOnMethods = {"test1"}) test1与依赖的方法名称对应
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
