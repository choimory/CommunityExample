<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_dm_info mb-5">
		<a class="text-decoration-none text-dark" href="/communityexample/dm"><span class="h3 mr-2">쪽지</span> <span class="text-info"><i class="far fa-envelope-open fa-2x"></i></span></a> <span class="blockquote-footer">${mNickname}님의
			메시지 관리 페이지입니다</span>
	</div>

	<div class="ce_dm_list my-2 table-responsive text-nowrap">
		<table class="table table-hover text-center">
			<thead class="thead-dark">
				<tr>
					<th scope="col">보낸사람</th>
					<th scope="col">받는사람</th>
					<th scope="col">제목</th>
					<th scope="col">발신일</th>
					<th scope="col">수신일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="1" end="20" varStatus="var">
					<tr>
						<td><a href="" class="text-decoration-none text-body">{dSender}</a></td>
						<td><a href="" class="text-decoration-none text-body">{dReceiver}</a></td>
						<td><a href="" class="text-body">{dTitle}</a></td>
						<td>{dReceiveDate}</td>
						<td>{dSendDate}</td>
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
					<button type="button" class="btn btn-info" onclick="location.href=''">작성</button>
				</div>
			</div>
		</form>
	</div>


	<div class="ce_dm_pagination">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<li class="page-item"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
