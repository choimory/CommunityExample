<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">

	<!-- start of content -->
	<div class="card border-secondary">
		<div class="card-body text-center">

			<div class="title">
				<h3 class="pb-5 mb-5">
					<small>비밀번호 변경</small>
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

			<div class="ce_form">
				<form action="" method="" enctype="multipart/form-data">
					<div class="ce_pw_now">
						<label>현재 비밀번호</label><input type="password" class="form-control">
					</div>
					<div class="ce_pw">
						<label>변경할 비밀번호</label><input type="password" class="form-control">
					</div>
					<div class="ce_pw_confirm">
						<label>변경할 비밀번호 확인</label><input type="password" class="form-control">
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
