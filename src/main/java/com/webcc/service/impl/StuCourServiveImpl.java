package com.webcc.service.impl;

import com.webcc.mapper.StucourseMapper;
import com.webcc.model.StuCourC;
import com.webcc.model.StuS;
import com.webcc.model.Stucourse;
import com.webcc.model.Stuuser;
import com.webcc.service.IStuCourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StuCourServiveImpl implements IStuCourService {

    @Autowired
    StucourseMapper stucourseMapper;

    @Override
    public List<StuCourC> getCourlistByStu(Long stuid) {
        List<StuCourC> list = new ArrayList<>();
        try {
            list = stucourseMapper.selectCourByStuId(stuid);
        }catch (Exception e){
            System.out.println("获取学生已选课程异常"  + e );
        }
        return  list;
    }

    @Override
    public List<StuCourC> getExamlistByStu(Long stuid) {
        List<StuCourC> list = new ArrayList<>();
        try {
            list = stucourseMapper.selectExamByStuId(stuid);
        }catch (Exception e){
            System.out.println("获取学生已选课程异常"  + e );
        }
        return  list;
    }

    @Override
    public String setCour(Stucourse stuC){
        String result = "error" ;
        if (stucourseMapper.insertStuCour(stuC) > 0){
            result = "success";
        }
        return  result;
    }

    @Override
    public StuCourC getStuCByCourId(Map map){
        return stucourseMapper.selectCourByCourId(map);
    }

    @Override
    public void quitCour(Stucourse stucourse){
        stucourseMapper.deletStuCourByBean(stucourse);
    }

    @Override
    public List<Stuuser> getStuListByCourId(Integer courid){
        List<Stuuser> list = new ArrayList<>();
        try {
            list = stucourseMapper.selectStuListByCourId(courid);
        }catch (Exception e ){
            System.out.println("获取学生列表失败 " + e);
        }
        return list;
    }

    @Override
    public String saveGrade(HttpServletRequest request){
        String result = "error" ;
        String[] grades = request.getParameterValues("grade");
        String[] stuids = request.getParameterValues("stuid");
        String[] courids = request.getParameterValues("courid");
        int index = 0;
        Stucourse stucourse = new Stucourse();
        try {
            for (int i = 0 ; i < grades.length ; i++){
                stucourse.setStuid(Long.parseLong(stuids[i]));
                stucourse.setCourseid(Integer.parseInt(courids[i]));
                stucourse.setScore(Integer.parseInt(grades[i]));
                stucourseMapper.updataGrade(stucourse);
            }
            result = "success";
        }catch (Exception e ){
            System.out.println("保存成绩出错 " + e);
        }
        return result;
    }

    @Override
    public List<StuS> getStuS (Integer courid) {
        List<StuS> list  = new ArrayList<>();
        try {
            list =  stucourseMapper.selectStuSByCourId(courid);
        }catch ( Exception e){
            System.out.println("获取学生成绩失败 " + e);
        }
        return  list;
    }
}
