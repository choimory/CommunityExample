<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<h1 class="mb-5 pb-5">운영관리메뉴</h1>
	
	<div class="ce_menu">
		<p><a href="/communityexample/admin/ban">이용정지</a></p>
		<p><a href="/communityexample/admin/check_item">판매허가 대기목록</a></p>
		<p><a href="/communityexample/admin/check_report">신고수가 많은 게시물</a></p>
		<p><a href="/communityexample/admin/create_board_type">게시판 분류 생성</a></p>
		<p><a href="/communityexample/admin/create_board">게시판 생성</a></p>
		<p><a href="/communityexample/admin/add_board_category">게시판 카테고리 추가</a></p>
	</div>
	<!-- end of content -->


</div>
<%@ include file="../include/footer.jsp"%>