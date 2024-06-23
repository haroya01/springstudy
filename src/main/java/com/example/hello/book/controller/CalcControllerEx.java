package com.example.hello.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcControllerEx {

	@RequestMapping(value = "/calcControlEx", method = RequestMethod.GET)
	public String input() {
		return "calcForm2.html";
	}

	@RequestMapping(value = "/calcControlEx", method = RequestMethod.POST)
	public ModelAndView calc(@RequestParam("n1") int n1,
							 @RequestParam("n2") int n2,
							 @RequestParam("op") String op) {
		long result = 0;
		switch(op) {
			case "+": result = n1 + n2; break;
			case "-": result = n1 - n2; break;
			case "/": result = n1 / n2; break;
			case "*": result = n1 * n2; break;
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calcResult2.jsp");
		mav.addObject("result", result);
		return mav;
	}
}
