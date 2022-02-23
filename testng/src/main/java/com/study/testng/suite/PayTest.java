package com.study.testng.suite;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PayTest {
    @BeforeTest
    public void testBeforeTest(){
        System.out.println(" @BeforeTest在test()前");
    }
    @AfterTest
    public void testAfterTest(){
        System.out.println("@AfterTest在test()后");
    }

    @Test
    public  void paySuccess(){
        System.out.println("支付宝支付成功");
    }


}
