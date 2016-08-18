package com.webcc.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.webcc.mapper.CourseMapper;
import com.webcc.model.Course;
import com.webcc.model.CourseExample;
import com.webcc.model.CousrT;
import com.webcc.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpExchange;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhong on 16-6-10.
 */
@Service
public class CourseServiceImpl implements ICourseService{

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<CousrT> getCourList(){
        List<CousrT> list = new ArrayList<>();
        try {
            list = courseMapper.selectCourList();
        }catch (Exception e){
            System.out.println("获取课程列表异常" + e);
        }
        return list;
    }

    @Override
    public CousrT getCourTeaById( int courId){
        CousrT cousrT = null;
        try {
            cousrT = courseMapper.selectCourTeaById(courId);
        }catch (Exception e){
            System.out.println("获取课程异常" + e);
        }
        return cousrT;
    }

    @Override
    public List<CousrT> getAllCourList(){
        List<CousrT> list = new ArrayList<>();
        try {
            list = courseMapper.selectAllCourList();
        }catch (Exception e){
            System.out.println("获取课程列表异常" + e);
        }
        return list;

    }

    @Override
    public List<Course> getCourListByTeaId(Long teaid){
        List<Course> list = new ArrayList<>();
        try{
            list = courseMapper.selectCourListByTeaId(teaid);
        }catch (Exception e){
            System.out.println("getCourListByTeaId error " + e);
        }
        return  list;
    }

    @Override
    public boolean openCour(HttpServletRequest request){
        Course course = new Course();
        int id = 0 ;
        String courName = request.getParameter("courName");
        String courTime = request.getParameter("courTime");
        String maxSize = request.getParameter("maxSize");
        String teaId = request.getParameter("teaid");
        course.setStatus(0);
        if (courName!=null || !"".equals(courName)){
            course.setCourseName(courName);
        }else return false;

        if (courTime!= null || !"".equals(courTime)) {
            course.setCourseTime(courTime);
        }else return false;

        if (maxSize!= null || !"".equals(maxSize)) {
            course.setMax_size(Integer.parseInt(maxSize));
        }else return false;

        if (teaId!= null || !"".equals(teaId)) {
            course.setTeacherid(Integer.parseInt(teaId));
        }else return false;

        try {
            id = courseMapper.insert(course);
        }catch (Exception e){
            System.out.println("申请开课失败" + e);
        }
        if (id > 0 ){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Course> getCourListEnd(Long teaId){
        List<Course> list = null;
        list = courseMapper.selectCourListEndByTeaId(teaId);
        return list;
    }

    @Override
    public void addCurrent(int courid){
        courseMapper.updataCurrentSize(courid);
    }

    @Override
    public void delCurrent(int courid){
        courseMapper.updataCurrentSizeDel(courid);;
    }

    @Override
    public Course getCourById(int courid){
        Course course = null ;
        try {
            course = courseMapper.selectByPrimaryKey(courid);
        }catch (Exception e ){
            System.out.println("获取课程失败");
        }
        return  course;
    }

    @Override
    public void finishCours(String[] courid){
        for (String c : courid){
            courseMapper.updataCourSta(Integer.parseInt(c));
        }
    }

    @Override
    public void setEtime(HttpServletRequest request){
        Course course = new Course();
        String eTime = request.getParameter("eTime");
        String courid = request.getParameter("courid");
        course.setCourseId(Integer.parseInt(courid));
        course.setExamTime(eTime);
        courseMapper.updataExamT(course);
    }

    @Override
    public String delcourByid(int courid){
        String result = "error";
        try {
            courseMapper.deleteByPrimaryKey(courid);
            result  = "success";
        }catch (Exception e) {
            System.out.println("删除课程失败" + e);
        }
        return result;
    }

    @Override
    public String updateSta(int courid){
        String result = "error";
        try {
            courseMapper.updataCourSta(courid);
            result = "success";
        }catch (Exception e){
            System.out.println("同意开课出错" + e);
        }
        return result;
    }

    @Override
    public void updateAdm(Course course){
        courseMapper.updateByPrimaryKeySelective(course);
    }
}
