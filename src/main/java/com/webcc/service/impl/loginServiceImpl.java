package com.webcc.service.impl;

import com.webcc.common.EncodeUtils;
import com.webcc.mapper.AdminMapper;
import com.webcc.mapper.StuuserMapper;
import com.webcc.mapper.TeauserMapper;
import com.webcc.model.Stuuser;
import com.webcc.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhong on 16-6-10.
 */
@Service
public class loginServiceImpl implements ILoginService{

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    TeauserMapper teauserMapper;

    @Autowired
    StuuserMapper stuuserMapper;

    @Override
    public Long checkLogin(String userNo, String pwd, String userType){
        Long id = null;
        Map<String,String> map = new HashMap<>();
        map.put("useNo",userNo);
        map.put("pwd", EncodeUtils.MD5(pwd,"UTF-8"));
        try {
            switch (userType){
                case "student":
                    id = stuuserMapper.selectIdByMap(map);
                    break;
                case "teacher":
                    id = teauserMapper.selectIdByMap(map);
                    break;
                case "admin":
                    id = teauserMapper.selectIdByMap(map);
                    break;
            }
        }catch (Exception e) {
            // log
        }
        return id;
    }

}
