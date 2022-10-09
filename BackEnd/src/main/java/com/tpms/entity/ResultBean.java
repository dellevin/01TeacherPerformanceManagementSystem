package com.tpms.entity;

/*
    ResultBean类的作用就是封装数据，保存结果、状态、信息
    在使用时，我们将得到的信息存放在ResultBean对象中，并设置好相关的状态、信息，直接将
    ResultBean对象转换成json格式数据返回即可！
 */
public class ResultBean {
    private int code;//请求的状态结果
    private String msg;//请求的状态信息
    private Object data;//请求的数据结果

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultBean() {
    }

    public ResultBean(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
