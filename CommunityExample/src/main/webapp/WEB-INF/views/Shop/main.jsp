<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_shop_main_title mb-5 pb-5">
		<span class="h3 mr-2"><a href="/communityexample/shop"
			class="text-dark text-decoration-none">상점<i
				class="fas fa-store-alt mx-1 text-warning"></i></a></span> <span
			class="ce_btn float-right"><button type="button"
				class="btn btn-light btn-sm mx-1"
				onclick="location.href='/communityexample/shop/icon'">아이콘</button>
			<button type="button" class="btn btn-light btn-sm mx-1"
				onclick="location.href='/communityexample/shop/profile'">프로필</button>
			<button type="button" class="btn btn-light btn-sm mx-1"
				onclick="location.href='/communityexample/shop/write'">업로드</button></span>
		<span class="blockquote-footer">게시판 설명</span>
	</div>


	<div class="shop_main_icon my-5">
		<h4 class="font-weight-bold my-3">최근 인기있는 아이콘</h4>

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


	<div class="ce_shop_main_icon_scroll text-center mb-5">
		<i class="fas fa-arrow-down fa-3x text-center"></i>
	</div>


	<hr class="mb-5 pb-5">


	<div class="shop_main_icon my-5">
		<h4 class="font-weight-bold my-3">최근 인기있는 프로필</h4>
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


	<div class="ce_shop_main_icon_scroll text-center mb-5">
		<i class="fas fa-arrow-down fa-3x text-center"></i>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>