package com.example.springmall.sample.vo;

public class Sample {
	private int sampleNo;
	private String sampleId;
	private String samplePw;
	private int level;
	public int getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(int sampleNo) {
		this.sampleNo = sampleNo;
		System.out.println(sampleNo+"Sample.setSampleNo()");
	}
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
		System.out.println(sampleId+"Sample.setSampleId()");
	}
	public String getSamplePw() {
		return samplePw;
	}
	public void setSamplePw(String samplePw) {
		this.samplePw = samplePw;
		System.out.println(samplePw+"Sample.setSamplePw()");
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
		System.out.println(level+"Sample.setLevel()");
	}
	@Override
	public String toString() {
		return "Sample [sampleNo=" + sampleNo + ", sampleId=" + sampleId + ", samplePw=" + samplePw + ", level=" + level
				+ "]";
	}
	
}
