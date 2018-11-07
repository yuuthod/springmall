package com.example.springmall.sample.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<Sample> getSampleAll(){
		// 페이징과 관련 코드
		List<Sample> list = sampleMapper.selectSampleAll();
		return list;
	}
	
	// 2
	public void removeSample(int sampleNo){
		sampleMapper.deleteSample(sampleNo);
	}
	
	//3
	public void addSample(Sample sample) {
		sampleMapper.insertSample(sample);
	}
}
