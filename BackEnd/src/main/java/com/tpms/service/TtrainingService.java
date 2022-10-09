package com.tpms.service;

import com.tpms.dao.TtrainingDao;
import com.tpms.entity.Tresearch;
import com.tpms.entity.Ttraining;
import com.tpms.utils.PageTool;

import java.util.List;

public class TtrainingService {

    private TtrainingDao ttrainingDao = new TtrainingDao();

    public  int selectTtrainingCount(String search) {
        return ttrainingDao.selectTtrainingCount(search);
    }

    public List<Ttraining> findAllTtraining(PageTool pageTool, String search) {
        return ttrainingDao.findAllTtraining(pageTool, search);
    }

    public boolean delAll(String ids) {
        return ttrainingDao.delAll(ids) > 0;
    }

    public boolean addtresearch(Ttraining ttraining) {
        int row = ttrainingDao.addtresearch(ttraining);
        return row > 0 ? true : false;
    }

    public boolean updateUser(Ttraining ttraining) {
        return ttrainingDao.updateUser(ttraining) > 0;
    }

    public List<Ttraining> findAllTtrainingDesc() {
        return ttrainingDao.findAllTtrainingDesc();
    }
}
