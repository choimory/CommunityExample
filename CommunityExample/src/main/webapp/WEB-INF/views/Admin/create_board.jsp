
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<div class="card border-secondary">
		<div class="card-body text-center">

			<div class="ce_admin_ban_title">
				<h3 class="pb-5 mb-5">
					<small>게시판 생성</small>
				</h3>
			</div>

			<div class="ce_alert">
				<c:choose>
					<c:when test="${result eq 1}">
						<div class="alert alert-success alert-dismissible fade show"
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
				<form action="/communityexample/admin/create_board" method="post">
					<div class="form-group">
						<label for="exampleFormControlSelect1">게시판 타입 선택</label> <select
							class="form-control" name="bTypeKor"
							id="exampleFormControlSelect1">
							<c:forEach items="${boardTypeKorList}" var="boardTypeKor">
								<option value="${boardTypeKor}">${boardTypeKor}</option>
							</c:forEach>
						</select>
					</div>

					<hr class="my-5">

					<div class="form-group">
						<label>게시판 명 (한글)</label>
						<div class="input-group">
							<input type="text" class="form-control"
								aria-label="Recipient's username"
								aria-describedby="button-addon2" name="bIdKor">
							<div class="input-group-append">
								<button class="btn btn-outline-info" type="button"
									id="button-addon2">중복확인</button>
							</div>
						</div>
						<small class="text-muted"> 예] 축구, 걸그룹, 오버워치</small>
					</div>
					<div class="form-group">
						<label>게시판 명 (영문)</label>
						<div class="input-group">
							<input type="text" class="form-control"
								aria-label="Recipient's username"
								aria-describedby="button-addon2" name="bId">
							<div class="input-group-append">
								<button class="btn btn-outline-info" type="button"
									id="button-addon2">중복확인</button>
							</div>
						</div>
						<small class="text-muted"> 예] football, girlgroup, overwatch</small>
					</div>

					<hr class="my-5">

					<div class="form-group">
						<label>게시판 소개</label> <input type="text" class="form-control"
							name="bIntroduce"> <small class="text-muted">예]
							리그오브레전드에 관련된 글을 올려주세요.</small>
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
