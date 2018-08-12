package cn.itcast.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Integer uid;
    private String username;
    private String realname;
    private String password;
    private String address;
    private String level;
    @JSONField(serialize = false)
    private Set<Visit> visitSet = new HashSet<Visit>();

    public Set<Visit> getVisitSet() {
        return visitSet;
    }

    public void setVisitSet(Set<Visit> visitSet) {
        this.visitSet = visitSet;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
