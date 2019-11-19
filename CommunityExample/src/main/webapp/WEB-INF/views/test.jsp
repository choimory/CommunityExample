<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
	
		<head>
			<meta charset="UTF-8" name="viewport" content="initial-scale=1, width=device-width"/>
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> 	
			
			<title>this is test</title>
		</head>
	
		<body>
			<div class="wrap">
				<header>
					<div class="logo"></div>
					<div class="nav">
						<nav class="navbar navbar-expand-xl navbar-dark bg-dark">
						  <a class="navbar-brand" href="#">
						  	<img src="data:image/png;base64,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" width="30" height="30" class="d-inline-block align-top" alt="">
   							 CommunityExample
						  </a>
						  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						    <span class="navbar-toggler-icon"></span>
						  </button>
						
						  <div class="collapse navbar-collapse" id="navbarSupportedContent">
						    <ul class="navbar-nav mr-auto">
						      <li class="nav-item active">
						        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link" href="#">Link</a>
						      </li>
						      <li class="nav-item dropdown">
						        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						          Dropdown
						        </a>
						        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						          <a class="dropdown-item" href="#">Action</a>
						          <a class="dropdown-item" href="#">Another action</a>
						          <div class="dropdown-divider"></div>
						          <a class="dropdown-item" href="#">Something else here</a>
						        </div>
						      </li>
						      <li class="nav-item">
						        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
						      </li>
						    </ul>
						    <form class="form-inline my-2 my-lg-0" style="margin-left: 250px;"><!-- todo:margin설정 -->
						      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
						      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
						    </form>
						 	<c:choose>
								<c:when test="">
									<div class="login"></div>
								</c:when>
								<c:otherwise>
									<div class="info"></div>
								</c:otherwise>
							</c:choose>
						  </div>
						</nav>
					</div>
				</header>
				
				<div class="con">
					this is section
					<hr>
				</div>
				
				<footer>
				</footer>
			</div>
		</body>
		
	</html>
