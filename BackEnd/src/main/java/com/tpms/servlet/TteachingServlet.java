package com.tpms.servlet;

import com.alibaba.fastjson.JSON;
import com.tpms.entity.ResultBean;
import com.tpms.entity.Tteaching;
import com.tpms.service.TteachingService;
import com.tpms.utils.PageTool;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


@WebServlet("/Tteaching")
public class TteachingServlet extends BaseServlet{
    private TteachingService tteachingService = new TteachingService();
    private ResultBean resultBean = null;

    private void  findAllTteaching (HttpServletRequest request, HttpServletResponse response) throws IOException {
        String search = request.getParameter("search");
        //从请求中获取当前页码及每页数据量
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //得到总数量
        int totalCount = tteachingService.selectTteachingCount(search);
        //构建分页工具对象
        PageTool pageTool = new PageTool(totalCount, currentPage, Integer.valueOf(pageSize));
        //调用UserService对象中获取所有用户的方法
        List<Tteaching> tteaching = tteachingService.findAllTteaching(pageTool, search);
        pageTool.setList(tteaching);

        if (tteaching != null) {
            resultBean = new ResultBean(200, "获取所有用户成功", pageTool);
        } else {
            resultBean = new ResultBean(500, "获取所有用户失败", pageTool);
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
        boolean isSuccess = tteachingService.delAll(ids);
        if (isSuccess) {
            resultBean = new ResultBean(200, "删除成功", isSuccess);
        } else {
            resultBean = new ResultBean(500, "删除失败", isSuccess);
        }
        //将数据转换为json，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }

    //添加用户的方法
    private void addtresearch(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        //获取数据、映射对象
        Map<String, String[]> map = request.getParameterMap();
        Tteaching tteaching = new Tteaching();
        BeanUtils.populate(tteaching, map);
        //调用UserService对象中添加用户的方法
        boolean isSuccess = tteachingService.addtresearch(tteaching);
        if (isSuccess) {
            resultBean = new ResultBean(200, "添加用户成功", isSuccess);
        } else {
            resultBean = new ResultBean(500, "添加用户失败", isSuccess);
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
        Tteaching tteaching = new Tteaching();
        BeanUtils.populate(tteaching, map);
        //调用UserService对象中修改用户的方法
        boolean isSuccess = tteachingService.updateUser(tteaching);
        System.out.println(isSuccess);
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
