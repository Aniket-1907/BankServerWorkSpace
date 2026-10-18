package com.cg.bankapp.practice;

public class SingletonClass {

    private static SingletonClass instance;

    private int value;
    private SingletonClass(){
        value=0;
    }
    private SingletonClass(int value){
        this.value=value;
    }
    public static SingletonClass getInstance(){
        if(instance==null){
            instance=new SingletonClass();
        }
        return instance;
    }
    public static SingletonClass getInstance(int value){
        if(instance==null){
            instance=new SingletonClass(value);
        }
        return instance;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
