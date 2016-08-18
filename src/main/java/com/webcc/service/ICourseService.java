package com.webcc.service;

import com.webcc.model.Course;
import com.webcc.model.CousrT;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhong on 16-6-10.
 */
public interface ICourseService {

     List<CousrT> getCourList();

     List<CousrT> getAllCourList();

     List<Course> getCourListEnd(Long teaId);

     List<Course> getCourListByTeaId(Long teaid);

     boolean openCour(HttpServletRequest request);

     CousrT getCourTeaById( int courId);

     void addCurrent(int courid);

     void delCurrent(int courid);

     Course getCourById(int courid);

     void finishCours(String[] courid);

     void setEtime(HttpServletRequest request);

     String delcourByid(int courid);

     String updateSta(int courid);

     void updateAdm(Course course);

}
