package com.tpms.service;


import com.tpms.dao.UserDao;
import com.tpms.entity.User;
import com.tpms.utils.PageTool;


import javax.servlet.http.HttpSession;
import java.util.List;


public class UserService {

    private UserDao userDao = new UserDao();

    public boolean adminLogin(User user, HttpSession session) {
        User newUser = userDao.adminLogin(user);
        if (newUser != null) {
            //将当前登录成功的用户存储到会话对象中
            session.setAttribute("user", newUser);
            return true;
        }
        return false;
    }


    public List<User> findAllUser(PageTool pageTool, String search) {
        return userDao.findAllUser(pageTool, search);
    }

    public int selectUserCount(String search) {
        return userDao.selectUserCount(search);
    }

    public boolean addUser(User user) {
        int row = userDao.addUser(user);
        return row > 0 ? true : false;
    }

    public boolean delAll(String ids) {
        return userDao.delAll(ids) > 0;
    }

    public boolean updateUser(User user) {
        return userDao.updateUser(user) > 0;
    }

    public List<Object> findUidsByName(String name) {
        return userDao.findUidsByName(name);
    }
}
