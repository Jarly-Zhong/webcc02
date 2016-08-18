package com.webcc.controller;

import com.webcc.model.*;
import com.webcc.service.ICourseService;
import com.webcc.service.IStuCourService;
import com.webcc.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zhong on 16-6-10.
 */
@Controller
@RequestMapping("/student")
public class StuController {

    @Autowired
    IStuService stuService;

    @Autowired
    ICourseService courseService;

    @Autowired
    IStuCourService stuCourService;

    @RequestMapping("/courlist.htm")
    public ModelAndView classView(HttpServletRequest request,HttpSession session) {
        System.out.println(session.getAttribute("id"));
        ModelAndView mav = new ModelAndView("student/stu_courlist");
        Long stuId = (Long)session.getAttribute("id");
        Stuuser stuuser = stuService.getStuById(stuId);
        List<CousrT> list = courseService.getCourList();
        mav.addObject("courselist", list);
        mav.addObject("student", stuuser);
        return mav;
    }

    //  course have choose
    @RequestMapping("/courSet.htm")
    public ModelAndView courSet(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("student/stu_courC");
        Long stuId = Long.parseLong(request.getParameter("stuid"));
        Stuuser stuuser = stuService.getStuById(stuId);
        List<StuCourC> list = stuCourService.getCourlistByStu(stuId);
        mav.addObject("student", stuuser);
        mav.addObject("courselist", list);
        return mav;
    }

    // view student information
    @RequestMapping("/infoView.htm")
    public ModelAndView infoView(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("student/stu_info");
        String stuid = request.getParameter("stuid");
        Stuuser stuuser = stuService.getStuById(Long.parseLong(stuid));
        mav.addObject("stuinfo", stuuser);
        mav.addObject("student", stuuser);
        return mav;
    }

    // 查看考试时间
    @RequestMapping("/examView.htm")
    public ModelAndView examView(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("student/stu_exam");
        Long stuid = Long.parseLong(request.getParameter("stuid"));
        Stuuser stuuser = stuService.getStuById(stuid);
        mav.addObject("student", stuuser);
        List<StuCourC> list = stuCourService.getExamlistByStu(stuid);
        mav.addObject("courlist", list);
        return mav;
    }

    @RequestMapping("/gardeView.htm")
    public ModelAndView gradeView(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("student/stu_grade");
        Long stuid = Long.parseLong(request.getParameter("stuid"));
        Stuuser stuuser = stuService.getStuById(stuid);
        mav.addObject("student", stuuser);
        List<StuCourC> list = stuCourService.getExamlistByStu(stuid);
        mav.addObject("courlist", list);
        return mav;
    }

    //选课操作
    @RequestMapping("/courSet.do")
    @ResponseBody
    public String setCour(HttpServletRequest request,HttpServletResponse response) {
        Long stuId = Long.parseLong(request.getParameter("stuid"));
        Integer courId = Integer.parseInt(request.getParameter("courid"));
        Map<String, Object> map = new HashMap<>();
        map.put("stuid", stuId);
        map.put("courid", courId);
        List<StuCourC> list = stuCourService.getCourlistByStu(stuId);
        StuCourC sc = stuCourService.getStuCByCourId(map);
        CousrT cousrT =  courseService.getCourTeaById(courId);
        for (StuCourC s : list) {
            if ( null==sc ) {
                if (s.getCourseTime().equals(cousrT.getCourseTime())){
                    return  "reTime";
                }
            }else if (s.getCourseName().equals(sc.getCourseName())) {
                return "reSet";
            }
        }
        Stucourse newStuC = new Stucourse();
        newStuC.setCourseid(courId);
        newStuC.setStuid(stuId);
        courseService.addCurrent(courId);
        return stuCourService.setCour(newStuC);
    }

    //退课操作
    @RequestMapping("/quitCour.do")
    @ResponseBody
    public String quitCour(HttpServletRequest request,HttpServletResponse response) {
        Long stuId = Long.parseLong(request.getParameter("stuid"));
        Integer courId = Integer.parseInt(request.getParameter("courid"));
        Map<String, Integer> map = new HashMap<>();
        Stucourse StuC = new Stucourse();
        StuC.setCourseid(courId);
        StuC.setStuid(stuId);
        String result = "error";
        Course course = courseService.getCourById(courId);
        if (course.getStatus() > 1){
            return "open";
        }else {
            try{
                stuCourService.quitCour(StuC);
                courseService.delCurrent(courId);
                result = "success";
            }catch (Exception e){

            }
        }
        return result;
    }

    @RequestMapping("/saveInfo.do")
    @ResponseBody
    public String saveInfo(HttpServletRequest request,Stuuser stuuser){
        stuService.saveInfo(stuuser);
        return "success";
    }
}

