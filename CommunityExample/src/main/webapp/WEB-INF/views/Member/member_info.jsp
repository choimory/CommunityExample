<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
.card-body:hover {
	background-color: #f2f2f2;
}
</style>


<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">

	<!-- start of content -->
	<div class="userid mt-3 mb-5">
		<img class="rounded-circle" src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png" width="40" height="40">
		<span class="lead ml-1">${memberDto.mNickname}님의 회원정보</span>
	</div>


	<div class="row">
		<div class="col-md-6">
			<div class="card mb-4">
				<div class="card-header">기본정보</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p>
							<span class="badge badge-info mr-1">아이디</span>${memberDto.mId}</p>
						<p>
							<span class="badge badge-info mr-1">닉네임</span>${memberDto.mNickname}</p>
						<p>
							<span class="badge badge-info mr-1">이메일</span>${memberDto.mEmail}</p>
					</blockquote>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="card mb-4">
				<div class="card-header">추가정보</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p>
							<span class="badge badge-info mr-1">보유 경험치</span>${memberDto.memberInfoDto.mExp}</p>
						<p>
							<span class="badge badge-info mr-1">보유 포인트</span>${memberDto.memberInfoDto.mPoint}</p>
						<p>
							<span class="badge badge-info mr-1">회원 가입일</span>${memberDto.memberInfoDto.mRegDate}</p>
						<p>
							<span class="badge badge-info mr-1">최종 접속일</span>${memberDto.memberInfoDto.mLoginDate}</p>
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
						<c:forEach items="${resultMap.bookmarkBoardDtoList}" var="bookmarkBoardDto">
							<small><span class="badge badge-info">${bookmarkBoardDto.bIdKor}</span></small>
						</c:forEach>
						<footer class="blockquote-footer">
							<a href="" class="text-decoration-none">자세히 보기</a>
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
						<c:forEach items="${resultMap.bookmarkArticleDtoList}" var="bookmarkArticleDto" end="4">
							<small><a href="">${bookmarkArticleDto.bIdx}<br></a></small>
						</c:forEach>
						<footer class="blockquote-footer">
							<a href="" class="text-decoration-none">자세히 보기</a>
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
						<c:forEach items=""></c:forEach>
						<img src="${iconPath}/lol.png" height="40" weight="40">
					</blockquote>
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="card mb-4">
				<div class="card-header">위시리스트</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
						<footer class="blockquote-footer">
							Someone famous in <cite title="Source Title">Source Title</cite>
						</footer>
					</blockquote>
				</div>
			</div>
		</div>
	</div>

	<div class="ce_btn mt-5 text-right">
		<button type="button" class="btn btn-success" onclick="location.href='/communityexample/modify_info'">회원정보 수정</button>
		<button type="button" class="btn btn-danger" onclick="location.href='/communityexample/withdraw'">탈퇴하기</button>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
