package com.example.demo.exercise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author qianchen
 * @date 2020/1/9 15:47
 */
public class Proxy1 implements InvocationHandler {

  /** 真实的对象 */
  private Object target;

  /**
   * 绑定一个委托对象并返回一个代理对象
   *
   * @param target
   * @return
   */
  public Object bind(Object target) {
    this.target = target;
    Object proxy =
        Proxy.newProxyInstance(
            target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    return proxy;
  }

  /**
   * 通过代理对象调用方法首先进入这个方法
   * @param proxy 代理对象
   * @param method 被调用方法
   * @param args 方法参数
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // TODO Auto-generated method stub
    System.out.println("我是JDK代理");
    Object result;
    // 反射方法调用前
    System.out.println("开始调用方法");
    // 执行方法，相当于调用Impl的sayHello方法
    result = method.invoke(target, "World");
    // 反射方法调用后
    System.out.println("调用方法完成");
    return result;
  }
}
