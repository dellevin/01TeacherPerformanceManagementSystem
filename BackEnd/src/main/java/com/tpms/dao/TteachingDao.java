package com.tpms.dao;

import com.tpms.entity.Tteaching;
import com.tpms.utils.PageTool;

import java.util.List;

public class TteachingDao extends BaseDao<Tteaching>{

    public  int updateUser(Tteaching tresearch) {
        return dml("update tteaching set tnum = ? , tname = ? , tteaching = ? , tmarks=? where tid = ?",
                tresearch.getTnum(),tresearch.getTname(),tresearch.getTteaching(),tresearch.getTmarks(),tresearch.getTid()
        );
    }

    public  int selectTteachingCount(String search) {
        String sql = "select count(*) from tteaching ";
        //如果search有内容，不为空，在原有的sql基础上拼接上模糊条件
        if (search != null) {
            sql += "where tname like '%" + search + "%'";
        }
        long count = (Long) singleData(sql);
        return (int)count;
    }

    public List<Tteaching> findAllTteaching(PageTool pageTool, String search) {
        String sql = "select * from tteaching ";
        //如果search有内容，不为空，在原有的sql基础上拼接上模糊条件
        if (search != null) {
            sql += "where tname like '%" + search + "%'";
        }
        sql += " limit ?, ?";
        return moreLine(sql, Tteaching.class,
                pageTool.getStartIndex(), pageTool.getPageSize());
    }

    public int delAll(String ids) {
        return dml("delete from tteaching where tnum in (" + ids + ")");
    }

    public int addtresearch(Tteaching tteaching) {
        return dml("insert into tteaching values (null, ?, ?, ?,null)",
                tteaching.getTnum(),tteaching.getTname(),tteaching.getTteaching());
    }
}
