<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>LOGIN</title>
<link rel="stylesheet" href="../../css/reset.css" />
<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<header class="header">
		<div class="inner">
			<h1>
				<a href="/">LOGIN</a>
			</h1>
		</div>
	</header>
	<main class="main">
		<div class="inner">
			<c:if test="${fail != null}">
				<p>${fail}</p>
			</c:if>
			<form class="login" method="post">
				<fieldset>
					<legend>아이디</legend>
					<input name="id" type="text" />
				</fieldset>
				<fieldset>
					<legend>비밀번호</legend>
					<input name="password" type="password" />
				</fieldset>
				<fieldset>
					<button>로그인</button>
					<a href="/join">회원가입</a>
				</fieldset>
			</form>
		</div>
	</main>
	<footer class="footer">
		<div class="inner">
			<address>590824@naver.com</address>
		</div>
	</footer>
</body>
</html>
