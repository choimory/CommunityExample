<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="card border-secondary">
		<div class="card-body text-center">

			<div class="ce_admin_ban_title">
				<h3 class="pb-5 mb-5">
					<small>이용정지</small>
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
				<form action="/communityexample/admin/ban" method="post">
					<div class="form-group">
						<label>닉네임</label> 
						<input type="text" class="form-control text-center" name="mNickname">
					</div>
					<div class="form-group">
						<label>이용정지 종료날짜</label>
						<input type="date" class="form-control text-center" name="mEndToBan">
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
