package com.example.springmall.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.SampleFile;

@Mapper
public interface SampleFileMapper {
	int insertSampleFile(SampleFile sampleFile);
	int deleteSampleFile(int sampleNo);
	SampleFile deleteFolderSampleFile(int sampleNo); 
	int updateSampleFile(SampleFile sampleFile);
}
