package com.ed.cnm.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public boolean delete(String name, String fileName, HttpSession session) throws Exception {
		// 1. 경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		File file = new File(path, fileName);		// 경로를 따라서 파일지정
		
		boolean check = false;
		
		if(file.exists()) {
			check = file.delete();
		}
		
		return check;
	}

	public String save(String name, MultipartFile multipartFile, HttpSession session) throws Exception {
		// 1. 경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		System.out.println(path);

		// 실제 경로에 폴더가 없으면 파일 저장시 에러 발생
		File file = new File(path);			// 경로명을 담고 있음
		System.out.println(file.exists());

		if(!file.exists()) {
			file.mkdirs();
		}

		// 2. 저장할 파일명
		String fileName = "";
		
		// UUID
		fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
		
		// 3. HDD에 저장
		file = new File(file, fileName);
		
		// transfer to
		multipartFile.transferTo(file);		// multipartFile에 있는 2진데이터를 파일경로에 저장

		return fileName;
	}

	public File makePath(HttpSession session) throws Exception {
		// 1. 저장할 폴더 지정 resources/upload/member (프로젝트내에서 사용하는 경로)
		// 2. os 에서 인식 할 수 있는 실제 경로 찾기
		// jsp : application - server : ServletContext
		String path = session.getServletContext().getRealPath("resources/upload/member");
		System.out.println(path);

		// 3. 실제 경로에 폴더가 없으면 파일 저장시 에러 발생
		File file = new File(path);			// 경로명을 담고 있음
		System.out.println(file.exists());

		if(!file.exists()) {
			file.mkdirs();
		}

		return file;
	}

	// 4. 저장할 파일명 생성
	public String makeTimeFileName() throws Exception {
		// 1) 시간
		Calendar cal = Calendar.getInstance();
		long time = cal.getTimeInMillis();

		return String.valueOf(time);
	}

	public String makeUUIDFileName() throws Exception {
		// 2) UUID
		return UUID.randomUUID().toString();
	}

	public void saveUseCopy(MultipartFile multipartFile, File file) throws Exception {
		FileCopyUtils.copy(multipartFile.getBytes(), file);
	}

	public void saveUseTransfer(MultipartFile multipartFile, File file) throws Exception {
		multipartFile.transferTo(file);
	}
}
