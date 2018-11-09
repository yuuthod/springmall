package com.example.springmall.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class LoginController {
	@Autowired
	private SampleService sampleService; 
	
	//로그인 폼
	@RequestMapping(value="/sample/loginSample",method=RequestMethod.GET)
	public String sampleLogin(HttpSession session) {
		System.out.println("LoginController.sampleLogin().get호출");
		//session에 아이디값이 남아있으면 (즉, 로그아웃이 정상적으로 되지 않았다면) 로그인페이지에 접근 할 수 없도록 처리
		String returnSample = null;
		if(session.getAttribute("sessionSample") != null) {
			returnSample = "redirect:/sample/mainSample";
		}else{
			returnSample = "/sample/loginForm";
		}
		return returnSample;
	}
	//로그인 액션
	@RequestMapping(value="/sample/loginSample",method=RequestMethod.POST)
	public String sampleLogin(Sample sample,HttpSession session) {
		//request.getHttpSession();
		System.out.println("LoginController.sampleLogin().post호출");
		String loginReturn = null;
		if(sampleService.loginSample(sample) != null) {
			System.out.println("로그인 성공");
			session.setAttribute("sessionSample", sampleService.loginSample(sample));
			loginReturn = "redirect:/sample/mainSample";
		}else {
			System.out.println("로그인 실패");
			loginReturn = "/sample/loginForm";
		}
		return loginReturn;
	}
	//메인페이지
	@RequestMapping(value="/sample/mainSample",method=RequestMethod.GET)
	public String mainSample(HttpSession session) {
		String returnSample = null;
		//session에 아이디값이 없다면 (즉, 로그아웃이 정상적으로 처리되었다면) 메인페이지에 접근 할 수 없도록 처리
		if(session.getAttribute("sessionSample") != null) {
			returnSample = "/sample/mainSample";
		}else{
			returnSample = "redirect:/sample/loginSample";
		}
		return returnSample;
	}
	//로그아웃
	@RequestMapping(value="/sample/logoutSample", method=RequestMethod.GET)
	public String sampleLogout(HttpSession session) {
		System.out.println("LoginController.sampleLogout()호출");
		session.invalidate();
		return "redirect:/sample/loginSample";
	}
}
