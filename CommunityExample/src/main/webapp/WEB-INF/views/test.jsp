<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
	
		<head>
			<meta charset="UTF-8" name="viewport" content="initial-scale=1, width=device-width"/>
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script> 	
			<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
			<title>this is test</title>
		</head>
	
		<body>
			<div class="wrap bg-light">
			
				<header>
					<nav class="navbar navbar-expand-md  navbar-dark bg-dark">
					  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					    <span class="navbar-toggler-icon"></span>
					  </button>	
					  <a class="navbar-brand" style="margin-left:10%;" href="#">
					    <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png" width="30" height="30" class="d-inline-block align-top" alt="">
					    CommunityExample
					  </a>
					  
					  				
					  <div class="collapse navbar-collapse" id="navbarSupportedContent">
					    <ul class="navbar-nav">
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
					    <form class="form-inline">
					      <input class="form-control ml-sm-5" type="search" placeholder="Search" aria-label="Search">
					      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					    </form>
					    
					    					
					  </div>
					  <div class="infobar text-white" style="float:right; margin-right: 10%;">
						  <c:choose>
								<c:when test="">
							    	<div class="guest"></div>
							    </c:when>
								<c:otherwise>    
								    <div class="member">
								    	<a class="py-2" href="#">
									    	<img class="rounded-circle" src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png" width="30" height="30" >
									    	nickname
								    	</a>
								    </div>
								</c:otherwise>
							</c:choose>
						</div>	
					</nav>
				</header>
				
					<div class="container bg-white py-4">
						this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is sectionthis is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section this is section
					</div>
					
				<footer>
					<div class="jumbotron jumbotron-fluid bg-dark text-white-50 py-2 m-0">
					  <div class="container">
					    <h1 class="display-4">Community Example</h1>
					    <p class="lead">Copyright (c) CommunityExample All Right Reserved.</p>
					    <p class="text-muted">사용기술 | 개인정보취급방침 | 이용약관</p>
					    <p class="text-muted">Contact : choimory@naver.com</p>
					  </div>
					</div>
				</footer>
				
			</div>
			
		</body>
		
	</html>
