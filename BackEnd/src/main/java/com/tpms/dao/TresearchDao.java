package com.tpms.dao;

import com.tpms.entity.Tresearch;
import com.tpms.utils.PageTool;

import java.util.List;

public class TresearchDao extends  BaseDao<Tresearch> {

    public  int updateUser(Tresearch tresearch) {
        return dml("update tresearch set tnum = ? , tname = ? , tscience = ? , tmarks=? where tid = ?",
                tresearch.getTnum(),tresearch.getTname(),tresearch.getTscience(),tresearch.getTmarks(),tresearch.getTid()
        );
    }

    public  int selectTresearchCount(String search) {
        String sql = "select count(*) from tresearch ";
        //如果search有内容，不为空，在原有的sql基础上拼接上模糊条件
        if (search != null) {
            sql += "where tname like '%" + search + "%'";
        }
        long count = (Long) singleData(sql);
        return (int)count;
    }

    public  List<Tresearch> findAllTresearch(PageTool pageTool, String search) {
        String sql = "select * from tresearch ";
        //如果search有内容，不为空，在原有的sql基础上拼接上模糊条件
        if (search != null) {
            sql += "where tname like '%" + search + "%'";
        }
        sql += " limit ?, ?";
        return moreLine(sql, Tresearch.class,
                pageTool.getStartIndex(), pageTool.getPageSize());
    }

    public int delAll(String ids) {
        return dml("delete from tresearch where tnum in (" + ids + ")");
    }

    public int addtresearch(Tresearch tresearch) {
        return dml("insert into tresearch values (null, ?, ?, ?,null)",
                tresearch.getTnum(),tresearch.getTname(),tresearch.getTscience());
    }
}
