<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>

<head>
	<!-- resources path -->
	<spring:url value="/resources" var="resourcesPath" />
	<spring:url value="/resources/css" var="cssPath" />
	<spring:url value="/resources/js" var="jsPath" />
	<spring:url value="/resources/icon" var="iconPath" />
	<spring:url value="/resources/img" var="imgPath" />
	<spring:url value="/resources/color" var="colorPath" />
	
	<!-- cdn -->
	<meta charset="UTF-8" name="viewport"
		content="initial-scale=1, width=device-width" />
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="${jsPath}/bootstrap.bundle.min.js"></script>
	<script src="${jsPath}/bootstrap.bundle.min.js.map"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/b7a5a95aa6.js"
		crossorigin="anonymous"></script>
		<script src="${jsPath}/ce.script.js"></script>
	
	<!-- title -->
	<link rel="shortcut icon" href="${iconPath}/favicon.png">
	<title>${title} - CommunityExample</title>
</head>

<body>
	<div class="container-fluid bg-light">
		<div class="header row col-xs-12">
			<nav
				class="navbar navbar-expand-lg navbar-dark bg-dark col-xl-12 px-5">

				<div class="ce_logo ml-xl-5 pl-xl-5">
					<a class="navbar-brand" href="/communityexample/test"> <img
						src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png"
						width="30" height="30" class="d-inline-block align-top" alt="">
						Bootstrap
					</a>
				</div>

				<div class="ce_button">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				</div>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link" href="#">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Dropdown </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="#">Action</a> <a
									class="dropdown-item" href="#">Another action</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Something else here</a>
							</div></li>
						<li class="nav-item"><a class="nav-link disabled" href="#"
							tabindex="-1" aria-disabled="true">Disabled</a></li>
					</ul>

					<div class="ce_search">
						<form class="form-inline my-2 my-lg-0">
							<input class="form-control mr-sm-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="submit">Search</button>
						</form>
					</div>

					<div class="ce_info pr-xl-5 mr-xl-5">
						<c:choose>
							<c:when test="${memberDTO.mId eq null}">
								<a class="navbar-brand ml-lg-3 ml-xl-5  mr-1" href="#"> <img
									class="rounded-circle"
									src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png"
									width="30" height="30"> <span class="lead text-white">nickname</span>
								</a>
								<a class="far fa-envelope fa-lg text-light mx-1" href=""></a>
								<a class="fas fa-shopping-cart fa-lg text-light mx-1" href=""></a>
							</c:when>
							<c:otherwise>
								<a class="navbar-brand ml-lg-3 ml-xl-5  mr-1 lead text-white"
									href="#"> <span class="lead text-white">Log in</span> <i
									class="fas fa-sign-in-alt text-success fa-lg mx-1" href=""></i>
								</a>
							</c:otherwise>
						</c:choose>
					</div>

				</div>
			</nav>
		</div>
		<!-- end of header -->