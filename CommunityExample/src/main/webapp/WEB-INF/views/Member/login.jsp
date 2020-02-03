<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>


<head>
<!-- cdn -->
<meta charset="UTF-8" name="viewport" content="initial-scale=1, width=device-width" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://kit.fontawesome.com/b7a5a95aa6.js" crossorigin="anonymous"></script>

<!-- resources path -->
<spring:url value="/resources" var="resourcesPath" />
<spring:url value="/resources/css" var="cssPath" />
<spring:url value="/resources/js" var="jsPath" />
<spring:url value="/resources/icon" var="iconPath" />
<spring:url value="/resources/img" var="imgPath" />
<spring:url value="/resources/color" var="colorPath" />

<!-- title -->
<link rel="shortcut icon" href="${iconPath}/favicon.png">
<title>로그인 - CommunityExample</title>
</head>


<body>
	<div class="container col-xl-3 col-md-6 justify-content-center text-center">
		<div class="ce_logo my-5 py-5">
			<a href="/communityexample"><img src="${iconPath}/communityexample-logo-black.png" width="300" height="75"></a>
		</div>
		<div class="ce_form pb-5 mb-5">
			<form action="login" method="post">
				<div class="form-group">
					<input type="text" placeholder="ID" class="form-control" name="mId"><input type="password" placeholder="PASSWORD" class="form-control" name="mPassword">
				</div>
				<button class="btn btn-block btn-info">로그인</button>
				<div class="form-check mt-1">
					<input class="form-check-input" type="checkbox" name="checkCookie" value="yes" id="defaultCheck1"> <label class="form-check-label mr-sm-4 pr-sm-4 text-left" for="defaultCheck1">아이디 저장</label> <a href="/communityexample/find_account" class="ml-sm-3 pl-sm-3 text-right">계정찾기</a> | <a href="/communityexample/join">회원가입</a>
				</div>
			</form>
		</div>
		<div class="ce_snslogin mb-5">
			<img class="mb-1" src="${imgPath}/naver.PNG" height="50" width="200"> <img src="${imgPath}/google.png" height="50" width="200">
		</div>
		<div class="ce_join mb-5">
			아직 회원이 아니시라면? <a href="/communityexample/join">회원가입</a>
		</div>
		<div class="ce_footer">this is footer</div>
	</div>
</body>


</html>