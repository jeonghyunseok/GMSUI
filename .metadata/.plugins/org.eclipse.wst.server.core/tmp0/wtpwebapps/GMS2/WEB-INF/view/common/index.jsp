<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>Student detail</title>
<link rel="stylesheet" href="${css}member.css" />
</head>
<body>
	<div id="wrapper">
		<header>
			<h1 id="title">학생 관리 </h1>
		</header>
	<a id="go_main" href="${ctx}/index.jsp">메인으로 가기</a><br />
		
		<div id="container">
	
		<div id="text-cen">
		<form id="Login-box" name="Login-box" method="get">
			<img id="login_img" src="${img}꽃.jpg" alt=""/><br />
			<span id="login_id">ID</span>
			<input type="text" id="input_id" name="id" placeholder="아이디" /><br />
			
			<mark>ID는 숫자 포함 8자리 이내</mark><br />
			
			<span id="login_pass">PASSWORD</span>
			<input name="password" id="input_pass"	type="password" placeholder="비밀번호" /><br />
			<input type="submit" value="login" onclick="loginAlert()" />	
			<input type="reset" value="cancel" />	
			<input type="hidden" name="action" value="login" />
			<input type="hidden" name="page" value="main" />
		
		</form>
		</div>
		</div>
			
	<footer>
		<div>
				<p>Posted by: Hanbit</p>
				<p>
					Contact information: <a href="mailto:someone@example.com">
						hanbit@example.com</a>.
				<a href="jdbctest.jsp">DB 연결테스트</a>
				<a href="../util/update_email.jsp">email 업데이트</a>
				</p>
	</div>
		</footer>
			</div>
			<script>
			
			function loginAlert(){
				var input_id = document.getElementById("input_id").value;	
				var input_pass = document.getElementById("input_pass").value;	
				if(input_id===""){
					alert('ID를 입력해 주세요');
					return false;
				}
				if(input_pass===""){
					alert('PASSWORD를 입력해 주세요');
					return false;
				}
				var form=document.getElementById("Login-box");
				form.action="${ctx}/common.do";
				form.method="post"
				return true;
			}		
				
			</script>
			</body>
			</html>
