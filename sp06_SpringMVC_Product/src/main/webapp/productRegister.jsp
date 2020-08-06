<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Product Register Form</h2>
<form action="myProduct.do" method="post">
	상품명 : <input type="text" name="name"><p/>
	제조사 : <input type="text" name="maker"><p/>
	가 격 : <input type="text" name="price"><p/>
	<input type="submit" value="상품등록"><p/>
</form>
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
<br>
<form action="mySearch.do" method="post">
	상품명 검색 <input type="text" name="word"><p/>
	<input type="submit" value="상품찾기">
</form>
</body>
</html>