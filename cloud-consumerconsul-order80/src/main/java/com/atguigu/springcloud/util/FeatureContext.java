package com.atguigu.springcloud.util;

public class FeatureContext {

    private static ThreadLocal<String> featureThreadLocal = new ThreadLocal();

    public FeatureContext() {
    }

    public static String get(){
        return featureThreadLocal.get();
    }

    public static void set(String featureName){
        featureThreadLocal.set(featureName);
    }

    public static void destroy(){
        featureThreadLocal.remove();
    }


}
