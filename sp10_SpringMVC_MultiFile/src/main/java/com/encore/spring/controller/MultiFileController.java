package com.encore.spring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.MultiFileVO;

@Controller
public class MultiFileController {
	
	@RequestMapping("multiupload.do")
	public ModelAndView multiUpload(HttpServletRequest request, MultiFileVO vo) throws Exception{
		/*
		1. Upload된 파이를 받아온다
		2. Upload할 경로를 지칭하고 해당경로에 파일의 복사본을 이동시킨다
		3. 업로드한 파일명(3개)이 출력되도록 결과페이지를 지정한다
			결과페이지명 : multi_upload_result.jsp
		 */
		
		//1.
		List<MultipartFile> files = vo.getFile();
		String[] nameList = new String[3];
		int idx=0;
		//2.
		for(MultipartFile mf : files) {
			String root = request.getSession().getServletContext().getRealPath("/");
			String path = root+"\\upload2\\";
			File copyFile = new File(path+mf.getOriginalFilename());
			mf.transferTo(copyFile);
			nameList[idx++] =  mf.getOriginalFilename();
		}
		
		
		return new ModelAndView("multi_upload_result","nameList",nameList);
	}
	
	@RequestMapping("downloadFile.do")
	public ModelAndView downloadFile(HttpServletRequest request, String filename) {
		System.out.println("filename : "+filename);
		HashMap map = new HashMap();
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload2\\";
		map.put("path",path);
		return new ModelAndView("downloadView",map);
	}
}
