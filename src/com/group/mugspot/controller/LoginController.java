package com.group.mugspot.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/submitLogin")
	public String submitLogin(@ModelAttribute("command") Users user, Model model,
			@CookieValue(value = "loggedIn", defaultValue = "false") String loggedIn, HttpServletResponse response) {

		if (DAO.checkLogin(user)) {
			Cookie cookie = new Cookie("loggedIn", "true");
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			model.addAttribute("cookie", cookie);

			return "memberArea";

		} else {
			if (DAO.containsUser(user))
				model.addAttribute("passError", "Password is incorrect.");
			else
				model.addAttribute("userError", "User doesn't exist.");

			return "login";
		}
	}
	//the "command" keyword is particular to spring, which populates the paramters based on an object bean
	@RequestMapping("/createLogin")
    public ModelAndView createLogin() {
        return new ModelAndView("adminLogin", "command", new Users());
    }

}