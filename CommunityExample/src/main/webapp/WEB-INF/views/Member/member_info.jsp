<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<style>
.card-body:hover {
	background-color: #f2f2f2;
}
</style>


<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">

	<!-- start of content -->
	<div class="userid mt-3 mb-5">
		<img class="rounded-circle"
			src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png"
			width="40" height="40"> <span class="lead ml-1">your
			name님의 회원정보</span>
	</div>


	<div class="row">
		<div class="col-md-6">
			<div class="card mb-4">
				<div class="card-header">기본정보</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Integer posuere erat a ante.</p>
						<footer class="blockquote-footer">
							Someone famous in <cite title="Source Title">Source Title</cite>
						</footer>
					</blockquote>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="card mb-4">
				<div class="card-header">추가정보</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Integer posuere erat a ante.</p>
						<footer class="blockquote-footer">
							Someone famous in <cite title="Source Title">Source Title</cite>
						</footer>
					</blockquote>
				</div>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-md-6">
			<div class="card mb-4">
				<div class="card-header">보유아이콘</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Integer posuere erat a ante.</p>
						<footer class="blockquote-footer">
							Someone famous in <cite title="Source Title">Source Title</cite>
						</footer>
					</blockquote>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="card mb-4">
				<div class="card-header">위시리스트</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Integer posuere erat a ante.</p>
						<footer class="blockquote-footer">
							Someone famous in <cite title="Source Title">Source Title</cite>
						</footer>
					</blockquote>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="card mb-4">
				<div class="card-header">북마크한 게시판</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Integer posuere erat a ante.</p>
						<footer class="blockquote-footer">
							Someone famous in <cite title="Source Title">Source Title</cite>
						</footer>
					</blockquote>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="card mb-4">
				<div class="card-header">북마크한 게시물</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Integer posuere erat a ante.</p>
						<footer class="blockquote-footer">
							Someone famous in <cite title="Source Title">Source Title</cite>
						</footer>
					</blockquote>
				</div>
			</div>
		</div>
	</div>

	<div class="ce_btn mt-5 text-right">
		<button type="button" class="btn btn-success"
			onclick="location.href='/communityexample/modify_info'">비밀번호
			변경</button>
		<button type="button" class="btn btn-danger"
			onclick="location.href='/communityexample/withdraw'">탈퇴하기</button>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
