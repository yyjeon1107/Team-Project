<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ADD</title>
<link rel="stylesheet" href="../../css/reset.css" />
<link rel="stylesheet" href="../../css/style.css" />
</head>
<body>
	<header class="header">
		<div class="inner">
			<h1>
				<a href="/">ADD</a>
			</h1>
		</div>
	</header>
	<main class="main">
		<div class="inner">
			<c:if test="${alert != null}">
				<p>${alert}</p>
			</c:if>
			<form class="add" method="post">
				<fieldset>
					<legend>상품이름</legend>
					<input name="name" type="text" />
				</fieldset>
				<fieldset>
					<legend>상품정보</legend>
					<textarea name="info" rows="10"></textarea>
				</fieldset>
				<fieldset>
					<button>등록</button>
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
