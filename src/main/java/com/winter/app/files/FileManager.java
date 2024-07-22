package com.winter.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	// HDD에 파일 저장
	// fileSave

	public String fileSave(String path, MultipartFile multipartFile) throws Exception {
		// 1. 저장폴더
		File file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
		}

		// 2. 파일 HDD에 저장
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + " " + multipartFile.getOriginalFilename();

		file = new File(file, fileName);
		multipartFile.transferTo(file);

		return fileName;

	}

}
