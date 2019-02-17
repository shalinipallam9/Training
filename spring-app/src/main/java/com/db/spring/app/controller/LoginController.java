package com.db.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(Model model) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("loginBean", new LoginBean());
		return mav;
	}
	@RequestMapping(value = "/procesLogin", method = RequestMethod.POST)
	public ModelAndView procesLogin(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {
		ModelAndView mav = null;
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) {
			if (loginBean.getUserName().equals("sri") && loginBean.getPassword().equals("sai")) {
				mav = new ModelAndView("redirect:/home");
				model.addAttribute("msg", " : " + loginBean.getUserName());
				return mav;
			} else {
				mav = new ModelAndView("login");
				model.addAttribute("msg", " : " + loginBean.getUserName());
				return mav;
			}
		} else {
			mav = new ModelAndView("login");
			model.addAttribute("msg", "Please enter Details");
			return mav;
		}
	}
}
