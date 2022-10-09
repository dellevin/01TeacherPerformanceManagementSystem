package com.tpms.entity;

public class Tteaching {
    private Integer tid;
    private String tnum;
    private String tname;
    private String tteaching;
    private String tmarks;

    public Tteaching() {
    }

    public Tteaching(Integer tid, String tnum, String tname, String tteaching, String tmarks) {
        this.tid = tid;
        this.tnum = tnum;
        this.tname = tname;
        this.tteaching = tteaching;
        this.tmarks = tmarks;
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

    public String getTteaching() {
        return tteaching;
    }

    public void setTteaching(String tteaching) {
        this.tteaching = tteaching;
    }

    public String getTmarks() {
        return tmarks;
    }

    public void setTmarks(String tmarks) {
        this.tmarks = tmarks;
    }

    @Override
    public String toString() {
        return "Tteaching{" +
                "tid=" + tid +
                ", tnum='" + tnum + '\'' +
                ", tname='" + tname + '\'' +
                ", tteaching='" + tteaching + '\'' +
                ", tmarks='" + tmarks + '\'' +
                '}';
    }
}
