package com.example.springmall.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService; 
	
	// 1. 샘플목록
	@RequestMapping(value="/sample/sampleList",method=RequestMethod.GET)
	public String sampleList(Model model) { // Model model = new Model();
		List<Sample> sampleList = sampleService.getSampleAll();
		model.addAttribute("sampleList", sampleList);
		return "/sample/sampleList";
	}
	
	// 2.샘플삭제
	@RequestMapping(value="/sample/removeSample", method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) {
		sampleService.removeSample(sampleNo);
		return "redirect:/sample/sampleList";
	}
	
	// 3-1.샘플추가 화면
	@RequestMapping(value="/sample/addSample", method=RequestMethod.GET)
	public String addSample() {
		return "/sample/sampleInsert";
	}
	
	// 3-2.샘플추가 실행
	@RequestMapping(value="/sample/addSample", method=RequestMethod.POST)
	public String addSample(Sample sample) {
		sampleService.addSample(sample);
		return "redirect:/sample/sampleList";
	}
	
	
}
