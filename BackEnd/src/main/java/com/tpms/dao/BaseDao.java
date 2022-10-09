package com.tpms.dao;

//没有c3p0的包

import com.tpms.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {

    //为了能够让所有的封装方法，都可以使用QueryRunner对象执行sql语句，声明写在外面！
    private QueryRunner qRunner = new QueryRunner(C3P0Utils.getDataSource());

    //增删改
    public int dml(String sql, Object... objs) {
        int row = 0;
        try {
            row = qRunner.update(sql, objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    //单条数据、单行多列
    public T singleLine(String sql, Class<T> clazz, Object... objs) {
        T t = null;
        try {
            t = qRunner.query(sql, new BeanHandler<T>(clazz), objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    //多条数据，多行多列
    public List<T> moreLine(String sql, Class<T> clazz, Object... objs) {
        List<T> list = null;
        try {
            list = qRunner.query(sql, new BeanListHandler<T>(clazz), objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //单一数据，单行单列
    public Object singleData(String sql, Object... objs) {
        Object object = null;
        try {
            object = qRunner.query(sql, new ScalarHandler(), objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    //单列数据，单列多行
    public List<Object> singleColumn(String sql, Object... objs) {
        List<Object> list = null;
        try {
            list = qRunner.query(sql, new ColumnListHandler(), objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}














