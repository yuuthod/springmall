package com.example.springmall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@RequestMapping(value="/countMember", method=RequestMethod.GET)
	public String countMember(Model model) {
		int count = memberService.getCountMember();
		model.addAttribute("count",count);
		return "countMember"; // forward WEB-INF/jsp/memberCount.jsp
	}
}
