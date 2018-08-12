package cn.itcast.service;

import cn.itcast.dao.LinkManDao;
import cn.itcast.entity.LinkMan;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class LinkManService {

    private LinkManDao linkManDao;

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    public void save(LinkMan linkMan) {
        linkManDao.saveOrUpdate(linkMan);
    }

    public List<LinkMan> findAll() {
        return linkManDao.findAll();
    }

    public LinkMan findOne(int lkmId) {
        return linkManDao.findOne(lkmId);
    }

    public void update(LinkMan linkMan) {
        linkManDao.saveOrUpdate(linkMan);
    }

    public void delete(LinkMan linkMan) {
        linkManDao.delete(linkMan);
    }

    public List<LinkMan> findSome(String lkmName) {
        return linkManDao.findSome(lkmName);
    }

    public List<LinkMan> query(LinkMan linkMan) {
        return linkManDao.query(linkMan);
    }
}
