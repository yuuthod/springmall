package com.example.springmall.sample.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.SampleAndFileList;
import com.example.springmall.sample.vo.SampleRequest;

@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService;

	// Spring은 매개변수에 들어간 객체는 자동으로 빈객체가 생성된다.
	// sampleList(Model model) -> Model model = new Model();

	// 1. 샘플목록
	@RequestMapping(value = "/sample/sampleList", method = RequestMethod.GET)
	public String sampleList(Model model, HttpServletRequest request) {
		System.out.println("SampleController.sampleList()호출");

		// 검색 데이터
		// 검색을 하지 않은 상황을 대비해 param값이 있으면 map에 데이터가 들어가도록 if문 사용
		Map<String, Object> searchMap = new HashMap<>();

		searchMap.put("category", request.getParameter("category"));
		if (request.getParameter("search") != null) {
			searchMap.put("search", request.getParameter("search"));
		}
		// 현재페이지
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		searchMap.put("currentPage", currentPage);

		Map<String, Object> listPageAll = sampleService.getSampleAll(searchMap);
		
		model.addAttribute("sampleList", listPageAll.get("list"));
		model.addAttribute("lastPage", listPageAll.get("lastPage"));
		model.addAttribute("currentPage", listPageAll.get("currentPage"));
		// 검색결과를 유지하기 위해 검색키워드도 함께
		model.addAttribute("category", request.getParameter("category"));
		model.addAttribute("search", request.getParameter("search"));

		return "/sample/sampleList";
	}

	// 2.샘플삭제
	@RequestMapping(value="/sample/removeSample", method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) {
		System.out.println("SampleController.removeSample()호출");
		sampleService.removeSample(sampleNo);
		return "redirect:/sample/sampleList";
	}

	// 3-1.입력 폼
	@RequestMapping(value = "/sample/addSample", method = RequestMethod.GET)
	public String addSample() {
		System.out.println("SampleController.addSample().get호출");
		return "/sample/addSample";
		// jquery, bootstrap, Sample command객체를 사용할것을 염두.
	}

	// 3-2.입력 액션
	@RequestMapping(value = "/sample/addSample", method = RequestMethod.POST)
	public String addSample(SampleRequest sampleRequest, HttpServletRequest request) {
		System.out.println("SampleController.addSample().post호출");
		// Sample 의 다양한 모양이 존재할 수 있다.
		// command객체의 멤버변수 == input태그 name속성 --> setter에 입력
		System.out.println("sampleRequest.getMultipartFile() :" + sampleRequest.getMultipartfile());
		
		sampleService.addSample(sampleRequest, request);
		return "redirect:/sample/sampleList";
	}

	/*
	 * DATA(변수) + FUNCTION(제어문, 연산자) = 프로그램언어 (압축되는 순서) 알고리즘 -> 프로세스 루틴 -> 함수
	 */

	// 4-1 수정 폼
	@RequestMapping(value = "/sample/modyfySample", method = RequestMethod.GET)
	public String modifySample(Model model, @RequestParam(value = "sampleNo", defaultValue = "1") int sampleNo) {
		System.out.println("SampleController.addSample().get호출");
		List<SampleAndFileList> sampleAndFileList = sampleService.getSample(sampleNo);
		model.addAttribute("sample", sampleAndFileList);

		return "/sample/modyfySample";
	}

	// 4-2 수정 액션
	@RequestMapping(value = "/sample/modyfySample", method = RequestMethod.POST)
	public String modifySample(SampleRequest sampleRequest,HttpServletRequest request) {
		System.out.println("SampleController.modifySample().post호출");
		sampleService.modifySample(sampleRequest, request);
		return "redirect:/sample/sampleList";
	}
	
	// 5 상세화면
	@RequestMapping(value = "/sample/detailSample", method = RequestMethod.GET)
	public String detailSample(Model model, @RequestParam(value = "sampleNo", defaultValue = "1") int sampleNo) {
		System.out.println("SampleController.detailSample().get호출");
		List<SampleAndFileList> sampleAndFileList = sampleService.getSample(sampleNo);
		for(int i=0; i<sampleAndFileList.size(); i++) {
			System.out.println("존재하는 파일 갯수 : " + sampleAndFileList.get(i).getSamplefileName());
		}
		
		model.addAttribute("samplelist", sampleAndFileList);
		
		return "/sample/detailSample";
	}
}
