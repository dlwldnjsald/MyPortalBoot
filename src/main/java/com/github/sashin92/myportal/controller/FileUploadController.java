package com.github.sashin92.myportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.sashin92.myportal.service.impl.FileUploadServiceImpl;


@RequestMapping("/fileupload")
@Controller
public class FileUploadController {	
	private FileUploadServiceImpl fileUploadService;
	
	@Autowired
	public FileUploadController(FileUploadServiceImpl fileUploadService) {
		this.fileUploadService = fileUploadService;
	}

	@GetMapping({"", "/", "/form"})
	public String formForwarding() {
		
		
		return "fileupload/form";
	}
	
	@GetMapping("/result")
	public String resultForwarding() {
		return "fileupload/result";
	}
	
	@PostMapping("/upload")
	public String uploadFileAction(@RequestParam("file1") MultipartFile file1, RedirectAttributes redirectAttributes) {
		if (file1.isEmpty()) {
			redirectAttributes.addFlashAttribute("errorMsg", "업로드할 파일을 선택해주세요.");
			return "redirect:/fileupload/form";
		}
		
		String result = fileUploadService.uploadFile(file1);
		redirectAttributes.addFlashAttribute("imageFileName", result);
		return "redirect:/fileupload/result";
	}
	
}
