<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">

	<!-- start of content -->
	<div class="card border-secondary">
		<div class="card-body text-center">


			<div class="title">
				<h3 class="pb-5 mb-5">
					<small>회원가입</small>
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

			<div class="ce_form text-left">
				<form action="/communityexample/join" method="post">
					<div class="ce_id form-group">
						<label>ID</label>
						<div class="input-group mb-3">
							<input type="text" class="form-control"
								aria-label="Recipient's username"
								aria-describedby="button-addon2" name="mId">
							<div class="input-group-append">
								<button class="btn btn-outline-info" type="button"
									id="button-addon2">중복확인</button>
							</div>
						</div>
					</div>

					<div class="ce_pw form-group">
						<label>비밀번호</label> <input type="password" class="form-control" name="mPassword">
					</div>

					<div class="ce_pw_confirm form-group">
						<label>비밀번호 확인</label> <input type="password" class="form-control" name="mPasswordCheck">
					</div>

					<div class="ce_nickname form-group">
						<label>닉네임</label>
						<div class="input-group mb-3">
							<input type="text" class="form-control"
								aria-label="Recipient's username"
								aria-describedby="button-addon2" name="mNickname">
							<div class="input-group-append">
								<button class="btn btn-outline-info" type="button"
									id="button-addon2">중복확인</button>
							</div>
						</div>
					</div>

					<div class="ce_email form-group">
						<label>Email</label>
						<div class="input-group mb-3">
							<input type="text" class="form-control"
								placeholder="예) email@example.com"
								aria-label="Recipient's username"
								aria-describedby="button-addon2" name="mEmail">
							<div class="input-group-append">
								<button class="btn btn-outline-info" type="button"
									id="button-addon2">중복확인</button>
							</div>
						</div>
						<small id="emailHelp" class="form-text text-muted">입력하신
							이메일로 가입 인증번호가 발송됩니다</small>
					</div>
					<div class="ce_btn row mt-5">
						<div class="col">
							<button type="submit" class="btn btn-success btn-block">회원가입</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-danger btn-block"
								onclick="location.href='/communityexample/main'">취소하기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
