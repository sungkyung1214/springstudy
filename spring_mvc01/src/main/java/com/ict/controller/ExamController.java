package com.ict.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ExamController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("result");
		
		// 배열일 경우 배열도 가능하다~라는것을 보여주는 예시
		String[] dogName = {"초복이","중복이", "말복이", "바둑이"};
		mv.addObject("dogName", dogName);
		
		//db갔다오면 보통 리스트,근데 배열이니까 arraylist
		List<String> list = new ArrayList<String>();
		list.add("해리포터");
		list.add("헤르미온느");
		list.add("론");
		list.add("덤블도어");
		mv.addObject("list", list);
		
		return mv;
	}
}
