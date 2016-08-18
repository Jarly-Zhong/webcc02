package com.webcc.service;

import com.webcc.model.Teauser;

/**
 * Created by zhong on 16-6-9.
 */
public interface ITeaService {

     Teauser getTeaByNO(String teaNO);

     Teauser getTeaById(Long teaid);

     String saveInfo(Teauser teauser);

}
