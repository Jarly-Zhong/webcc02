package com.webcc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.webcc.model.Course;
import com.webcc.model.StuS;
import com.webcc.model.Stuuser;
import com.webcc.model.Teauser;
import com.webcc.service.ICourseService;
import com.webcc.service.IStuCourService;
import com.webcc.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.awt.ModalityListener;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhong on 16-6-10.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    
    @Autowired
    ITeaService teaService;

    @Autowired
    ICourseService courseService;

    @Autowired
    IStuCourService stuCourService;

    // view course info
    @RequestMapping("/courView.htm")
    public ModelAndView courView(HttpServletRequest request, Long teaid){
        ModelAndView mav = new ModelAndView("teacher/tea_courView");
        Teauser teauser = teaService.getTeaById(teaid);
        List<Course> list = courseService.getCourListByTeaId(teaid);
        mav.addObject("teacher",teauser);
        mav.addObject("courlist",list);
        return mav;
    }

    // 申请开课 view
    @RequestMapping("/courOpen.htm")
    public ModelAndView courOpen(HttpServletRequest request, Long teaid){
        ModelAndView mav = new ModelAndView("teacher/tea_courOpen");
        Teauser teauser = teaService.getTeaById(teaid);
        mav.addObject("teacher",teauser);
        return  mav;
    }

    // 申请开课 do
    @RequestMapping("/courOpen.do")
    @ResponseBody
    public String courOpenDo(HttpServletRequest request){
        String data = "error";
        if (courseService.openCour(request)){
            data =  "success";
        }else {
            data =  "error";
        }
        return data;
    }

    // view teacher information
    @RequestMapping("/infoView.htm")
    public ModelAndView infoView(HttpServletRequest request, Long teaid){
        ModelAndView mav = new ModelAndView("teacher/tea_info");
        Teauser teauser = teaService.getTeaById(teaid);
        mav.addObject("stuinfo",teauser);
        mav.addObject("teacher",teauser);
        return  mav;
    }


    @RequestMapping("/setGrade.htm")
    public ModelAndView setGrade(HttpServletRequest request,Long teaid){
        ModelAndView mav = new ModelAndView("teacher/tea_grade");
        Teauser teauser = teaService.getTeaById(teaid);
        mav.addObject("teacher",teauser);
        List<Course> list = courseService.getCourListEnd(teaid);
        mav.addObject("courlist",list);
        return  mav;
    }


    @RequestMapping("/setGrade.do")
    public ModelAndView setGradeDo(HttpServletRequest request,Long teaid, Integer courid){
        ModelAndView mav = new ModelAndView("teacher/tea_setGrade");
        List<Stuuser> list = stuCourService.getStuListByCourId(courid);
        Teauser teauser = teaService.getTeaById(teaid);
        mav.addObject("teacher",teauser);
        mav.addObject("stuList",list);
        mav.addObject("courid",courid);
        return  mav;
    }

    @RequestMapping("/saveGrade.do")
    @ResponseBody
    public String saveGrade(HttpServletRequest request){
        String result = stuCourService.saveGrade(request);
        String[] courid = request.getParameterValues("courid");
        if (result.equals("success")){
            courseService.finishCours(courid);
        }
        return  result;
    }

    // 查看选课情况
    @RequestMapping("/courStu.htm")
    public ModelAndView courStuVie (HttpServletRequest request, Long teaid, Integer courid){
        ModelAndView mav = new ModelAndView("/teacher/tea_stuTab");
        Teauser teauser = teaService.getTeaById(teaid);
        mav.addObject("teacher",teauser);
        List<Stuuser> list = stuCourService.getStuListByCourId(courid);
        mav.addObject("stuList",list);
        return mav ;
    }

    //设置考试时间html
    @RequestMapping("/setETime.htm")
    public ModelAndView viewETime (HttpServletRequest request,Long teaid, Integer courid){
        ModelAndView mav = new ModelAndView("/teacher/tea_setETime");
        Teauser teauser = teaService.getTeaById(teaid);
        mav.addObject("teacher",teauser);
        Course course = courseService.getCourById(courid);
        mav.addObject("course",course);
        return mav ;
    }

    //设置考试时间 do
    @RequestMapping("/setETime.do")
    @ResponseBody
    public String setETime (HttpServletRequest request){
        String result = "error";
        try {
            courseService.setEtime(request);
            result = "success";
        }catch (Exception e ){
            System.out.println("保存考试时间出错 " + e);
        }
        return result;
    }

    //结课操作 do
    @RequestMapping("/endCour.do")
    @ResponseBody
    public String endCourse (HttpServletRequest request){
        String result = "error";
        String[] courid = request.getParameterValues("courid");
        try {
            courseService.finishCours(courid);
            result = "success";
        }catch (Exception e ){
            System.out.println("service 保存考试时间出错" + e);
        }
        return result;
    }

    //查看学生成绩
    @RequestMapping("/viewGrade.htm")
    public ModelAndView viewGrade (HttpServletRequest request,Long teaid,Integer courid){
        ModelAndView mav = new ModelAndView("/teacher/tea_viewGrade");
        Teauser teauser = teaService.getTeaById(teaid);
        mav.addObject("teacher",teauser);
        List<StuS> list = stuCourService.getStuS(courid);
        mav.addObject("stuSList",list);
        return  mav;
    }

    @RequestMapping("/saveInfo.do")
    @ResponseBody
    public String saveInfo(HttpServletRequest request,Teauser teauser){
        String result = teaService.saveInfo(teauser);
        return result;
    }

}
