package com.github.sashin92.myportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.sashin92.myportal.data.vo.BoardVO;
import com.github.sashin92.myportal.data.vo.FileVO;
import com.github.sashin92.myportal.data.vo.UserVO;
import com.github.sashin92.myportal.service.BoardService;
import com.github.sashin92.myportal.service.impl.FileUploadServiceImpl;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	private final BoardService boardService;
	private final FileUploadServiceImpl fileUploadService;
	
	@Autowired
	public BoardController(BoardService boardService, FileUploadServiceImpl fileUploadService) {
		this.boardService = boardService;
		this.fileUploadService = fileUploadService;
	}
	
	
	// 게시글 리스트
	@GetMapping({"", "/", "/list"})
	public String list(Model model) {
		
		
		model.addAttribute("boardList", boardService.getList());
		
		return "board/list";
	}
	
	// 글 내용
	@GetMapping("/view/{no}")
	public String view(@PathVariable("no") Integer no, 
			Model model,
			HttpSession session,
			RedirectAttributes redirectAttributes) {
		
		if (session.getAttribute("authUser") == null) {
			
			redirectAttributes.addFlashAttribute("errorMsg", "로그인 후 접근 가능합니다.");
			return "redirect:/board";
		}
		
		boardService.increasementHitCount(no);
		model.addAttribute("selectedBoard", boardService.getContent(no));
		FileVO fileVO = boardService.getFileRelatedByBoard(no);
		if (fileVO != null)
			model.addAttribute("boardFile", fileVO);
		
		return "board/view";
	}
	
	// 글 작성
	@GetMapping("/write")
	public String write(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		if (session.getAttribute("authUser") == null) {
			redirectAttributes.addFlashAttribute("errorMsg", "로그인 후 작성 가능합니다.");
			return "redirect:/board";
		}
		return "board/write";
	}	
	
	@PostMapping("/write")
	public String write(@ModelAttribute BoardVO boardVO, 
			@RequestParam("file1") MultipartFile file1,
			HttpSession session,
			RedirectAttributes redirectAttributes) {
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		if (authUser == null) {			
			redirectAttributes.addFlashAttribute("errorMsg", "로그인 후 작성 가능합니다.");
			return "redirect:/board";
		}
		
		boardVO.setUserNo(authUser.getNo().intValue());
		
		boardService.write(boardVO);
		System.out.println("no: " + boardVO.getNo());
		if (!file1.isEmpty())
			fileUploadService.uploadFile(file1, boardVO.getNo());
		return "redirect:/board/list";
	}
	
	// 글 수정
	@GetMapping("/modify/{no}")
	public String modify(@PathVariable("no") Integer no, 
			Model model, 
			HttpSession session,
			RedirectAttributes redirectAttributes) {
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		BoardVO boardVO = boardService.getContent(no);
		
		// TODO 작성자가 다를 때 처리
		if (authUser == null || boardVO.getUserNo() != authUser.getNo().intValue()) {
			redirectAttributes.addFlashAttribute("errorMsg", "작성자 본인만 수정 가능합니다.");
			return "redirect:/board/view/" + no;
		}
		model.addAttribute("boardVO", boardVO);
		return "board/modify";
	}
	
	@PostMapping("/modify")
	public String modify(@ModelAttribute BoardVO boardVO, 
			HttpSession session,
			RedirectAttributes redirectAttributes) {
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		if (authUser == null) {
			redirectAttributes.addFlashAttribute("errorMsg", "잘못된 접근입니다.");
			return "redirect:/board";
		}
		
		boardService.update(boardVO);
		return "redirect:/board/view/" + boardVO.getNo();
	}

	@GetMapping("/delete/{no}")
	public String delete(@PathVariable("no") Integer no, 
			HttpSession session,
			RedirectAttributes redirectAttributes) {
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		BoardVO boardVO = boardService.getContent(no);
		
		if (authUser == null || boardVO.getUserNo() != authUser.getNo().intValue()) {
			redirectAttributes.addFlashAttribute("errorMsg", "작성자 본인만 삭제 가능합니다.");
			return "redirect:/board";
		}
		
		boardService.delete(no, authUser.getNo().intValue());
		
		return "redirect:/board";
	}
	
}
