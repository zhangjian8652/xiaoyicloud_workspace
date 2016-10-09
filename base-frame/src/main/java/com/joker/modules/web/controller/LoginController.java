package com.joker.modules.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping(value = "/login")
public class LoginController{
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String loginUI(ModelMap model) {
		model.addAttribute("message","Hello Wolrd!");
		return "login";
	}
	@RequestMapping(value = "",method = RequestMethod.POST)
	public void login(HttpServletRequest request,HttpServletResponse response,ModelAndView modelView,@ModelAttribute("form")Object o) {
		modelView.setViewName("");
		modelView.addObject("","");
		Charset s = StandardCharsets.UTF_8;

	}
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public void invite(HttpServletRequest request,HttpServletResponse response,ModelAndView modelView,@RequestParam String id) {


	}
}