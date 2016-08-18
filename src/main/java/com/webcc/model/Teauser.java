package com.webcc.model;

import java.util.Date;

public class Teauser {
    private Long id;

    private String teaname;

    private String teano;

    private Integer teasex;

    private String birthday;

    private String tel;

    private String pwd;

    public Teauser() {
    }

    public Teauser(String teaname, String teano, Integer teasex, String birthday, String tel, String pwd) {
        this.teaname = teaname;
        this.teano = teano;
        this.teasex = teasex;
        this.birthday = birthday;
        this.tel = tel;
        this.pwd = pwd;
    }

    public Teauser(Long id, String teaname, String teano, Integer teasex, String birthday, String tel, String pwd) {
        this.id = id;
        this.teaname = teaname;
        this.teano = teano;
        this.teasex = teasex;
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

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname == null ? null : teaname.trim();
    }

    public String getTeano() {
        return teano;
    }

    public void setTeano(String teano) {
        this.teano = teano == null ? null : teano.trim();
    }

    public Integer getTeasex() {
        return teasex;
    }

    public void setTeasex(Integer teasex) {
        this.teasex = teasex;
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