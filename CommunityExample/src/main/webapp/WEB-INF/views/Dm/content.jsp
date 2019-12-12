<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_dm_info mb-5">
		<a class="text-decoration-none text-dark" href="/communityexample/dm"><span
			class="h3 mr-2">쪽지</span> <span class="text-info"><i
				class="far fa-envelope-open fa-2x"></i></span></a> <span
			class="blockquote-footer">${mNickname}님의 메시지 관리 페이지입니다</span>
	</div>

	<div class="ce_dm_content mb-5 pb-5">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col" colspan="2">국가는 법률이 정하는 바에 의하여 재외국민을 보호할 의무를
						진다. 선거와 국민투표의 공정한 관리 및 정당에 관한 사무를 처리하기 위하여 선거관리위원회를 둔다. 국회의 정기회는
						법률이 정하는 바에 의하여 매년 1회 집회되며, 국회의 임시회는 대통령 또는 국회재적의원 4분의 1 이상의 요구에
						의하여 집회된다. 국회의 회의는 공개한다. 다만, 출석의원 과반수의 찬성이 있거나 의장이 국가의 안전보장을 위하여
						필요하다고 인정할 때에는 공개하지 아니할 수 있다.</th>
				</tr>
			</thead>
			<tbody>
				<tr class="font-weight-light">
					<td class="text-left"><img
						src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png"
						width="15" height="15" class="mx-1" alt=""><small>글쓴이</small></td>
					<td class="text-md-right"><small> <i
							class="far fa-eye mx-1"></i>10000 <i
							class="far fa-calendar-alt mx-1"></i>2020-01-01 00:00:00 <i
							class="far fa-thumbs-up mx-1"></i>135
					</small></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="ce_board_article py-3 mb-3">국가는 법률이 정하는 바에 의하여
							재외국민을 보호할 의무를 진다. 선거와 국민투표의 공정한 관리 및 정당에 관한 사무를 처리하기 위하여 선거관리위원회를
							둔다. 국회의 정기회는 법률이 정하는 바에 의하여 매년 1회 집회되며, 국회의 임시회는 대통령 또는 국회재적의원
							4분의 1 이상의 요구에 의하여 집회된다. 국회의 회의는 공개한다. 다만, 출석의원 과반수의 찬성이 있거나 의장이
							국가의 안전보장을 위하여 필요하다고 인정할 때에는 공개하지 아니할 수 있다.</div>
					</td>
				</tr>
				<tr>
					<td class="text-right" colspan="2"><a href=""
						class="text-body text-decoration-none"><i
							class="fas fa-paperclip fa-2x mx-2"></i></a><a href=""
						class="text-body text-decoration-none"> <i
							class="fas fa-share-alt fa-2x mx-2"></i></a><a href=""
						class="text-body text-decoration-none"> <i
							class="far fa-flag fa-2x mx-2"></i></a></td>
				</tr>
				<tr>
					<td class="text-right" colspan="2"><a href=""
						class="text-body text-decoration-none"><i
							class="fas fa-reply fa-2x mx-2"></i></a> <a href=""
						class="text-body text-decoration-none"><i
							class="far fa-trash-alt fa-2x mx-2"></i></a></td>
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
					<input type="text" class="form-control" placeholder="검색"
						name="query">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">검색</button>
				</div>
				<div class="form-group col-xl-1">
					<button type="button" class="btn btn-info"
						onclick="location.href=''">작성</button>
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