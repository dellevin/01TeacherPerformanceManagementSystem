package com.tpms.entity;

public class Sicence {
    private Integer tid;
    private String courseName;
    private String descs;
    private String courseType;

    private String menLei;
    private String leiXing;
    private String wenJi;
    private String laiYuan;
    private String fanWei;
    private String banMian;
    private String yiWen;

    private String date1;

    private String doc;

    @Override
    public String toString() {
        return "Sicence{" +
                "tid=" + tid +
                ", courseName='" + courseName + '\'' +
                ", descs='" + descs + '\'' +
                ", courseType='" + courseType + '\'' +
                ", menLei='" + menLei + '\'' +
                ", leiXing='" + leiXing + '\'' +
                ", wenJi='" + wenJi + '\'' +
                ", laiYuan='" + laiYuan + '\'' +
                ", fanWei='" + fanWei + '\'' +
                ", banMian='" + banMian + '\'' +
                ", yiWen='" + yiWen + '\'' +
                ", date1='" + date1 + '\'' +
                ", doc='" + doc + '\'' +
                '}';
    }

    public Sicence() {
    }

    public Sicence(Integer tid, String courseName, String descs, String courseType, String menLei, String leiXing, String wenJi, String laiYuan, String fanWei, String banMian, String yiWen, String date1, String doc) {
        this.tid = tid;
        this.courseName = courseName;
        this.descs = descs;
        this.courseType = courseType;
        this.menLei = menLei;
        this.leiXing = leiXing;
        this.wenJi = wenJi;
        this.laiYuan = laiYuan;
        this.fanWei = fanWei;
        this.banMian = banMian;
        this.yiWen = yiWen;
        this.date1 = date1;
        this.doc = doc;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getMenLei() {
        return menLei;
    }

    public void setMenLei(String menLei) {
        this.menLei = menLei;
    }

    public String getLeiXing() {
        return leiXing;
    }

    public void setLeiXing(String leiXing) {
        this.leiXing = leiXing;
    }

    public String getWenJi() {
        return wenJi;
    }

    public void setWenJi(String wenJi) {
        this.wenJi = wenJi;
    }

    public String getLaiYuan() {
        return laiYuan;
    }

    public void setLaiYuan(String laiYuan) {
        this.laiYuan = laiYuan;
    }

    public String getFanWei() {
        return fanWei;
    }

    public void setFanWei(String fanWei) {
        this.fanWei = fanWei;
    }

    public String getBanMian() {
        return banMian;
    }

    public void setBanMian(String banMian) {
        this.banMian = banMian;
    }

    public String getYiWen() {
        return yiWen;
    }

    public void setYiWen(String yiWen) {
        this.yiWen = yiWen;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}
