package com.adv.manager.po;

public class ChannelProject {
    private String pid;

    private Integer id;

    private String productpid;

    private String productpname;

    private String productname;

    private String partnername;

    private String pname;

    private String remark;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductpid() {
        return productpid;
    }

    public void setProductpid(String productpid) {
        this.productpid = productpid == null ? null : productpid.trim();
    }

    public String getProductpname() {
        return productpname;
    }

    public void setProductpname(String productpname) {
        this.productpname = productpname == null ? null : productpname.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getPartnername() {
        return partnername;
    }

    public void setPartnername(String partnername) {
        this.partnername = partnername == null ? null : partnername.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}