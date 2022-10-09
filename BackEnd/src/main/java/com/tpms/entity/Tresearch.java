package com.tpms.entity;

public class Tresearch {
    private Integer tid;
    private String tnum;
    private String tname;
    private String tscience;
    private String tmarks;

    public String getTmarks() {
        return tmarks;
    }

    public void setTmarks(String tmarks) {
        this.tmarks = tmarks;
    }

    public Tresearch() {
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTnum() {
        return tnum;
    }

    public void setTnum(String tnum) {
        this.tnum = tnum;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTscience() {
        return tscience;
    }

    public void setTscience(String tscience) {
        this.tscience = tscience;
    }

    public Tresearch(Integer tid, String tnum, String tname, String tscience, String tmarks) {
        this.tid = tid;
        this.tnum = tnum;
        this.tname = tname;
        this.tscience = tscience;
        this.tmarks = tmarks;
    }

    public Tresearch(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Tresearch{" +
                "tid=" + tid +
                ", tnum='" + tnum + '\'' +
                ", tname='" + tname + '\'' +
                ", tscience='" + tscience + '\'' +
                ", tmarks='" + tmarks + '\'' +
                '}';
    }
}
