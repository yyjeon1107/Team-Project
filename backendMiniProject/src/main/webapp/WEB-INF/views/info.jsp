<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>INFO</title>
<link rel="stylesheet" href="../../css/reset.css" />
<link rel="stylesheet" href="../../css/style.css" />
<script src="../../js/index.js" defer></script>
</head>
<body>
	<header class="header">
		<div class="inner">
			<h1>
				<a href="/">${user.getName()}</a>
			</h1>
			<nav>
				<ul>
					<li><a href="/product/${user.getId()}/add">물건등록</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<main class="main">
		<div class="inner">
			<h2>Email: ${user.getEmail()}</h2>
			<hr />
			<h3>Address : ${user.getAddress()}</h3>
			<hr />
			<br /> <br />
			<h4>등록한 물품</h4>
			<hr />
			<ul class="products">
				<c:forEach var="product" items="${products}" varStatus="status">
					<li><a href="/product/${product.getId()}"> <span>${status.count}</span>
							<span class="Contents">${product.getName()}</span>
					</a></li>
				</c:forEach>
			</ul>
		</div>
	</main>
	<footer class="footer">
		<div class="inner">
			<address>590824@naver.com</address>
		</div>
	</footer>
</body>
</html>
