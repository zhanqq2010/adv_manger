package com.adv.manager.po;

import java.util.Date;

public class AdvProject {
    private String pid;

    private Integer id;

    private String pname;

    private Integer type;

    private String count;

    private Integer status;

    private String pusherea;

    private String pruductPid;

    private String channelPid;

    private String url;

    private String pkg;

    private String versionCode;

    private String versionName;

    private Double appSize;

    private String appName;

    private String imgUrl;

    private String iconUrl;

    private Date addTime;

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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count == null ? null : count.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPusherea() {
        return pusherea;
    }

    public void setPusherea(String pusherea) {
        this.pusherea = pusherea == null ? null : pusherea.trim();
    }

    public String getPruductPid() {
        return pruductPid;
    }

    public void setPruductPid(String pruductPid) {
        this.pruductPid = pruductPid == null ? null : pruductPid.trim();
    }

    public String getChannelPid() {
        return channelPid;
    }

    public void setChannelPid(String channelPid) {
        this.channelPid = channelPid == null ? null : channelPid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg == null ? null : pkg.trim();
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode == null ? null : versionCode.trim();
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName == null ? null : versionName.trim();
    }

    public Double getAppSize() {
        return appSize;
    }

    public void setAppSize(Double appSize) {
        this.appSize = appSize;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}