package com.example.springmall.sample.vo;

import java.sql.Date;

public class SampleFile {
	//auto 로 데이터 자동생성
	private int samplefileNo;
	//insertSample 이 실행되면서 데이터생성
	private int sampleNo;
	//multipartFile 이 실행되면서 데이터생성
	private String samplefilePath;
	private String samplefileName;
	private String samplefileExtention;
	private String samplefileFile;
	private long samplefileSize;
	private Date samplefileDate;
	public int getSamplefileNo() {
		return samplefileNo;
	}
	public void setSamplefileNo(int samplefileNo) {
		this.samplefileNo = samplefileNo;
	}
	public int getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(int sampleNo) {
		this.sampleNo = sampleNo;
	}
	public String getSamplefilePath() {
		return samplefilePath;
	}
	public void setSamplefilePath(String samplefilePath) {
		this.samplefilePath = samplefilePath;
	}
	public String getSamplefileName() {
		return samplefileName;
	}
	public void setSamplefileName(String samplefileName) {
		this.samplefileName = samplefileName;
	}
	public String getSamplefileExtention() {
		return samplefileExtention;
	}
	public void setSamplefileExtention(String samplefileExtention) {
		this.samplefileExtention = samplefileExtention;
	}
	public String getSamplefileFile() {
		return samplefileFile;
	}
	public void setSamplefileFile(String samplefileFile) {
		this.samplefileFile = samplefileFile;
	}
	public long getSamplefileSize() {
		return samplefileSize;
	}
	public void setSamplefileSize(long samplefileSize) {
		this.samplefileSize = samplefileSize;
	}
	public Date getSamplefileDate() {
		return samplefileDate;
	}
	public void setSamplefileDate(Date samplefileDate) {
		this.samplefileDate = samplefileDate;
	}
	
}
