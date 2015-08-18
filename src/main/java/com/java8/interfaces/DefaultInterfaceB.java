package com.java8.interfaces;

public interface DefaultInterfaceB {

    default void doSomething() {
        System.out.println(">>B.doSomething");
    }
}
