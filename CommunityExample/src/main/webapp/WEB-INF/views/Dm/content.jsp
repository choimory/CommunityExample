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

	<div class="ce_dm_content mb-5 pb-5">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col" colspan="2">${dmDto.dmTitle}</th>
				</tr>
			</thead>
			<tbody>
				<tr class="font-weight-light">
					<td class="text-left">
						<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png" width="15" height="15" class="mx-1" alt="">
						<small>${dmDto.dmSenderNickname}</small>
					</td>
					<td class="text-md-right">
						<small>
							<i class="far fa-calendar-alt mx-1 text-info"></i>
							발신일 ${dmDto.dmSendDate}
							<i class="far fa-calendar-alt mx-1 text-danger"></i>
							수신일 ${dmDto.dmReceiveDate}
						</small>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="ce_board_article py-3 mb-3">${dmDto.dmContent}</div>
					</td>
				</tr>
				<tr>
					<td class="text-right" colspan="2">
						<button type="button" class="btn btn-light" data-toggle="modal" data-target="#exampleModal">
							<i class="fas fa-paperclip fa-2x mx-2"></i>
						</button>
						<button type="button" class="btn btn-light">
							<i class="fas fa-share-alt fa-2x mx-2"></i>
						</button>
						<button type="button" class="btn btn-light" onclick="reportArticle();">
							<i class="far fa-flag fa-2x mx-2"></i>
						</button>
					</td>
				</tr>
				<tr>
					<td class="text-right" colspan="2">
						<a href="" class="text-body text-decoration-none">
							<i class="fas fa-reply fa-2x mx-2"></i>
						</a>
						<a href="" class="text-body text-decoration-none">
							<i class="far fa-trash-alt fa-2x mx-2"></i>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
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
				<c:forEach items="${dmDtoList}" var="dmDto">
					<tr>
						<td>
							<a href="" class="text-decoration-none text-body">${dmDto.dmSenderNickname}</a>
						</td>
						<td>
							<a href="" class="text-decoration-none text-body">${dmDto.dmReceiverNickname}</a>
						</td>
						<td>
							<a href="/communityexample/dm/${dmDto.dmIdx}" class="text-body">${dmDto.dmTitle}</a>
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
			</tbody>
		</table>
	</div>


	<div class="ce_dm_list_search text-center">
		<form action="/communityexample/dm/search">
			<div class="form-row">
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control" name="target">
						<option>제목+내용</option>
						<option>발신자</option>
						<option>제목</option>
						<option>내용</option>
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




<!-- file download modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					<i class="fas fa-paperclip mx-2"></i>
					첨부파일
				</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:forEach items="${dmDto.dmFileDtoList}" var="dmFileDto">
					<i class="fas fa-paperclip mx-1"></i>
					<a href="/communityexample/dm/download?fIdx=${dmFileDto.fIdx}&fOriginalName=${dmFileDto.fOriginalName}&fStoredName=${dmFileDto.fStoredName}">${dmFileDto.fOriginalName}</a>
					<br>
				</c:forEach>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
