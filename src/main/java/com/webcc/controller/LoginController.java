package com.webcc.controller;

import com.webcc.model.Admin;
import com.webcc.model.Stuuser;
import com.webcc.model.Teauser;
import com.webcc.service.IAdminService;
import com.webcc.service.ILoginService;
import com.webcc.service.IStuService;
import com.webcc.service.ITeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class LoginController {

	@Autowired
	IAdminService adminService;

	@Autowired
	IStuService stuService;

	@Autowired
	ITeaService teaService;

	@Autowired
	ILoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "index";
	}

	@RequestMapping("/login.do")
	public ModelAndView checkLogin(HttpSession session, String userName, String passWord,String opR) {
		ModelAndView mav = new ModelAndView();
		Long id = loginService.checkLogin(userName, passWord, opR);
		if (null != id) {
			session.setAttribute("userId", id);
			if (opR.equals("student")) {
				Stuuser stuuser = stuService.getStuById(id);
				mav.addObject("student", stuuser);
				mav.setViewName("wel_stu");
				session.setAttribute("user",stuuser);
			} else if (opR.equals("teacher")) {
				Teauser teauser = teaService.getTeaById(id);
				mav.addObject("teacher", teauser);
				mav.setViewName("wel_teacher");
				session.setAttribute("user",teauser);
			} else if (opR.equals("admin")) {
				Admin admin = adminService.getAdminById(id);
				mav.addObject("admin", admin);
				mav.setViewName("wel_admin");
				session.setAttribute("user",admin);
			} else {
				mav.setViewName("erroruser");
			}
		}
		return mav;
	}
}