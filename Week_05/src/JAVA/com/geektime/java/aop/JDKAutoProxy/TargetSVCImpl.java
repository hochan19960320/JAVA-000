package com.geektime.java.aop.JDKAutoProxy;

public class TargetSVCImpl implements TargetSVC {
    @Override
    public void execute() {
        System.out.println("目标服务已被执行");
    }
}
