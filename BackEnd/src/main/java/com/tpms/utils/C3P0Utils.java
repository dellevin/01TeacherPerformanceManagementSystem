package com.tpms.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0Utils {
    private  static DataSource dataSource = null;
    static {
        dataSource = new ComboPooledDataSource();
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
}
