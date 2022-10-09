package com.tpms.service;

import com.tpms.dao.SicenceDao;
import com.tpms.entity.Sicence;
import com.tpms.utils.PageTool;

import java.util.List;

public class SicenceService {
    private SicenceDao sicenceDao = new SicenceDao();
    public boolean addCourse(Sicence course) {
        return sicenceDao.addCourse(course) > 0;
    }

    public int selectCourseCount(String search) {
        return sicenceDao.selectCourseCount(search);
    }

    public List<Sicence> findAllCourse(PageTool pageTool, String search) {
        return sicenceDao.findAllCourse(pageTool, search);
    }


    public boolean delAll(String ids) {
        return sicenceDao.delAll(ids) > 0;
    }
}
