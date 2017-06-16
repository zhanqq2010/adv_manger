package com.adv.manager.po;

import java.math.BigDecimal;

public class ChannelProject {
    private Integer id;

    private String pid;

    private String pname;

    private Integer type;

    private String partnerName;

    private Integer status;

    private String remark;

    private BigDecimal newUserDeduct;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName == null ? null : partnerName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getNewUserDeduct() {
        return newUserDeduct;
    }

    public void setNewUserDeduct(BigDecimal newUserDeduct) {
        this.newUserDeduct = newUserDeduct;
    }
}