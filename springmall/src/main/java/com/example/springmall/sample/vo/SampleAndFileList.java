package com.example.springmall.sample.vo;

import java.sql.Date;

public class SampleAndFileList {
	private int sampleNo;
	private String sampleId;
	private String samplefilePath;
	private String samplefileName;
	private String samplefileExt;
	private Date samplefileDate;
	public int getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(int sampleNo) {
		this.sampleNo = sampleNo;
	}
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
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
	public String getSamplefileExt() {
		return samplefileExt;
	}
	public void setSamplefileExt(String samplefileExt) {
		this.samplefileExt = samplefileExt;
	}
	public Date getSamplefileDate() {
		return samplefileDate;
	}
	public void setSamplefileDate(Date samplefileDate) {
		this.samplefileDate = samplefileDate;
	}
	
	
}
