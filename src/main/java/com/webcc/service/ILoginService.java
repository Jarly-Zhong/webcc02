package com.webcc.service;

/**
 * Created by zhong on 16-6-10.
 */
public interface ILoginService {

    Long checkLogin(String userNO, String pwd,String userType);

}
