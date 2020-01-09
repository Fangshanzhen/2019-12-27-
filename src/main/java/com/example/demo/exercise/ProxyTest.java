package com.example.demo.exercise;

/**
 * @author qianchen
 * @date 2020/1/9 16:12
 */
public class ProxyTest {
    public static void main(String[] args) {
        Proxy1 HelloHandler = new  Proxy1();
        FanShe proxy = (FanShe) HelloHandler.bind(new FanSheImpl());
        proxy.sayHello("");
    }
}
