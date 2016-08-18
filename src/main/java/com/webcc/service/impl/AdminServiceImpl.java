package com.webcc.service.impl;

import com.webcc.mapper.AdminMapper;
import com.webcc.mapper.StuuserMapper;
import com.webcc.mapper.TeauserMapper;
import com.webcc.model.Admin;
import com.webcc.model.Course;
import com.webcc.model.Stuuser;
import com.webcc.model.Teauser;
import com.webcc.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhong on 16-6-9.
 */
@Service
public class AdminServiceImpl  implements IAdminService{

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    StuuserMapper stuuserMapper;

    @Autowired
    TeauserMapper teauserMapper;

    @Override
    public Admin getAdmByName(String aName){
        Admin admin = null ;
        try {
            admin = adminMapper.selectAdmByName(aName);
        }catch (Exception e){
            System.out.println(e);
        }
        return admin;
    }

    @Override
    public List<Stuuser> getStuList() {
        List<Stuuser> list = new ArrayList<>();
        list = stuuserMapper.selectStuList();
//        System.out.println(list);
        return list;
    }

    @Override
    public Stuuser getStu(Long stuId) {
        Stuuser stu = null;
        stu = stuuserMapper.selectStuById(stuId);
        return stu;
    }

    @Override
    public void updateStu(Stuuser stu) {
        stuuserMapper.updateByPrimaryKey(stu);
    }

    @Override
    public int deleteStu(Long stuId) {
        return stuuserMapper.deleteByPrimaryKey(stuId);
    }

    @Override
    public List<Teauser> getTeauList() {
        List<Teauser> list = new ArrayList<>();
        list = teauserMapper.selectTeaList();
        return list;
    }

    @Override
    public Teauser getTea(Long teaId) {
        Teauser tea = null;
        tea = teauserMapper.selectByPrimaryKey(teaId);
        return tea;    }

    @Override
    public void updatetea(Teauser teauser) {
        teauserMapper.updateByPrimaryKey(teauser);
    }

    @Override
    public int deletetea(Long teaId) {
        return teauserMapper.deleteByPrimaryKey(teaId);
    }

    @Override
    public void addStu(Stuuser stuuser) {
        stuuserMapper.insertSelective(stuuser);
    }

    @Override
    public void addTea(Teauser teauser) {
        teauserMapper.insertSelective(teauser);
    }

    @Override
    public List<Admin> getAdmiinList(){
       return adminMapper.selectAdmiinList();
    }

    @Override
    public Admin getAdminById(Long adminID){
        return adminMapper.selectByPrimaryKey(adminID);
    }

    @Override
    public void addAdm(Admin admin){
        adminMapper.insertSelective(admin);
    }

    @Override
    public void updateAdm(Admin admin){
        adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public void deleteadm(Long admid){
        adminMapper.deleteByPrimaryKey(admid);
    }

}
