package com.group.mugspot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//cannot name this "controller"
public class MugController{
	
	 
	@RequestMapping("/shops")
	//need to add try catch for these exceptions - 
	public ModelAndView showMessage() throws ClientProtocolException, IOException, ParseException{
		
		//This array is populated with any data in the coffee shop DB, not specific to each coffee shop
		ArrayList<Map> info = DAO.getInfo();
		
		/*String name = info.get(0);
		String description = info.get(1);
		String menu = info.get(2);
		String outlets = info.get(3);
		String capacity = info.get(4);
		String tables = info.get(5);
		String phone = info.get(6);
		String address = info.get(7);*/
		
		ModelAndView mv = new ModelAndView("shops");
		mv.addObject("shop", info);
		
		/*mv.addObject("description", description);
		mv.addObject("menu", menu);
		mv.addObject("outlets", outlets);
		mv.addObject("capacity", capacity);
		mv.addObject("tables", tables);
		mv.addObject("phone", phone);
		mv.addObject("address", address);*/
		
		return mv;
	}

}
