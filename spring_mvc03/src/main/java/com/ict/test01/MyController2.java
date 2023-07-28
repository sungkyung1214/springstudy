package com.ict.test01;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MyController2 {

	
	// 파일 업로드는 post 방식이어야 하고
	// pom.xml에 cos 라이브러리를 넣어줘야 한다.
	@PostMapping(value = "/f_up.do")
	public ModelAndView getFileUp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("test01/result3");
		String path = request.getSession().getServletContext().getRealPath("/resources/images");
		try {
			MultipartRequest mr=
					new MultipartRequest(request, path, 500*1024*1024, 
							"utf-8", new DefaultFileRenamePolicy());
			String name = mr.getParameter("name");
			String f_name = mr.getOriginalFileName("f_name"); //올릴때 당시 이름
			String f_name2 = mr.getFilesystemName("f_name"); // 저장할때 당시 이름
			String file_type = mr.getContentType("f_name");
			
			File file = mr.getFile("f_name");
			long size = file.length()/1024; // 1024로 나누면 kb 가 된다.
			SimpleDateFormat day = new SimpleDateFormat("yy.MM.dd hh:mm:ss E");
			String lastday = day.format(file.lastModified());
			
			mv.addObject("name", name);
			mv.addObject("f_name", f_name);
			mv.addObject("f_name2", f_name2);
			mv.addObject("file_type", file_type);
			mv.addObject("size", size);
			mv.addObject("lastday", lastday);
			return mv;	
			
		} catch (Exception e) {
			
		}
		
		return null;
	}
	
	// spring에서 지원하는 파일 업로드
	// servlet-context.xml에 파일 업로드용 클래스 등록
	// 업로드시 파일용량 제한 설정
	// 업로드할 할 때의 이름만 기억 
	// @RequestParam => 파라미터를 받을 때 사용할 수 있다.
	@PostMapping(value = "/f_up2.do")
	public ModelAndView getFileUp2(
			@RequestParam("f_name") MultipartFile file,
			@RequestParam("name") String name,
			//리퀘ㅐ스트파라티머에서 저장된것을 뒤에 저장
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv= new ModelAndView("test01/result4");
		String path = request.getSession().getServletContext().getRealPath("/resources/images");
		try {
			// 같은 이름이 존재하면 안됨(나중에는 파일이름 검사 후 같은 이름 있으면 변경
			//이거 쓰기 싫으면 cos라이브러리 사용하면 됨
			String f_name = file.getOriginalFilename();
			String f_type= file.getContentType();
			long size = file.getSize()/1024;
			
			// 실제 이미지를 올리는 작업
			byte[] in = file.getBytes();
			
			// 올릴 장소와 이름 저장
			File out = new File(path,f_name);
			
			// 파일 복사(upload)
			FileCopyUtils.copy(in, out);
			
			mv.addObject("name", name);
			mv.addObject("f_name", f_name);
			mv.addObject("f_type", f_type);
			mv.addObject("size", size);
			
			return mv;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
		
	}
	
}
