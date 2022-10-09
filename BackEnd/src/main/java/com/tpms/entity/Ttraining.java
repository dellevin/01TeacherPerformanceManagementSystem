package com.tpms.entity;

public class Ttraining {
    private Integer tid;
    private String tnum;
    private String tname;
    private String ttraining;
    private String tmarks;

    public Ttraining() {
    }

    public Ttraining(Integer tid, String tnum, String tname, String ttraining, String tmarks) {
        this.tid = tid;
        this.tnum = tnum;
        this.tname = tname;
        this.ttraining = ttraining;
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

    public String getTtraining() {
        return ttraining;
    }

    public void setTtraining(String ttraining) {
        this.ttraining = ttraining;
    }

    public String getTmarks() {
        return tmarks;
    }

    public void setTmarks(String tmarks) {
        this.tmarks = tmarks;
    }

    @Override
    public String toString() {
        return "Ttraining{" +
                "tid=" + tid +
                ", tnum='" + tnum + '\'' +
                ", tname='" + tname + '\'' +
                ", ttraining='" + ttraining + '\'' +
                ", tmarks='" + tmarks + '\'' +
                '}';
    }
}
