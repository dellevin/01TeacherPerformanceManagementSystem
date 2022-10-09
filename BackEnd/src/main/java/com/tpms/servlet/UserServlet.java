package com.tpms.servlet;

import com.alibaba.fastjson.JSON;

import com.tpms.entity.ResultBean;
import com.tpms.entity.User;
import com.tpms.service.UserService;
import com.tpms.utils.PageTool;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


@WebServlet("/user")
public class UserServlet extends BaseServlet {

    private UserService userService = new UserService();
    private ResultBean resultBean = null;

    //后台登录的方法
    private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取用户名、密码、验证码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //测试后台是否拿到数据
        System.out.println(username + "--" + password);

        /*
            1、验证：输入的验证码是否与生成保存在会话中的一致
            2、不一致：直接返回验证码不一致的提示信息即可
            3、一致：封装用户名、密码到User对象，传递做验证码
            4、登录成功返回成功信息，登录失败返回失败信息
         */

        //获取会话中存储的验证码
        HttpSession session = request.getSession();
            //构建User存储数据
            User user = new User(username, password);
            //调用UserService对象中登录的方法
            boolean isSuccess = userService.adminLogin(user, session);
            if (isSuccess) {
                resultBean = new ResultBean(200, "登录成功", isSuccess);
            } else {
                resultBean = new ResultBean(500, "用户名或密码输入错误", isSuccess);
            }
        //将数据转换为json，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }
    //登出账户
    private void Logout (HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.invalidate();//销毁会话
    }
    //获取当前登录用户的方法
    private void findCurrentUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从会话中取出当前登录的用户
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        //封装数据到ResultBean对象中
        if (user != null) {
            resultBean = new ResultBean(200, "获取用户成功", user);
        } else {
            resultBean = new ResultBean(500, "您还未登录，请先登录！", user);
        }
        //将数据转换为json，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }
    //获取所有用户的方法
    private void findAllUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //拿到模糊的内容
        String search = request.getParameter("search");
        //从请求中获取当前页码及每页数据量
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //得到总数量
        int totalCount = userService.selectUserCount(search);
        //构建分页工具对象
        PageTool pageTool = new PageTool(totalCount, currentPage, Integer.valueOf(pageSize));
        //调用UserService对象中获取所有用户的方法
        List<User> users = userService.findAllUser(pageTool, search);
        //将得到的所有用户存储到分页工具对象中
        pageTool.setList(users);

        if (users != null) {
            resultBean = new ResultBean(200, "获取所有用户成功", pageTool);
        } else {
            resultBean = new ResultBean(500, "获取所有用户失败", pageTool);
        }
        //将数据转换为json，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }
    //添加用户的方法
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        //获取数据、映射对象
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        BeanUtils.populate(user, map);
        //调用UserService对象中添加用户的方法
        boolean isSuccess = userService.addUser(user);
        if (isSuccess) {
            resultBean = new ResultBean(200, "添加用户成功", isSuccess);
        } else {
            resultBean = new ResultBean(500, "添加用户失败", isSuccess);
        }
        //将数据转换为json，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }

    //批量删除用户的方法
    private void delAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取id字符串
        String ids = request.getParameter("ids");
        //调用UserService对象中批量删除的方法
        boolean isSuccess = userService.delAll(ids);
        if (isSuccess) {
            resultBean = new ResultBean(200, "删除成功", isSuccess);
        } else {
            resultBean = new ResultBean(500, "删除失败", isSuccess);
        }
        //将数据转换为json，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }

    //修改用户
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        //获取数据，封装对象、
        /*
            BeanUtils在完成数据映射时，是对所有属性的映射，有数据赋值，没有数据不赋值
            而针对日期操作时，无法自动将字符串的日期转换成Date的日期，所以出错了！
            我们干脆直接将User实体类中存储日期的类型改为String
         */
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        BeanUtils.populate(user, map);
        //调用UserService对象中修改用户的方法
        boolean isSuccess = userService.updateUser(user);
        if (isSuccess) {
            resultBean = new ResultBean(200, "修改成功", isSuccess);
        } else {
            resultBean = new ResultBean(500, "修改失败", isSuccess);
        }
        //将数据转换为json，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }




}













