package com.chen.helloproject.domainproject.domain;

/**
 * 行业分类表
 */
public class Industry {

    private int  industryid;
    private String   industryname;
    private int  parentid;

    public Industry() {
    }

    public Industry(int industryid, String industryname, int parentid) {
        this.industryid = industryid;
        this.industryname = industryname;
        this.parentid = parentid;
    }

    public int getIndustryid() {
        return industryid;
    }

    public void setIndustryid(int industryid) {
        this.industryid = industryid;
    }

    public String getIndustryname() {
        return industryname;
    }

    public void setIndustryname(String industryname) {
        this.industryname = industryname;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "industryid=" + industryid +
                ", industryname='" + industryname + '\'' +
                ", parentid=" + parentid +
                '}';
    }
}
