<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">

	<!-- start of content -->
	<div class="card border-secondary">
		<div class="card-body text-center">

			<div class="title">
				<h3 class="pb-5 mb-5">
					<small>회원정보 수정</small>
				</h3>
			</div>

			<div class="ce_alert">
				<c:choose>
					<c:when test="${result eq 1}">
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							<strong>작업성공</strong> 정상적으로 처리되었습니다.
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:when>
					<c:when test="${result eq -1}">
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							<strong>작업실패</strong> 요청한 작업을 처리하는데 실패했습니다.
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:when>
				</c:choose>
			</div>

			<div class="ce_form">
				<form action="/communityexample/modify_info" method="post">
					<div class="ce_nickname">
						<label>변경할 닉네임</label><input type="text" class="form-control" name="mNickname">
					</div>
					<div class="ce_pw">
						<label>변경할 비밀번호</label><input type="password" class="form-control" name="mPassword">
					</div>
					<div class="ce_pw_confirm">
						<label>변경할 비밀번호 확인</label><input type="password" class="form-control" name="mPassword2">
					</div>
					<input type="hidden" name="mId" value="${memberDto.mId}">
					
					<div class="ce_btn row mt-5">
						<div class="col">
							<button type="submit" class="btn btn-success btn-block">확인</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-danger btn-block"
								onclick="location.href='/communityexample/member_info'">취소</button>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
