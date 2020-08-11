<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	.can{
		color:blue;
	}
	
	.cant{
		color:red;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#id').keyup(function(){
		var id = $(this).val();
			$.ajax({
				type:'post',
				url:'idCheck.do',
				data:'id='+id,
				
				success: function(responseData) {
					var jsonData = JSON.parse(responseData);
					if(jsonData==false){
						$('#resultView').html('사용가능한 ID입니다.').addClass('can');
					}else{
						$('#resultView').html('사용할 수 없는 ID입니다.').addClass('cant');
					}
				}//success
			});//ajax
	});//keyup
});//ready
</script>
</head>
<body>
<h3>회원가입</h3>
<!-- register_action에서 하고있는 기능이  RegisterServletd으로 이동
	 register_result.jsp로 결과를 보낸다.
-->
<form action="register.do" name="registerForm" >
ID : <input type="text" name="id" id="id" required="required">&nbsp; 
<span id="resultView">Id를 입력해주세요</span> <br><br>
PASSWORD : <input type="password" name="password" required="required"><br><br>
NAME : <input type="text" name="name" required="required"><br><br>
ADDRESS : <input type="text" name="address" required="required"><br><br>

<input type="submit" value="member register">
	</form>
</body>
</html>























