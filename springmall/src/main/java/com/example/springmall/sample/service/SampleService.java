package com.example.springmall.sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	
	//		쿼리 -> 자바
	// select -> get
	// insert -> add
	// update -> modify
	// delete -> remove
	
	// 1 
	public Map<String, Object> getSampleAll(int currentPage){
		System.out.println("SampleService.getSampleAll()호출");
		// 페이징과 관련 코드 -- begin
		// currentPage : 현재페이지
		int rowPerPage = 10;
		int startRow = (int)((double)(currentPage-1)*rowPerPage);
		int countRow = sampleMapper.selectSampleCount();
		int lastPage = (int)((double)countRow/rowPerPage);
		if(countRow%rowPerPage != 0) {
			lastPage++;
		}
		System.out.println("startRow :"+startRow +"/countRow :"+countRow +"/lastPage :"+lastPage +"<--SampleService.getSampleAll");
		Map<String, Object> resultPage = new HashMap<>();
		resultPage.put("startRow", startRow);
		resultPage.put("rowPerPage", rowPerPage);
		// 페이징과 관련 코드 -- end
		// map으로 묶은 limit 데이터들을 입력데이터로 보냄.
		List<Sample> list = sampleMapper.selectSampleAll(resultPage);
		//리스트와 화면에 보내줘야할 currentPage와 lastPage를 map으로 묶어 리턴
		Map<String, Object> listPageAll = new HashMap<>();
		listPageAll.put("lastPage", lastPage);
		listPageAll.put("list", list);
		listPageAll.put("currentPage", currentPage);
		return listPageAll;
	}
	
	// 2
	public void removeSample(int sampleNo){
		System.out.println("SampleService.removeSample()호출");
		sampleMapper.deleteSample(sampleNo);
	}
	
	// 3
	public void addSample(Sample sample) {
		System.out.println("SampleService.addSample()호출");
		sampleMapper.insertSample(sample);
	}
	
	// 4-1
	public Sample getSample(int sampleNo) {
		System.out.println("SampleService.getSample()호출");
		return sampleMapper.updateSampleSelectOne(sampleNo);
	}
	
	// 4-2
	public int modifySample(Sample sample) {
		System.out.println("SampleService.modifySample()호출");
		return sampleMapper.updateSample(sample);
	}
}
