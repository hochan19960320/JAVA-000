package com.geektime.java.homework01;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceRouter extends AbstractRoutingDataSource {
    private static String dataSourceconfig = "master"; //默认主库
    @Override
    protected Object determineCurrentLookupKey() {
//        log.info(" 当前数据源: " + DataSourceContextHolder.getCurrentDataSource());
//        return DataSourceContextHolder.getCurrentDataSource();
        return dataSourceconfig;
    }


    public static void setMater() {
        dataSourceconfig = "master";
        System.out.println("设置为主库");
    }
    public static void setSlave() {
        dataSourceconfig = "slave";
        System.out.println("设置为从库");
    }
}
