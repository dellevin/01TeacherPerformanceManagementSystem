package com.tpms.dao;

import com.tpms.entity.Sicence;
import com.tpms.utils.PageTool;

import java.util.List;

public class SicenceDao extends BaseDao<Sicence>{

    public int addCourse(Sicence course) {
        return dml("insert into sicence values (null, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)",
                course.getCourseName(), course.getDescs(), course.getCourseType(),course.getMenLei(),
                course.getLeiXing(),course.getWenJi(),course.getLaiYuan(),course.getFanWei(),course.getBanMian(),
                course.getYiWen(),course.getDate1(),course.getDoc());
    }

    public int selectCourseCount(String search) {
        String sql = "select count(*) from sicence ";
        if (search != null) {
            sql += "where courseName like '%" + search + "%'";
        }
        long count = (Long)singleData(sql);
        return (int)count;
    }

    public List<Sicence> findAllCourse(PageTool pageTool, String search) {
        String sql = "select * from sicence ";
        if (search != null) {
            sql += "where courseName like '%" + search + "%'";
        }
        sql += " limit ?, ?";
        return moreLine(sql, Sicence.class,
                pageTool.getStartIndex(), pageTool.getPageSize());
    }


    public int delAll(String ids) {
        return dml("delete from sicence where tid in (" + ids + ")");
    }
}
