package com.study.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {
//invocationCount 运行次数，threadPoolSize 线程数量  提高测试效率
//跨线程关联 需要加锁
    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
