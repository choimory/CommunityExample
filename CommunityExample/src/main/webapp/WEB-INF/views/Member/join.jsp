<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	var result=[-1,-1,-1];	
</script>

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

			<div id="ce_alert"></div>

			<div class="ce_form text-left">
				<form action="/communityexample/join" method="post">
					<div class="ce_id form-group">
						<label>ID</label>
						<div class="input-group mb-3">
							<input type="text" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2" name="mId" id="join_id">
							<div class="input-group-append">
								<button class="btn btn-outline-info" type="button" id="join_idcheck" onclick="idCheck();">중복확인</button>
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
							<input type="text" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2" id="join_nickname" name="mNickname">
							<div class="input-group-append">
								<button class="btn btn-outline-info" type="button" id="join_nicknamecheck" onclick="nicknameCheck();">중복확인</button>
							</div>
						</div>
					</div>

					<div class="ce_email form-group">
						<label>Email</label>
						<div class="input-group mb-3">
							<input type="text" class="form-control" placeholder="예) email@example.com" aria-label="Recipient's username" aria-describedby="button-addon2" name="mEmail" id="join_email">
							<div class="input-group-append">
								<button class="btn btn-outline-info" type="button" id="join_emailcheck" onclick="emailCheck();">중복확인</button>
							</div>
						</div>
						<small id="emailHelp" class="form-text text-muted">입력하신 이메일로 가입 인증번호가 발송됩니다</small>
					</div>
					<div class="ce_btn row mt-5">
						<div class="col">
							<button type="submit" class="btn btn-success btn-block" id="join_submit" disabled="disabled">회원가입</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-danger btn-block" onclick="location.href='/communityexample/main'">취소하기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
