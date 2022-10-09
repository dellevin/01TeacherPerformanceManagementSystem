package com.tpms.servlet;
import com.alibaba.fastjson.JSON;
import com.tpms.entity.ResultBean;
import com.tpms.entity.Sicence;
import com.tpms.service.SicenceService;
import com.tpms.utils.PageTool;
import com.tpms.utils.UploadUtils;

import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/course")
public class SicenceServlet extends BaseServlet{

    private SicenceService sicenceService= new SicenceService();
    private ResultBean resultBean = null;

    private void addCourse(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, IOException {
        //获取数据，封装对象
        Map<String, String[]> map = request.getParameterMap();
        Sicence course = new Sicence();

        BeanUtils.populate(course, map);

        System.out.println(course);
        //调用CourseService对象中添加课程的方法
        boolean isSuccess = sicenceService.addCourse(course);
        if (isSuccess) {
            resultBean = new ResultBean(200, "添加成功", isSuccess);
        } else {
            resultBean = new ResultBean(500, "添加失败", isSuccess);
        }
        //转换成json格式数据，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }

    //获取所有课程的方法
    private void findAllCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //先获取模糊内容
        String search = request.getParameter("search");
        //获取当前页码及每页数据量
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        //获取总数据量
        int totalCount = sicenceService.selectCourseCount(search);
        //构建分页工具对象
        PageTool pageTool = new PageTool(totalCount, currentPage, Integer.valueOf(pageSize));
        //调用CourseService对象中分页获取数据的方法
        List<Sicence> courses = sicenceService.findAllCourse(pageTool, search);
        //将数据存储到PageTool对象中
        pageTool.setList(courses);
        if (courses != null) {
            resultBean = new ResultBean(200, "获取成功", pageTool);
        } else {
            resultBean = new ResultBean(500, "获取失败", pageTool);
        }
        //转换成json格式数据，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }

    private void delAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取id字符串
        String ids = request.getParameter("tid");
        //调用UserService对象中批量删除的方法
        boolean isSuccess = sicenceService.delAll(ids);
        if (isSuccess) {
            resultBean = new ResultBean(200, "删除成功", isSuccess);
        } else {
            resultBean = new ResultBean(500, "删除失败", isSuccess);
        }
        //将数据转换为json，返回
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }

}
