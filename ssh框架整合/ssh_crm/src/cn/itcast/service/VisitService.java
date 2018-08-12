package cn.itcast.service;

import cn.itcast.dao.VisitDao;
import cn.itcast.entity.Visit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class VisitService {

    private VisitDao visitDao;

    public void setVisitDao(VisitDao visitDao) {
        this.visitDao = visitDao;
    }

    public void save(Visit visit) {
        visitDao.saveOrUpdate(visit);
    }

    public List<Visit> findAll() {
        return visitDao.findAll();
    }

    public Visit findOne(int vid) {
        return visitDao.findOne(vid);
    }

    public void delete(Visit visit) {
        visitDao.delete(visit);
    }

    public void update(Visit visit) {
        visitDao.saveOrUpdate(visit);
    }

    public List<Visit> query(Visit visit) {
        return visitDao.query(visit);
    }
}
