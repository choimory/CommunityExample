<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">

	<!-- start of content -->
	<div class="card border-secondary">
		<div class="card-body text-center">

			<div class="title">
				<h3 class="pb-5 mb-5">
					<small>회원탈퇴</small>
				</h3>
			</div>

			<div class="ce_form">
				<form action="" method="" enctype="multipart/form-part">
					<div class="form-group">
						<label>비밀번호</label> <input type="password" class="form-control">
					</div>
					<div class="form-group">
						<label>비밀번호 확인</label> <input type="password" class="form-control">
					</div>
					<div class="alert-danger py-1 my-1 mt-5">모든 데이터를 소멸하고 서비스를
						탈퇴하는것에 동의합니다</div>
					<div class="form-group text-danger">
						<input type="text"
							class="form-control form-control-sm text-center"
							placeholder="위의 메시지를 따라 입력해주세요">
					</div>


					<div class="ce_btn text-center mt-5 row">
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