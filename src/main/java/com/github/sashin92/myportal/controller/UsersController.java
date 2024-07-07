package com.github.sashin92.myportal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.sashin92.myportal.data.vo.UserVO;
import com.github.sashin92.myportal.exception.UserDAOException;
import com.github.sashin92.myportal.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	private final UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute UserVO userVO) {
		userVO.setGender("M");
        return "/users/joinform";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute @Valid UserVO userVO,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			Model model) {
		if (result.hasErrors()) {
			List<ObjectError> lst = result.getAllErrors();
			for(ObjectError node: lst)
				System.out.println(node);
			model.addAllAttributes(result.getModel());
			return "users/joinform";
		}
		try {
			if ("".equals(userVO.getName()) || "".equals(userVO.getEmail()))
				throw new UserDAOException();
			userService.signUp(userVO);
			return "redirect:/users/joinsuccess";
		} catch (UserDAOException e){
			redirectAttributes.addFlashAttribute("errorMsg", "양식이 올바르지 않거나 이미 존재합니다.");
			return "redirect:/users/join";
		}
	}

	@GetMapping("/joinsuccess")
	public String joinsuccess() {
		return "users/joinsuccess";
	}
	
	@GetMapping({"", "/", "/login"})
	public String loginform() {	
		return "users/loginform";
	}
	
	@PostMapping("/login")
	public String loginform(@RequestParam(name = "email", required = false, defaultValue = "") String email, 
			@RequestParam(name = "password", required = false, defaultValue = "") String password, 
			HttpServletRequest request,
			RedirectAttributes redirectAttributes){
		
		UserVO authUser = userService.getUser(email, password);
		if (authUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else {
			redirectAttributes.addFlashAttribute("errorMsg", "로그인에 실패했습니다.");
			return "redirect:/users/login";
		}
	}
	
	@GetMapping("/logout")
	public String logoutform(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/checkEmail")
	public Map<String, Object> checkEmail(@RequestParam(name = "email", required = true, defaultValue = "") String email) {
		
		UserVO userVO = userService.getUser(email);
		Map<String, Object> json = new HashMap<>();
		boolean isExist = userVO != null ? true : false;
		json.put("result", "success");
		json.put("exist", isExist);
		
		return json;
	}
	
}
