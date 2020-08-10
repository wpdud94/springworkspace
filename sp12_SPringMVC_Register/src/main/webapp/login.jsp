<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#id').keyup(function(){
		var id = $(this).val();
		if(id.length>0){
			$('#resultView').html(' ');
			/* $.ajax({
				type:'post',
				url:'idCheck.do',
				data:'id='+id,
				
				success: function(result) {
					if(result==true){
						$('#resultView').html()
					}else{
						
					}
				}//success
			});//ajax */
		}
	});//keyup
});//ready-on
</script>
<body>
<!-- login_action에 있는 로직이 이제 LoginServlet으로 이동.. 
	 로그인 성공--login_ok.jsp로 이동
	 로그인 실패--login_fail.jsp로 이동
-->
<form action="login.do" name="loginForm" >
	아이디 : <input type="text" id="id" name="id" required="required"> &nbsp; 
	<span id="resultView">Id를 입력해주세요</span> <br>
	패스워드 : <input type="password" name="password" required="required"><br>
	<input type="submit" value="전송">
</form>
</body>
</html>











