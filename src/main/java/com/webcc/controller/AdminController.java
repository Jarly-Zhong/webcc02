package com.webcc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.webcc.common.EncodeUtils;
import com.webcc.model.*;
import com.webcc.service.IAdminService;
import com.webcc.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IAdminService adminService;

    @Autowired
    ICourseService courseService;

    @RequestMapping("/adminstu.do")
    public ModelAndView showAdminStu(HttpServletRequest request,Long admid){
        ModelAndView mav = new ModelAndView("admin/admin_stu");
        Admin admin = adminService.getAdminById(admid);
        mav.addObject("admin",admin);
        mav.addObject("stuList",adminService.getStuList());
        return mav;
    }

    @RequestMapping("/admintea.do")
    public ModelAndView showAdminTea(HttpServletRequest request,Long admid){
        ModelAndView mav = new ModelAndView("admin/admin_tea");
        Admin admin = adminService.getAdminById(admid);
        mav.addObject("admin",admin);
        mav.addObject("teaList",adminService.getTeauList());
        return mav;
    }

    @RequestMapping("/admincourse.do")
    public ModelAndView showAdminCourse(HttpServletRequest request,Long admid){
        ModelAndView mav = new ModelAndView("admin/admin_course");
        Admin admin = adminService.getAdminById(admid);
        mav.addObject("admin",admin);
        mav.addObject("courseList",courseService.getAllCourList());
        return mav;
    }

    @RequestMapping("/adminadmin.do")
    public ModelAndView showAdminAdmin(HttpServletRequest request,Long admid){
        ModelAndView mav = new ModelAndView("admin/admin_admin");
        Admin admin = adminService.getAdminById(admid);
        mav.addObject("admin",admin);
        mav.addObject("adminList",adminService.getAdmiinList());
        return mav;
    }

    @RequestMapping("showupdatestu.do")
    public ModelAndView showUpdateStu(HttpServletRequest request,Long admId, Long stuid){
        ModelAndView mav = new ModelAndView("admin/showupdate_stu");
        mav.addObject("admin",adminService.getAdminById(admId));
        mav.addObject("stu",adminService.getStu(stuid));
        return mav;
    }

    @RequestMapping("showupdatetea.do")
    public ModelAndView showUpdateTea(HttpServletRequest request,Long teaid, Long admId ){
        ModelAndView mav = new ModelAndView("admin/showupdate_tea");
        mav.addObject("admin",adminService.getAdminById(admId));
        mav.addObject("tea",adminService.getTea(teaid));
        return mav;
    }

    @RequestMapping("/showupdateadm.do")
    public ModelAndView showUpdateAdm(HttpServletRequest request, Long adm,Long admId){
        ModelAndView mav = new ModelAndView("admin/showupdate_adm");
        mav.addObject("adm",adminService.getAdminById(adm));
        mav.addObject("admin",adminService.getAdminById(admId));
        return mav;
    }

    @RequestMapping("/showupdatecourse.do")
    public ModelAndView updataCourse(HttpServletRequest request,Integer courid , Long admId){
        ModelAndView mav = new ModelAndView("admin/showupdate_cour");
        mav.addObject("admin",adminService.getAdminById(admId));
        CousrT cousrT = courseService.getCourTeaById(courid);
        mav.addObject("course",cousrT);
        return mav;
    }


    @RequestMapping("/updatestu.do")
    @ResponseBody
    public String updateStu(HttpServletRequest req,Stuuser stuuser){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String pwdMd5 = EncodeUtils.MD5(stuuser.getPwd(), "UTF-8");
        stuuser.setPwd(pwdMd5);
        String res = "error";
        try {
            adminService.updateStu(stuuser);
            res = "success";
        }catch (Exception e){

        }
        return res;
    }

    @RequestMapping("/updatetea.do")
    @ResponseBody
    public String updateTea(HttpServletRequest req,Teauser teauser){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        teauser.setPwd(EncodeUtils.MD5(teauser.getPwd(),"UTF-8"));
        String res = "error";
        try {
            adminService.updatetea(teauser);
            res = "success";
        }catch (Exception e){
        }
        return res;
    }

    @RequestMapping("/updateadm.do")
    @ResponseBody
    public String updateAdm(HttpServletRequest req,Admin admin){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        admin.setPwd(EncodeUtils.MD5(admin.getPwd(),"UTF-8"));
        String res = "error";
        try {
            adminService.updateAdm(admin);
            res = "success";
        }catch (Exception e){

        }
        return res;
    }

    @RequestMapping("/updatecour.do")
    @ResponseBody
    public String updatecour(HttpServletRequest req){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String courid = req.getParameter("courid");
        String courseName = req.getParameter("courseName");
        String courseTime = req.getParameter("courseTime");
        String currentSize = req.getParameter("currentSize");
        String maxSize = req.getParameter("maxSize");
        String status = req.getParameter("status");
        Course course = new Course();
        course.setCourseId(Integer.parseInt(courid));
        course.setCourseName(courseName);
        course.setCourseTime(courseTime);
        course.setCurrent_size(Integer.parseInt(currentSize));
        course.setMax_size(Integer.parseInt(maxSize));
        course.setStatus(Integer.parseInt(status));
        String res = "error";
        try {
            courseService.updateAdm(course);
            res = "success";
        }catch (Exception e){

        }
        return res;
    }

    @RequestMapping("/deletestu.do")
    @ResponseBody
    public String deleteStu(HttpServletRequest req,Long stuId){
        String result = "error";
        try {
            adminService.deleteStu(stuId);
            result = "success";
        }catch (Exception e ){
            System.out.println("删除学生信息失败" + e);
        }
        return result;
    }

    @RequestMapping("/deletetea.do")
    @ResponseBody
    public String deletetea(HttpServletRequest req,Long teaid){
        String result = "error";
        try {
            adminService.deletetea(teaid);
            result = "success";
        }catch (Exception e ){
            System.out.println("删除教师信息失败" + e);
        }
        return result;
    }

    @RequestMapping("/deleteadm.do")
    @ResponseBody
    public String deleteadm(HttpServletRequest req,Long adm){
        String result = "error";
        try {
            adminService.deleteadm(adm);
            result = "success";
        }catch (Exception e ){
            System.out.println("删除教师信息失败" + e);
        }
        return result;
    }

    @RequestMapping("/deletecourse.do")
    @ResponseBody
    public String deletecourse(HttpServletRequest req){
        int courid = Integer.parseInt(req.getParameter("courid"));
        return  courseService.delcourByid(courid);
    }

    @RequestMapping("/showaddstu.do")
    public ModelAndView showAddStu(HttpServletRequest request,Long admId){
        ModelAndView mav = new ModelAndView("admin/add_stu");
        mav.addObject("admin", adminService.getAdminById(admId));
        return mav;
    }

    @RequestMapping("/showaddtea.do")
    public ModelAndView showAddTea(HttpServletRequest request, Long admId){
        ModelAndView mav = new ModelAndView("admin/add_tea");
        mav.addObject("admin", adminService.getAdminById(admId));
        return mav;
    }

    @RequestMapping("/showaddadm.do")
    public ModelAndView showAddadm(HttpServletRequest request, Long admId){
        ModelAndView mav = new ModelAndView("admin/add_adm");
        mav.addObject("admin", adminService.getAdminById(admId));
        return mav;
    }

    @RequestMapping("/showaddcour.do")
    public ModelAndView showAddcour(HttpServletRequest request, Long admId){
        ModelAndView mav = new ModelAndView("admin/add_cour");
        mav.addObject("admin", adminService.getAdminById(admId));
        return mav;
    }

    @RequestMapping("/addstu.do")
    public String addStu(HttpServletRequest req,Stuuser stuuser){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String pswMd5 = EncodeUtils.MD5(stuuser.getStuno(),"UTF-8");
        stuuser.setPwd(pswMd5);
        String admid = req.getParameter("admId");
        adminService.addStu(stuuser);
        return "redirect:/admin/adminstu.do?admid=" + admid;
    }

    @RequestMapping("/addtea.do")
    public String addTea(HttpServletRequest req){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String admid = req.getParameter("admId");
        String teaName = req.getParameter("teaname");
        String teaNo = req.getParameter("teano");
        int teaSex = Integer.parseInt(req.getParameter("teasex"));
        String birthday = req.getParameter("birthday");
        String tel = req.getParameter("tel");
        String pwd = teaNo;
        Teauser teauser = new Teauser(teaName,teaNo,teaSex,birthday,tel,pwd);
        adminService.addTea(teauser);
        return "redirect:/admin/admintea.do?admid=" + admid;
    }

    @RequestMapping("/addadm.do")
    public String addAdm(HttpServletRequest req){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String admid = req.getParameter("admId");
        String aName = req.getParameter("aName");
        String pwd = req.getParameter("pwd");
        Admin admin = new Admin();
        admin.setAname(aName);
        admin.setPwd(pwd);
        adminService.addAdm(admin);
        return "redirect:/admin/adminadmin.do?admid=" + admid;
    }

    @RequestMapping("/returnadmin.do")
    public String returnAdmin() {
        return "wel_admin";
    }


    //同意开课
    @RequestMapping("/agreeCour.do")
    public String agreeCour(HttpServletRequest request){
        String result = courseService.updateSta(Integer.parseInt(request.getParameter("courid")));
        return result;
    }
}
