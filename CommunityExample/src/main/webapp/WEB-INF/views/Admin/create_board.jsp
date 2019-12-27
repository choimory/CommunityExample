
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<div class="card border-secondary">
		<div class="card-body text-center">

			<div class="ce_admin_ban_title">
				<h3 class="pb-5 mb-5">
					<small>카테고리/게시판/글분류 생성</small>
				</h3>
			</div>

			<div class="ce_alert">
				<c:choose>
					<c:when test="">
					</c:when>
					<c:otherwise>
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							<strong>Holy guacamole!</strong> You should check in on some of
							those fields below.
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:otherwise>
				</c:choose>
			</div>

			<div class="ce_form text-left">
				<form action="/communityexample/admin/create_board" method="post">
					<div class="form-group">
						<label>게시판 타입(한글)</label> <input type="text" class="form-control"
							name="bTypeKor"> <small class="text-muted"> 예]
							유머,연예, 스포츠</small>
					</div>
					<div class="form-group">
						<label>게시판 타입(영문)</label> <input type="text" class="form-control"
							name="bType"> <small class="text-muted"> 예]
							Humor,Entertainment, Sports</small>
					</div>
					<hr class="my-3">
					<div class="form-group">
						<label>게시판 명(한글)</label> <input type="text" class="form-control"
							name="bIdKor"> <small class="text-muted">예] 야구,
							아이돌</small>
					</div>
					<div class="form-group">
						<label>게시판 명(영문)</label> <input type="text" class="form-control"
							name="bId"> <small class="text-muted"> 예]
							Baseball, idol</small>
					</div>
					<hr class="my-3">
					<div class="form-group">
						<label>게시물 카테고리</label> <input type="text" class="form-control"
							name="bCategory"> <small class="text-muted">예]
							잡담, 질문, 그외</small>
					</div>


					<div class="ce_btn row mt-5">
						<div class="col">
							<button type="submit" class="btn btn-success btn-block">확인</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-danger btn-block"
								onclick="location.href='/communityexample/main'">취소</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
