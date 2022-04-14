<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>PRODUCT DETAIL</title>
<link rel="stylesheet" href="../../css/reset.css" />
<link rel="stylesheet" href="../../css/style.css" />
<script src="../../js/index.js" defer></script>
</head>
<body>
	<header class="header">
		<div class="inner">
			<h1>
				<a href="/">PRODUCT DETAIL</a>
			</h1>
		</div>
	</header>
	<main class="main">
		<div class="inner">
			<h2>등록번호: ${product.getId()}</h2>
			<hr />
			<h3>등록유저이름 : ${product.getUserId()}</h3>
			<hr />
			<h3>제품이름 : ${product.getName()}</h3>
			<br />
			<h3>제품정보 : ${product.getInfo()}</h3>
		</div>
	</main>
	<footer class="footer">
		<div class="inner">
			<address>590824@naver.com</address>
		</div>
	</footer>
</body>
</html>
