package com.webcc.model;

import java.util.Date;

public class Stuuser {

    private Long id;

    private String stuname;

    private String stuno;

    private Integer stusex;

    private String birthday;

    private String tel;

    private String pwd;

    public Stuuser() {
    }

//    public Stuuser(Long id, String stuname , String stuno, Integer stusex, Date birthday, String tel, String pwd){
//        this.id = id ;
//        this.stuname = stuname;
//        this.stuno = stuno;
//        this.stusex = stusex;
//        this.birthday = birthday;
//        this.tel = tel;
//        this.pwd = pwd;
//    }

    public Stuuser(String stuname, String stuno, Integer stusex, String birthday, String tel, String pwd) {
        this.stuname = stuname;
        this.stuno = stuno;
        this.stusex = stusex;
        this.birthday = birthday;
        this.tel = tel;
        this.pwd = pwd;
    }

    public Stuuser(Long id, String stuname, String stuno, Integer stusex, String birthday, String tel, String pwd) {
        this.id = id;
        this.stuname = stuname;
        this.stuno = stuno;
        this.stusex = stusex;
        this.birthday = birthday;
        this.tel = tel;
        this.pwd = pwd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno == null ? null : stuno.trim();
    }

    public Integer getStusex() {
        return stusex;
    }

    public void setStusex(Integer stusex) {
        this.stusex = stusex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
}