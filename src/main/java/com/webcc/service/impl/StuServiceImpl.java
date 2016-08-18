package com.webcc.service.impl;

import com.webcc.mapper.StuuserMapper;
import com.webcc.model.Stuuser;
import com.webcc.model.Teauser;
import com.webcc.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhong on 16-6-9.
 */
@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    StuuserMapper stuuserMapper;

    @Override
    public Stuuser getStuByNO(String stuNO){
        Stuuser stuuser = null ;
       try {
           stuuser = stuuserMapper.selectStuByNo(stuNO);
       }catch (Exception e){
            System.out.println(e);
       }
        return stuuser;
    }

    @Override
    public Stuuser getStuById(Long stuID){
        Stuuser stuuser = null ;
        try {
            stuuser = stuuserMapper.selectByPrimaryKey(stuID);
        }catch (Exception e){
            System.out.println(e);
        }
        return stuuser;
    }

    @Override
    public void saveInfo(Stuuser stuuser){
        stuuserMapper.updateStuInfo(stuuser);
    }

}
