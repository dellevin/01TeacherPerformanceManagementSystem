package com.tpms.dao;


import com.tpms.entity.User;
import com.tpms.utils.PageTool;

import java.util.List;

public class UserDao extends BaseDao<User> {

    public User adminLogin(User user) {
        /*
            当前是后台登录，所以得保证是管理员用户，添加role = 1的条件
            而且还得保证用户处于可用状态，添加status = 1的条件
         */
        return singleLine("select * from user where username = ? and password = ? and status = 1 and role = 1",
                User.class, user.getUsername(), user.getPassword());
    }

    public List<User> findAllUser(PageTool pageTool, String search) {
        String sql = "select * from user ";
        //如果search有内容，不为空，在原有的sql基础上拼接上模糊条件
        if (search != null) {
            sql += "where name like '%" + search + "%'";
        }
        sql += " limit ?, ?";
        return moreLine(sql, User.class,
                pageTool.getStartIndex(), pageTool.getPageSize());
    }

    public int selectUserCount(String search) {
        String sql = "select count(*) from user ";
        //如果search有内容，不为空，在原有的sql基础上拼接上模糊条件
        if (search != null) {
            sql += "where name like '%" + search + "%'";
        }
        long count = (Long) singleData(sql);
        return (int)count;
    }
    public int addUser(User user) {
        return dml("INSERT INTO `teacherpms`.`user` (`uid`, `name`, `phone`, `age`, `sex`, `username`, `status`, `createtime`, `role`) VALUES \n" +
                        "(NULL, ?, ?, ?, ?, ?, ?, NOW(), ?); ",
                user.getName(), user.getPhone(), user.getAge(), user.getSex(),
                user.getUsername(), user.getStatus(), user.getRole());
    }

    public int delAll(String ids) {
        return dml("delete from user where uid in (" + ids + ")");
    }

    public int updateUser(User user) {
        return dml("update user set name = ?, phone = ?, age = ?, sex = ?, username = ?, " +
                        "password = ?, status = ?, role = ? where uid = ?",
                user.getName(), user.getPhone(), user.getAge(), user.getSex(),
                user.getUsername(), user.getPassword(), user.getStatus(), user.getRole(), user.getUid());
    }

    public User findUserByUid(Integer uid) {
        return singleLine("select * from user where uid = ?", User.class, uid);
    }
    public List<Object> findUidsByName(String name) {
        return singleColumn("select uid from user where name like '%" + name + "%'");
    }

}
