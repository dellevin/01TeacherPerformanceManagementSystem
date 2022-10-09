package com.tpms.service;
import com.tpms.dao.TresearchDao;
import com.tpms.entity.Tresearch;
import com.tpms.entity.User;
import com.tpms.utils.PageTool;
import java.util.List;

public class TresearchService {
    private TresearchDao tresearchDao = new TresearchDao();

    public  int selectTresearchCount(String search) {
        return tresearchDao.selectTresearchCount(search);
    }

    public  List<Tresearch> findAllTresearch(PageTool pageTool, String search) {
        return tresearchDao.findAllTresearch(pageTool, search);
    }

    public boolean delAll(String ids) {
        return tresearchDao.delAll(ids) > 0;
    }

    public boolean addtresearch(Tresearch tresearch) {
        int row = tresearchDao.addtresearch(tresearch);
        return row > 0 ? true : false;
    }

    public boolean updateUser(Tresearch tresearch) {
        return tresearchDao.updateUser(tresearch) > 0;
    }
}
