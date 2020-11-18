package com.geektime.java.aop.staticProxy;

public class ProxySVCImpl implements TargetSVC {

    //代理的对象
    private TargetSVC targetSVC;

    public ProxySVCImpl(TargetSVC targetSVC) {
        this.targetSVC = targetSVC;
    }

    @Override
    public void execute() {
        System.out.println("====start");
        targetSVC.execute();
        System.out.println("====end");
    }
}
