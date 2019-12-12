<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_shop_main_title mb-5 pb-5">
		<span class="h3 mr-2"><a href="/communityexample/shop/icon"
			class="text-dark text-decoration-none">아이콘<i
				class="fas fa-store-alt mx-1 text-warning"></i></a></span> <span
			class="ce_btn float-right"><button type="button"
				class="btn btn-light btn-sm mx-1">분류</button>
			<button type="button" class="btn btn-light btn-sm mx-1" onclick="location.href='/communityexample/shop/write'">업로드</button></span>
		<span class="blockquote-footer">게시판 설명</span>
	</div>


	<div class="ce_shop_list_form text-center">
		<form action="/communityexample/shop/search" method="get">
			<div class="form-row">
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control">
						<option value="icon">아이콘</option>
						<option value="profile">프로필</option>
					</select>
				</div>
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control" name="target">
						<option value="both">제목+내용</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="nickname">글쓴이</option>
					</select>
				</div>
				<div class="form-group col-xl-6">
					<input type="text" class="form-control" placeholder="검색" name="query">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">검색</button>
				</div>
				<div class="form-group col-xl-1">
					<button type="button" class="btn btn-info" onclick="location.href='/communityexample/shop/write'">작성</button>
				</div>
			</div>
		</form>
	</div>


	<div class="ce_shop_list_icon mb-5">
		<c:forEach begin="1" end="3">
			<div class="card-deck my-3">
				<c:forEach begin="1" end="4">
					<div class="card">
						<a href="/communityexample/shop/${sindex}"><img src="http://placehold.it/250x250" class="card-img-top"
							alt="..."></a>
						<div class="card-body">
							<h5 class="card-title"><a class="text-dark" href="/communityexample/shop/${sindex}">Card title</a></h5>
							<p class="card-text">This is a wider card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Last updated 3 mins ago</small>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
	</div>


	<div class="ce_shop_list_icon_scroll text-center mb-5">
		<i class="fas fa-arrow-down fa-3x text-center"></i>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
