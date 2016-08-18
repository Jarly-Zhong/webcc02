package com.webcc.service.impl;

import com.webcc.mapper.TeauserMapper;
import com.webcc.model.Stuuser;
import com.webcc.model.Teauser;
import com.webcc.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhong on 16-6-9.
 */
@Service
public class TeaServiceImpl implements ITeaService{

    @Autowired
    TeauserMapper teauserMapper;

    @Override
    public Teauser getTeaByNO(String teaNO){
        Teauser teauser = null ;
        try {
            teauser = teauserMapper.selectTeaByNo(teaNO);
        }catch (Exception e){
            System.out.println("getTeaByNO error " +e);
        }
        return teauser;
    }

    @Override
    public Teauser getTeaById(Long teaid){
        Teauser teauser = null;
        try {
            teauser = teauserMapper.selectByPrimaryKey(teaid);
        }catch (Exception e){
            System.out.println("getTeaById error " +e);
        }
        return teauser;
    }

    @Override
    public String saveInfo(Teauser teauser){
        String result = "error";
        try{
            teauserMapper.updateTeaInfo(teauser);
            result = "success";
        }catch (Exception e ){
            System.out.println("保存教师信息失败" + e);
        }
        return result;
    }
}
