package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.View;

/**
 * @author Shivani
 *
 */
@Controller
public class WebController {

	@Autowired
	View v;

	@RequestMapping(value = "/login")

	public String sayHello(ModelMap model) {
		v.create();
		v.insert();
		v.updatecount();
		model.addAttribute("count", v.getcount());

		// int count=v.getcount();
		return "index";
	}
}
