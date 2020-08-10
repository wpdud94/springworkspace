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
다수 파일 올리기
::
1) file로만 하면 구분이 안 된다
2) 배열로 구분해야 한다

 -->
<h2 align="center">MultiFile Upload Test</h2><p/>
<form action="multiupload.do" method="post" enctype="multipart/form-data">
	사용자명 : <input type="text" name="userName"><p/>
	파일 업로드 1 : <input type="file" name="file[0]"><p/>
	파일 업로드 2 : <input type="file" name="file[1]"><p/>
	파일 업로드 3 : <input type="file" name="file[2]"><p/>
	
	<input type="submit" value="멀티파일전송">
</form>
</body>
</html>