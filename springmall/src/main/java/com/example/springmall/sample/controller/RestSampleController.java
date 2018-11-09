package com.example.springmall.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
//객체를 리턴하면 json파일로 변경 해준다. , AJAX를 사용할때 사용
import org.springframework.web.bind.annotation.RestController;

import com.example.springmall.sample.vo.Sample;

@RestController
public class RestSampleController { // REST API
	@RequestMapping(value="/getRestSample")
	public Sample getRestSample() {
		return new Sample(1, "guest", "1234", 0);		
	}
}
