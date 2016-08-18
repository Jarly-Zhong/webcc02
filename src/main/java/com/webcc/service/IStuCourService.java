package com.webcc.service;

import com.webcc.model.StuCourC;
import com.webcc.model.StuS;
import com.webcc.model.Stucourse;
import com.webcc.model.Stuuser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IStuCourService {

    List<StuCourC> getCourlistByStu(Long stuid);

    String setCour(Stucourse stuC);

    List<StuCourC> getExamlistByStu(Long stuid);

    StuCourC getStuCByCourId(Map map);

    void quitCour(Stucourse stucourse);

    List<Stuuser> getStuListByCourId(Integer courid);

    String saveGrade(HttpServletRequest request);

    List<StuS> getStuS (Integer courid);

}
