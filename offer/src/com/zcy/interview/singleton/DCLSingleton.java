package com.zcy.interview.singleton;

public class DCLSingleton {
    private DCLSingleton(){}
    private volatile static DCLSingleton instance = null;
    public DCLSingleton getInstance(){
        if(instance == null){
            synchronized (DCLSingleton.class){
                if(instance == null){
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }
}
