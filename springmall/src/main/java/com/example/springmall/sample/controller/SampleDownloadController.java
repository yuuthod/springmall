package com.example.springmall.sample.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class SampleDownloadController {
	@RequestMapping("/file/{fileName:.+}")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName) throws IOException {
		System.out.println("SampleDownloadController.downloadPDFResource()호출");
		
		//파일이름이 한글일때 호환
		//fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		
		// 파일읍 업로드 할때와 동일하게 realpath로 상대경로 지정		
		String folder = "realPath/uploads/";
		String path = request.getSession().getServletContext().getRealPath(folder);
		System.out.println("상대경로 : " + path);
		
		// (상대경로 + 파일이름)전체경로에 해당하는 파일을 생성한다.
		File file = new File(path + fileName);
		//exists()로 파일의 존재 여부를 리턴한다.
		if (file.exists()) {

			//true가 나오면 마임타입을 가지고 온다.
			//마임타입을 가지고 오는 방법은 다양하다.
			
			/* + Using Java 7
			 * Path b = new File(path).toPath();
			 * String a = Files.probeContentType(b);
			 * 
			 * + Apache Tika
			 * PDF파일을 지원해서 많이 사용한다.
			 * 
			 * ++확장명과 mime타입은 다르다.
			 * 예를들어 text파일의 확장명을 jpg로 변경했다 해도 mime타입은 text로 나온다.
			 */
			
			// URLConnection에서 제공하는 API사용
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			System.out.println("mimeType : " + mimeType);
			if (mimeType == null) {
				//unknown mimetype so set the mimetype to application/octet-stream
				//mimetype을 찾지 못한다면
				//application/octet-stream로 설정해줍니다.
				//이진 파일을 위한 기본값, 실제로 잘 알려지지 않은 이진 파일을 의미
				mimeType = "application/octet-stream";
			}
			// 응답할때 타입을 구해놓은 mimetype으로 셋팅해준다.
			response.setContentType(mimeType);
			
			// String.format : 사용자 지정 숫자 형식 문자열
			// String 문자열을 배열로 만들어 위치나 순서를 정할 수 있다.
			
			//Content-Disposition 헤더에 파일 이름 세팅.
			/*
			1) "Content-disposition: attachment"
				브라우저 인식 파일확장자를 포함하여 모든 확장자의 파일들에 대해, 다운로드시 무조건 "파일 다운로드" 대화상자가 뜨도록 하는 헤더속성이다.
				즉 모든 파일이 무조건 다운로드 된다.
				
			2) "Content-disposition: inline"
				브라우저 인식 파일확장자를 가진 파일들에 대해서는 웹브라우저 상에서 바로 파일을 열고, 그외의 파일들에 대해서는 "파일 다운로드" 대화상자가 뜨도록 하는 헤더속성이다.
				브라우저에서 직접 열 수 있는건 열고, 열 수 없는것들만 다운로드 받을 수 있다.
				
				*브라우져의 버젼에 따라 attachment속성이 inline속성과 동일하게 작동할 수도 있다.
			*/
			//attachment
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
			
			//inline
			//response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
			
			//파일크기를 알기위해 셋팅
			//응답의 크기(바이트개수)를 의미
			response.setContentLength((int) file.length());
			System.out.println("response.setContentLength : "+request.getContentLength());
			
			
			/* IO(입출력)을 사용할때
			 * FileInputStream만으로도 충분히 파일을 다운받을 수 있다.
			 * FileInputStream은 데이터를 한줄씩 한줄씨 보냄으로 파일이 무거워질수록 속도가 느려진다.
			 * 
			 * 때문에 BufferedInputStream을 같이 사용해준다.
			 * BufferedInputStream은 데이터를 모두 받기를 기다렸다가 한번에 보내주는 기능으로
			 * 직접적인 처리는 못하지만 IO의 성능(속도)을 향상시켜주는(오버헤드를 줄여주는) 역할을 해준다.
			 * 
			 * + 테스트 결과 : 파일이 가벼울땐 오히려 BufferedInputStream을 사용한코드가 느렸지만,
			 * + 파일이 무거워질수록 BufferedInputStream이 훨씬 빠르다는것을 알 수 있었다.
			 */
			
			//BufferedInputStream 성능테스트 
			//long start = System.currentTimeMillis();
			//long end = System.currentTimeMillis();
			//System.out.println("성능테스트 시간 : "+(end-start));
			//System.out.println("end : "+end+" /  start : "+start);
			
			//InputStream inputStream = new FileInputStream(file);
			
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			
			System.out.println("inputStream : " + inputStream);
			
			//스프링프레임워크 유틸 패키지에 존재하는 FileCopyUtils클래스
			// FileCopyUtils : 파일 및 스트림 복사를 위한 간단한 유틸리티 메소드의 집합체
			FileCopyUtils.copy(inputStream, response.getOutputStream());
			
		}
	}
}
