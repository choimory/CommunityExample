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
					<c:when test="${result eq 1}">
						<div class="alert alert-ban alert-dismissible fade show"
							role="alert">
							<strong>작업성공</strong> 정상적으로 처리되었습니다.
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:when>
					<c:when test="${result eq -1}">
						<div class="alert alert-danger alert-dismissible fade show"
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
				<form action="/communityexample/admin/ban" method="post">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							id="inlineRadio1" name="mBan" value=1>
						<label class="form-check-label" for="inlineRadio1">정지</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							id="inlineRadio2" name="mBan" value=0>
						<label class="form-check-label" for="inlineRadio2">해제</label>
					</div>
					<div class="form-group mt-5">
						<label>아이디</label> <input type="text"
							class="form-control text-center" name="mId" value="${mId}">
					</div>
					<div class="form-group">
						<label>정지사유</label> <input type="text"
							class="form-control text-center" name="mReason"
							aria-describedby="mReasonHelp"><small id="mReasonHelp"
							class="form-text text-muted">(정지선택시 입력)</small>
					</div>
					<div class="form-group">
						<label>이용정지 종료날짜</label> <input type="date"
							class="form-control text-center" name="mEndToBan"
							aria-describedby="mEndToBanHelp"><small id="mEndToBanHelp"
							class="form-text text-muted">(정지선택시 입력)</small>
					</div>

					<div class="ce_btn row mt-5">
						<div class="col">
							<button type="submit" class="btn btn-success btn-block">확인</button>
						</div>
						<div class="col">
							<button type="button" class="btn btn-danger btn-block"
								onclick="location.href='/communityexample/admin'">취소</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
