package com.example.springmall.sample.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleAndFileList;

// Spring 이라고 전부 객체를 생성하는건 아니다. 약속된 Annotation이 붙어있어야 한다.
@Mapper
public interface SampleMapper {
	// 1. select all
	List<SampleAndFileList> selectSampleAll(Map<String, Object> resultPage);
	// 1-2. select one count 
	int selectSampleCount(Map<String, Object> searchCount);
	// 2. delete
	int deleteSample(int sampleNo);
	// 3. insert
	int insertSample(Sample sample);
	// 4-1. update
	int updateSample(Sample sample);
	// 4-2. update select one
	public abstract List<SampleAndFileList> updateSampleSelectOne(int sampleNo);
//  ─────────────── <- 이 두개가 붙어있어야 '무조건' 추상메서드인데,
//	interface는 '추상메서드'만 가질 수 있기때문에  추상메서드에 무조건 붙어있어야 하는 public과 abstract이 생략 되어있다.
	// 5. login select
	Sample loginSample(Sample sample);
}
