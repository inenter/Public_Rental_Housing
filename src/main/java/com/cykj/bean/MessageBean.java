package com.cykj.bean;

/**
 * @author: LQB
 * @Description:
 * @create: 2022/11/26 9:40
 */
public class MessageBean {

    private int code;   // 业务状态码 200成功  -200失败
    private String message;    // 成功或失败的提示信息
    private Object data;       // 数据
    private Object page;    // 分页信息

    public MessageBean() {

    }

    public MessageBean(int code, String message, Object data, Object page) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.page = page;
    }

    @Override
    public String toString() {
        return "MessageBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", page=" + page +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

}
