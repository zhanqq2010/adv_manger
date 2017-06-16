package com.adv.manager.po;

import java.util.Date;

public class App {
    private Integer id;

    private Integer aid;

    private String name;

    private String pkg;

    private String versionCode;

    private String versionName;

    private String imgUrl;

    private String runPic;

    private String simpledes;

    private String description;

    private String appSize;

    private String appIcon;

    private Integer userId;

    private String pid;

    private String appType;

    private Boolean status;

    private Date addTime;

    private String dcpid;

    private String dsid;

    private String ddlUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getRunPic() {
        return runPic;
    }

    public void setRunPic(String runPic) {
        this.runPic = runPic == null ? null : runPic.trim();
    }

    public String getSimpledes() {
        return simpledes;
    }

    public void setSimpledes(String simpledes) {
        this.simpledes = simpledes == null ? null : simpledes.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAppSize() {
        return appSize;
    }

    public void setAppSize(String appSize) {
        this.appSize = appSize == null ? null : appSize.trim();
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon == null ? null : appIcon.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getDcpid() {
        return dcpid;
    }

    public void setDcpid(String dcpid) {
        this.dcpid = dcpid == null ? null : dcpid.trim();
    }

    public String getDsid() {
        return dsid;
    }

    public void setDsid(String dsid) {
        this.dsid = dsid == null ? null : dsid.trim();
    }

    public String getDdlUrl() {
        return ddlUrl;
    }

    public void setDdlUrl(String ddlUrl) {
        this.ddlUrl = ddlUrl == null ? null : ddlUrl.trim();
    }
}