package com.example.cms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_record")
public class Record {

    @Id
    @GeneratedValue
    private Integer rid;

    private Integer uid;

    private Integer sid;

    private String amount;

    private Integer gid;

    private String creatingDate;

    public Record() {
    }

    public Integer getRid() {
        return rid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(String creatingDate) {
        this.creatingDate = creatingDate;
    }
}
