<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_dm_info mb-5">
		<a class="text-decoration-none text-dark" href="/communityexample/dm">
			<span class="h3 mr-2">쪽지</span>
			<span class="text-info">
				<i class="far fa-envelope-open fa-2x"></i>
			</span>
		</a>
		<span class="blockquote-footer">${memberDto.mNickname}님의 메시지 관리 페이지입니다</span>
	</div>

	<div class="ce_alert">
		<c:choose>
			<c:when test="${result eq 1}">
				<div class="alert alert-success alert-dismissible fade show" role="alert">
					<strong>작업 성공</strong>
					정상적으로 처리되었습니다
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:when>
			<c:when test="${result eq -1}">
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
					<strong>작업 실패!</strong>
					작업을 수행하는데 실패하였습니다.
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:when>
		</c:choose>
	</div>

	<div class="ce_dm_list my-2 table-responsive text-nowrap">
		<table class="table table-hover text-center">
			<thead class="thead-dark">
				<tr>
					<th scope="col">보낸사람</th>
					<th scope="col">받는사람</th>
					<th scope="col" class="w-50">제목</th>
					<th scope="col">발신일</th>
					<th scope="col">수신일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${searchHelper.query eq null}">
					<c:forEach items="${dmDtoList}" var="dmDto">
						<tr>
							<td>
								<a href="" class="text-decoration-none text-body">${dmDto.dmSenderNickname}</a>
							</td>
							<td>
								<a href="" class="text-decoration-none text-body">${dmDto.dmReceiverNickname}</a>
							</td>
							<td>
								<a href="/communityexample/dm/${dmDto.dmIdx}?page=${pageHelper.page}" class="text-body">${dmDto.dmTitle}</a>
							</td>
							<td>${dmDto.dmSendDate}</td>
							<c:choose>
								<c:when test="${dmDto.dmSendDate eq dmDto.dmReceiveDate}">
									<td>읽지 않음</td>
								</c:when>
								<c:otherwise>
									<td>${dmDto.dmReceiveDate}</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${searchHelper.query ne null}">
					<c:forEach items="${dmDtoList}" var="dmDto">
						<tr>
							<td>
								<a href="" class="text-decoration-none text-body">${dmDto.dmSenderNickname}</a>
							</td>
							<td>
								<a href="" class="text-decoration-none text-body">${dmDto.dmReceiverNickname}</a>
							</td>
							<td>
								<a href="/communityexample/dm/${dmDto.dmIdx}?page=${pageHelper.page}&query=${searchHelper.query}" class="text-body">${dmDto.dmTitle}</a>
							</td>
							<td>${dmDto.dmSendDate}</td>
							<c:choose>
								<c:when test="${dmDto.dmSendDate eq dmDto.dmReceiveDate}">
									<td>읽지 않음</td>
								</c:when>
								<c:otherwise>
									<td>${dmDto.dmReceiveDate}</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>


	<div class="ce_dm_list_search text-center">
		<form action="/communityexample/dm/list">
			<div class="form-row">
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control" name="target">
						<option value="both">제목+내용</option>
						<option value="title">제목</option>
						<option value="nickname">글쓴이</option>
						<option value="content">내용</option>
					</select>
				</div>
				<div class="form-group col-xl-8">
					<input type="text" class="form-control" placeholder="검색" name="query">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">검색</button>
				</div>
				<div class="form-group col-xl-1">
					<button type="button" class="btn btn-info" onclick="location.href='/communityexample/dm/write'">작성</button>
				</div>
			</div>
		</form>
	</div>


	<div class="ce_dm_pagination">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="/communityexample/dm?page=${pageHelper.page-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach items="${pageHelper.pageGroup}" var="page">
					<c:choose>
						<c:when test="${pageHelper.page eq page}">
							<li class="page-item active"><a class="page-link" href="/communityexample/dm?page=${page}">${page}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="/communityexample/dm?page=${page}">${page}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li class="page-item"><a class="page-link" href="/communityexample/dm?page=${pageHelper.page+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
