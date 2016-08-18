package com.webcc.service;

import com.webcc.model.Admin;
import com.webcc.model.Course;
import com.webcc.model.Stuuser;
import com.webcc.model.Teauser;

import java.util.List;

/**
 * Created by zhong on 16-6-9.
 */
public interface IAdminService {

    Admin getAdmByName(String aName);

    List<Stuuser> getStuList();

    Stuuser getStu(Long stuId);

    void updateStu(Stuuser stu);

    int deleteStu(Long stuId);

    List<Teauser> getTeauList();

    Teauser getTea(Long teaId);

    void updatetea(Teauser teauser);

    int deletetea(Long teaId);

    void addStu(Stuuser stuuser);

    void addTea(Teauser teauser);

    List<Admin> getAdmiinList();

    Admin getAdminById(Long id);

    void addAdm(Admin admin);

    void updateAdm(Admin admin);

    void deleteadm(Long admid);

}
