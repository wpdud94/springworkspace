package com.encore.spring.contorller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.UploadDataVO;

@Controller
public class FileController {
	
	@RequestMapping("fileUpload.do")
	public ModelAndView fileUpload(
			HttpServletRequest request,HttpServletResponse response, UploadDataVO vo
			) 
	throws Exception {
		//1. vo에서 Multipartfile을 꺼낸다
		/*
		자동으로 vo에 매핑해준다
		 */
		MultipartFile mFile =vo.getUploadFile();
		
		System.out.println("MultipartFile : "+mFile);
		
		/*
		2. 	
			업로드된 파일이 있다면,
			 파일의 사이즈
			 업로드한 파일 이름
			 업로드한 파일의 parameter명
			 --> 파일을 서버에 올리고 싶다
			
			업로드된 파일이 없다면
			 skip
		 */
		if(!mFile.isEmpty()) {//업로드된 파일이 있다면
			// 알아야될 함수들
			System.out.println("1. MultipartFile Size : "+mFile.getSize());
			System.out.println("2. MultipartFile ParamName : "+mFile.getName());
			System.out.println("3. MultipartFile FileName : "+mFile.getOriginalFilename());
		}
		/*
		3. 복사본을 서버에 올려야 한다
		원본이 삭제되므로
		3-1. File 이동 : transferTo(원본 File)
		
		4. 경로
		실질 경로 : TomCat Home>webapps>Context Path(Spring(주소창), sp09(홈에서)>여기!!
		--> getRealPath()
		이클립스경로 : src>main>webapp>여기!!
		WEB-INF : 동적인 문서가 들어가는 곳
		
		5. HttpServletSession vs HttpServletRequest
		후자를 쓰면 전자도 가능하다
		 */
		String root = request.getSession().getServletContext().getRealPath("/");
		//C:\kjy\apache-tomcat-8.5.55\webapps\sp09_FileUpload
		String path = root + "\\upload\\";
		/*
		OS 별로 Separate 표시가 다름 --> Separate 기능 쓰기
		 */
		
		// File = 디렉토리 + 파일명
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile);//File 이동
		
		System.out.println("path : "+path);
		
		return new ModelAndView("upload_result", "uploadfile", mFile.getOriginalFilename());
	}
	
	//Download
	@RequestMapping("fileDown.do")
	public ModelAndView fileDown(HttpServletRequest request, String filename) throws IOException, Exception{
		/*
		1. 인자값에 바인딩을 하면 request.getParam이 자동으로 매핑됨
		 */
		System.out.println("Downliad ====================================");
		System.out.println("filename : "+filename);
		
		// 2. 업로드 경로를 받아오기
		String root = request.getSession().getServletContext().getRealPath("/");
		//C:\kjy\apache-tomcat-8.5.55\webapps\sp09_FileUpload
		String path = root + "\\upload\\";
		
		HashMap map = new HashMap();
		map.put("path", path);  //upload한 파일을특정한 경로에 이동... 나머지는 DownloadView가 함
		
		return new ModelAndView("downloadView", map);
	}
}
