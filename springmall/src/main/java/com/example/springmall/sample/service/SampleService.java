package com.example.springmall.sample.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.springmall.sample.mapper.SampleFileMapper;
import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleAndFileList;
import com.example.springmall.sample.vo.SampleFile;
import com.example.springmall.sample.vo.SampleRequest;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	
	@Autowired
	private SampleFileMapper sampleFileMapper;
	
	//	쿼리 -> 자바
	// select -> get
	// insert -> add
	// update -> modify
	// delete -> remove
	
	// 3 입력 액션 수정
	public int addSample(SampleRequest sampleRequest) {
		Sample sample = new Sample();
		
		sample.setSampleId(sampleRequest.getSampleId());
		sample.setSamplePw(sampleRequest.getSamplePw());
		sampleMapper.insertSample(sample); 

		SampleFile sampleFile = new SampleFile();
		MultipartFile multipartFile = sampleRequest.getMultipartfile();
		
		// 1. samplefileNo : AutoIncrement
		// 2. sampleNo
		sampleFile.setSampleNo(sample.getSampleNo());
		
		// 3. samplefilePath
		String path = "c:\\uploads"; //복잡한 루틴을 통해서
		sampleFile.setSamplefilePath(path);
		
		// 4. 확장자 추출
		// originalFileName : 이름.확장자
		String originalFileName = multipartFile.getOriginalFilename();
		System.out.println("originalFileName: " + originalFileName);
		int idx = originalFileName.lastIndexOf(".");
		String ext = originalFileName.substring(idx+1);
		System.out.println("ext: " + ext);
		sampleFile.setSamplefileExtention(ext);
		
		// 5. 파일이름
		//파일이름 UUID를 이용해 랜덤으로 생성 , UUID타입에서 다시 스트링으로 변경
		String fileName = UUID.randomUUID().toString();
		System.out.println("fileName: " + fileName);
		sampleFile.setSamplefileName(fileName);			
		
		// 6. 타입
		sampleFile.setSamplefileFile(multipartFile.getContentType());
		
		// 7. 크기
		sampleFile.setSamplefileSize(multipartFile.getSize());
		
		// 	파일업로드
		//	1. 내가 원하는 이름의 빈파일을 하나 만들자
		//	transferTo()의 매개변수 타입에 맞춘 후 입력데이터
		File f = new File(path+"\\"+fileName+"."+ext);
		System.out.println("f: " + f);
		//	2. multipartFile파일을 빈파일로 복사하자.
		try {
			multipartFile.transferTo(f);
			System.out.println("예외처리도 잘 실행");
		} catch (IllegalStateException e) { //상태오류
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sampleFileMapper.insertSampleFile(sampleFile);
		return 0;
	}
	
	
	
	// 1 
	public Map<String, Object> getSampleAll(Map<String, Object> searchMap){
		System.out.println("SampleService.getSampleAll()호출");
		//	페이징과 관련 코드 -- begin
		int currentPage = (int)searchMap.get("currentPage");
		int rowPerPage = 5;
		int startRow = (int)((double)(currentPage-1)*rowPerPage);
		
		//	검색 후 마지막 페이지를 구하기 위해
		Map<String, Object> searchCount = new HashMap<>();
		searchCount.put("category", searchMap.get("category"));
		searchCount.put("search", searchMap.get("search"));
		int countRow = sampleMapper.selectSampleCount(searchCount);
		
		int lastPage = (int)((double)countRow/rowPerPage);
		if(countRow%rowPerPage != 0) {
			lastPage++;
		}
		
		System.out.println("startRow :"+startRow +"/countRow :"+countRow +"/lastPage :"+lastPage +"<--SampleService.getSampleAll");
		Map<String, Object> resultPage = new HashMap<>();
		resultPage.put("startRow", startRow);
		resultPage.put("rowPerPage", rowPerPage);
		//	페이징과 관련 코드 -- end
		
		//	검색
		resultPage.put("category", searchMap.get("category"));
		resultPage.put("search", searchMap.get("search"));
		
		// map으로 묶은 limit 데이터들을 입력데이터로 보냄.
		List<SampleAndFileList> list = sampleMapper.selectSampleAll(resultPage);
		//	리스트와 화면에 보내줘야할 currentPage와 lastPage를 map으로 묶어 리턴
		Map<String, Object> listPageAll = new HashMap<>();
		listPageAll.put("lastPage", lastPage);
		listPageAll.put("list", list);
		listPageAll.put("currentPage", currentPage);
		
		return listPageAll;
	}
	
	// 2
	//	파일 삭제 후 sample삭제
	public int removeSample(int sampleNo){
		System.out.println("SampleService.removeSample()호출");
		
		//	폴더 안 파일삭제
		//	파일 주소값을 불러오기 위한 select
		SampleFile sampleFile = sampleFileMapper.deleteFolderSampleFile(sampleNo);
		String path = sampleFile.getSamplefilePath();
		String name = sampleFile.getSamplefileName();
		String ext = sampleFile.getSamplefileExtention();
		
		String pathAll = path+"\\"+name+"."+ext; // 삭제할 파일의 경로
		System.out.println(pathAll + "<== pathAll");
		File file = new File(pathAll);
		file.delete();
		
		//file 삭제
		sampleFileMapper.deleteSampleFile(sampleNo);
		//sample 삭제
		return sampleMapper.deleteSample(sampleNo);
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
	
	// 5.
	public Sample loginSample(Sample sample) {
		System.out.println("SampleService.loginSample()호출");
		return sampleMapper.loginSample(sample);
	}
}
