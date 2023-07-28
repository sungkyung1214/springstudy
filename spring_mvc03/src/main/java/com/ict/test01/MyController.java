package com.ict.test01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.MyService;
import com.ict.model.VO;

@Controller
public class MyController {
	
	@Autowired
	private MyService service;

	public MyService getSevice() {
		return service;
	}

	public void setSevice(MyService sevice) {
		this.service = sevice;
	}

	@GetMapping(value = "/")
	public ModelAndView exec01(HttpServletRequest request, HttpServletResponse response) {
	
		ModelAndView mv = new ModelAndView("test01/result");
		//String msg = "Hello World";
		//mv.addObject("msg", msg);
		
		//MyService service = new MyService();
		String msg = service.getGreeting();
		mv.addObject("msg", msg);
		
		return mv;
	}
	
	/*
	 * @PostMapping(value = "/calc.do") public ModelAndView
	 * exec02(HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * ModelAndView mv = new ModelAndView("test01/result2");
	 * 
	 * String s1 =request.getParameter("s1"); String s2 =request.getParameter("s2");
	 * String op =request.getParameter("op"); String cPage =
	 * request.getParameter("cPage"); String[] hobby =
	 * request.getParameterValues("hobby");
	 * 
	 * String str = service.getCalc(s1, s2, op);
	 *  mv.addObject("str", str);
	 * mv.addObject("s1", s1); 
	 * mv.addObject("s2", s2); 
	 * mv.addObject("op", op);
	 * mv.addObject("cPage", cPage); 
	 * mv.addObject("hobby", hobby);
	 * 
	 * return mv; }
	 */
	
	/*
	  @PostMapping(value = "/calc.do") 
	  // vo 변수이름과 파라미터이름이 같으면 자동으로 vo에 파라미터가 저장된다.
	  public ModelAndView exec02(VO vo) {
	  
	  ModelAndView mv = new ModelAndView("test01/result2");
	 
	  String str = service.getCalc(vo.getS1(),vo.getS2(), vo.getOp());
	  
	  mv.addObject("vo", vo); mv.addObject("str", str);
	  
	 
	  return mv; }
	 */
	
	@PostMapping(value = "/calc.do")
	// VO vo => 파라미터 받아서 vo에 저장
	// 그대로 model에 저장한다. vo라는 이름으로(@ModelAttribute("vo"))여기 vo에)
	// 모델에 저장하는 이유는 jsp에서 vo를 사용하기 위해서
	//이렇게 저장했기 때문에  mv.addObject("vo", vo); 사용 할 필요가 없어진다.
	
	public ModelAndView exec02(@ModelAttribute("vo")VO vo) {
									//얘는 파라미너가 뒤에 저장되어있고 그게 앞에  쌍따옴표 안에 들어와있음
		 ModelAndView mv = new ModelAndView("test01/result2");
		  
		 String str = service.getCalc(vo.getS1(),vo.getS2(), vo.getOp());
		 
		 //mv.addObject("vo", vo); 
		 mv.addObject("str", str);
		 
	
		return mv; 
		}
}
