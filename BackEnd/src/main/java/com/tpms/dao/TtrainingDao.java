package com.tpms.dao;

import com.tpms.entity.Ttraining;
import com.tpms.utils.PageTool;

import java.util.List;

public class TtrainingDao extends BaseDao<Ttraining>{

    public  int updateUser(Ttraining ttraining) {
        return dml("update ttraining set tnum = ? , tname = ? , ttraining = ? , tmarks=? where tid = ?",
                ttraining.getTnum(),ttraining.getTname(),ttraining.getTtraining(),ttraining.getTmarks(),ttraining.getTid()
        );
    }

    public  int selectTtrainingCount(String search) {
        String sql = "select count(*) from ttraining ";
        //如果search有内容，不为空，在原有的sql基础上拼接上模糊条件
        if (search != null) {
            sql += "where tname like '%" + search + "%'";
        }
        long count = (Long) singleData(sql);
        return (int)count;
    }

    public List<Ttraining> findAllTtraining(PageTool pageTool, String search) {
        String sql = "select * from ttraining ";
        //如果search有内容，不为空，在原有的sql基础上拼接上模糊条件
        if (search != null) {
            sql += "where tname like '%" + search + "%'";
        }
        sql += " limit ?, ? ";
        return moreLine(sql,Ttraining.class,
                pageTool.getStartIndex(), pageTool.getPageSize());
    }

    public int delAll(String ids) {
        return dml("delete from ttraining where tnum in (" + ids + ")");
    }

    public int addtresearch(Ttraining ttraining) {
        return dml("insert into ttraining values (null, ?, ?, ?,null)",
                ttraining.getTnum(),ttraining.getTname(),ttraining.getTtraining());
    }

    public List<Ttraining> findAllTtrainingDesc() {
        String sql = "select * from ttraining ORDER BY tmarks DESC";
        return moreLine(sql,Ttraining.class);
    }
}
