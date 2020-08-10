<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function downloadFile(filename){
		if(confirm("파일을 다운로드 하시겠습니까?")){
			location.href="downloadFile.do?filename="+filename;
		}
	}
</script>
<body>
<%-- <c:forEach items="${mlist}" var="file">
	${file.getOriginalFilename()}
</c:forEach> --%>
<ul>
<c:forEach items="${nameList}" var ="name">
	<li>${name}</li><a href="javascript:downloadFile(${name})">${name}</a>
</c:forEach>
</ul>
</body>
</html>