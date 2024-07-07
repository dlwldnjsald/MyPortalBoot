package com.github.sashin92.myportal.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.sashin92.myportal.data.dao.BoardFilesBridgeDAO;
import com.github.sashin92.myportal.data.dao.FilesDAO;
import com.github.sashin92.myportal.data.vo.BoardFilesBridgeVO;
import com.github.sashin92.myportal.data.vo.FileVO;
import com.github.sashin92.myportal.service.FileUploadService;



@Service
public class FileUploadServiceImpl implements FileUploadService {
	@Autowired
	private FilesDAO filesDAO;
	@Autowired
	private BoardFilesBridgeDAO boardFilesBridgeDAO;
	
	@Value("${file.save.path}")
	private String SAVE_PATH;
	
	public String uploadFile(MultipartFile multipartFile) {
		String originalFileName = multipartFile.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
		String saveFileName = getSaveFilename(extName);
		
		try {
			writeFile(multipartFile, saveFileName);
			filesDAO.insert(new FileVO(saveFileName));
		} catch (IOException e) {
			System.err.println("파일을 쓰는 데 실패했습니다.");
		}
		return saveFileName;
	}
	
	public String uploadFile(MultipartFile multipartFile, Integer boardNo) {
		String originalFileName = multipartFile.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
		String saveFileName = getSaveFilename(extName);
		
		try {
			writeFile(multipartFile, saveFileName);
			filesDAO.insert(new FileVO(saveFileName));
			FileVO fileVO = filesDAO.selectOneByName(saveFileName);
			System.out.println(fileVO.getNo());
			boardFilesBridgeDAO.insert(new BoardFilesBridgeVO(boardNo, fileVO.getNo()));
		} catch (IOException e) {
			System.err.println("파일을 쓰는 데 실패했습니다.");
		}
		return saveFileName;
	}
		
	
	private void writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		byte[] fileData = multipartFile.getBytes();
		Path filePath = Paths.get(SAVE_PATH + "/" + saveFileName);
		Files.write(filePath, fileData);
		
		// This is a Unix, Linux or Mac system.
		String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            Set<PosixFilePermission> perms = new HashSet<>();
            perms.add(PosixFilePermission.OWNER_READ);
            perms.add(PosixFilePermission.OWNER_EXECUTE);
            perms.add(PosixFilePermission.GROUP_READ);
            perms.add(PosixFilePermission.GROUP_EXECUTE);
            perms.add(PosixFilePermission.OTHERS_READ);
            perms.add(PosixFilePermission.OTHERS_EXECUTE);
            
            Files.setPosixFilePermissions(filePath, perms);
        } 
	}
	
	private String getSaveFilename(String extName) {
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis()) + extName.toLowerCase();
		
	}
	
}
