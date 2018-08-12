package cn.itcast.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    private Integer cid;
    private String custName;
    private Dict custLevel;
    private String custSource;
    private String custPhone;
    private String custMobile;
    @JSONField(serialize = false)
    private Set<LinkMan> linkManSet=new HashSet<LinkMan>();
    @JSONField(serialize = false)
    private Set<Visit> visitSet=new HashSet<Visit>();

    public Set<Visit> getVisitSet() {
        return visitSet;
    }

    public void setVisitSet(Set<Visit> visitSet) {
        this.visitSet = visitSet;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Dict getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(Dict custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public Set<LinkMan> getLinkManSet() {
        return linkManSet;
    }

    public void setLinkManSet(Set<LinkMan> linkManSet) {
        this.linkManSet = linkManSet;
    }
}
