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
			// System.out.println 처럼 console에 문자열을 출력하는 코드인데, 위치나 순서를 정할 수 있다.
			
			//파일 뷰 기능
			//response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

			//파일 다운로드 기능
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());

		}
	}
}
