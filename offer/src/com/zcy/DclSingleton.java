package com.zcy;

public class DclSingleton {
    //双检锁懒汉单例
    private DclSingleton(){}
    private volatile static  DclSingleton INSTANCE = null;
    public static DclSingleton getINSTANCE(){
        if(INSTANCE != null){
            return INSTANCE;
        }
        synchronized(DclSingleton.class){
            if(INSTANCE != null){
                return  INSTANCE;

            }
            INSTANCE = new DclSingleton();
            return  INSTANCE;
        }
    }
}
