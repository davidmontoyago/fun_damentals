package com.java8.interfaces;

public class DefaultIImplementor implements DefaultInterfaceA, DefaultInterfaceB {


    @Override
    public void doSomething() {
        DefaultInterfaceA.super.doSomething();
    }
}
