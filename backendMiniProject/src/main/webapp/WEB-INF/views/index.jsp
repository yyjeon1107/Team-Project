<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>INDEX</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/reset.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
	<header class="header">
		<div class="inner">
			<h1><a href="/">INDEX</a></h1>
			<nav>
				<ul>
					<c:if test="${user == null}">
						<li><a href="/login">로그인</a></li>
						<li><a href="/join">회원가입</a></li>
					</c:if>
					<c:if test="${user != null}">
						<li><a href="/info/${user.getId()}">정보</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</header>
	<main class="main">
		<div class="inner">
			<ul class="products">

				<c:forEach var="product" items="${products}" varStatus="status">
					<li>
						<a href="/product/${product.getId()}">
							<span>${status.count}</span>
							<span class="Contents">${product.getName()}</span>
							<span>${product.getUserId()}</span>
						</a>
					</li>

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
