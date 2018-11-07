package com.example.springmall.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

// Spring 이라고 전부 객체를 생성하는건 아니다. 약속된 Annotation이 붙어있어야 한다.
@Mapper
public interface SampleMapper {
	// 1. select all
	List<Sample> selectSampleAll();
	// 2. delete
	int deleteSample(int sampleNo);
	// 3. insert
	int insertSample(Sample sample);
	// 4. update
	int updateSample(Sample sample);
}
