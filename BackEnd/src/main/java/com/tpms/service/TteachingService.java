package com.tpms.service;

import com.tpms.dao.TteachingDao;
import com.tpms.dao.TtrainingDao;
import com.tpms.entity.Tteaching;
import com.tpms.entity.Ttraining;
import com.tpms.utils.PageTool;

import java.util.List;

public class TteachingService {

    private TteachingDao tteachingDao = new TteachingDao();

    public  int selectTteachingCount(String search) {
        return tteachingDao.selectTteachingCount(search);
    }

    public List<Tteaching> findAllTteaching(PageTool pageTool, String search) {
        return tteachingDao.findAllTteaching(pageTool, search);
    }

    public boolean delAll(String ids) {
        return tteachingDao.delAll(ids) > 0;
    }

    public boolean addtresearch(Tteaching tteaching) {
        int row = tteachingDao.addtresearch(tteaching);
        return row > 0 ? true : false;
    }

    public boolean updateUser(Tteaching tteaching) {
        return tteachingDao.updateUser(tteaching) > 0;
    }
}
