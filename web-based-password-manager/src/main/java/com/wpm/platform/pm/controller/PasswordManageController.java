package com.wpm.platform.pm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wpm.platform.pm.domain.PasswordManage;
import com.wpm.platform.pm.service.PasswordManageService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PasswordManageController {
	
	@Autowired
	PasswordManageService passwordManageService;
	
	@RequestMapping("/generate-password")
	public String redirectGeneratePassPage(Model model)
	{
		log.info("Clicked on the Password Generate Link");
		model.addAttribute("wpmBean",new PasswordManage());
		return "generatePassword";
	}

	@RequestMapping(value = "/passord-generated")
	public String generatePass(@ModelAttribute("wpmBean") PasswordManage passwordManage,Model model)
	{
		model.addAttribute("password",passwordManage.getPassword());
		passwordManageService.savePassword(passwordManage);
		log.info("PasswordManage Form Data : "+ passwordManage.toString());
		log.info("Model Data :"+ model.getAttribute("wpmBean").toString());
		log.info("I'm generated Pass API");
		return "generatePassword";
	}
	
}
