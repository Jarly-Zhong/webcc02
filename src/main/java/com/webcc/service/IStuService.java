package com.webcc.service;

import com.webcc.model.Stuuser;

/**
 * Created by zhong on 16-6-9.
 */
public interface IStuService {

     Stuuser getStuByNO(String stuNO);

     Stuuser getStuById(Long stuID);

     void saveInfo(Stuuser stuuser);
}
