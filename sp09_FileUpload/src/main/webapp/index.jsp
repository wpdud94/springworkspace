<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
	파일 업로드 폼 작성시 주의 사항!
	1) Form tag를 이용하자..... a태그는 사용못함.
		(a태그를 사용하게 되면 경로가 href에 들어가게 된다.)
	2) 전송 방식은 반드시 post로 사용되어야 한다. 단순한 String값을 넘기는 것이 아닌  MultipartFile 객체를 넘기는 것이기 때문이다.
		그렇기 때문에 get방식으로 전송하지 못한다.
		MultipartFile이란? 파일선택을 눌러 선택창이 뜨고 선택을 완료하면 파일의 정보와 파일내용이 담기는데 이부분이 multipartFile이라고 할 수 있다.
							용량, 사이즈, 이름, 확장자 등등을 가지고 있다.
							사용자 명도 또한 같이 서버로 전달 된다.(MultipartFile정보 + 사용자 정보)
							그렇기 때문에 vo생성이 필요하다.
	3) form의 속성으로 action, method 말고도 enctype="multipart/form-data" 이 부분을 반드시 추가해야한다.
	4) multipartFile -- 파일업로드 핵심 라이브러리... 이걸 빈설정문서에 등록한다.
 -->
<h2 align="center">Single Upload Test... </h2>
<form action="fileUpload.do" method="post" enctype="multipart/form-data">
사용자명 :: <input type="text" name="userName"><p>
<input type="file" name="uploadFile"><p>
<input type="submit" value="파일 업로드">
</form>

<!-- <h2 align="center">Single File Upload Test</h2>
	<form action="fileUpload.do" method="post" enctype="multipart/form-data">
		사용자 명 : <input type="text" name="userName"><p>
		<input type="file" name="uploadFile"><p>
		<input type="submit" value="파일업로드">
	</form> -->
<!--
	보통은 여기까지 작성한 다음에 바로 Controller 작성으로 넘어가는게 일반적이다.
	하지만 파일업로드 로직은 Controller 작성으로 넘어가기 전에 VO작성을 먼저하고 넘어간다.
	
	파일업로드하는데 VO가 필요한 이유는?
		vo가 뭔지 정확한 이해가 필요하다.
 -->

</body>
</html>