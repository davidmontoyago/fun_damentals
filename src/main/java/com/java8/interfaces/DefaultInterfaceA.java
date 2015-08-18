package com.java8.interfaces;

public interface DefaultInterfaceA {

    default void doSomething() {
        System.out.println(">>A.doSomething");
    }

}
