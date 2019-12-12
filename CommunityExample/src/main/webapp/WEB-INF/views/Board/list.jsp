<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">

	<!-- start of content -->
	<div class="board_info mb-5">
		<span class="h3 mr-2"><a href="/communityexample/${board_id}"
			class="text-dark text-decoration-none">${board_id}</a></span> <span
			class="ce_bookmark"> <c:choose>
				<c:when test="${title eq null}">
					<a href="" class="text-decoration-none text-warning"><i
						class="fas fa-bookmark fa-2x"></i></a>
				</c:when>
				<c:otherwise>
					<a href="" class="text-decoration-none text-warning"><i
						class="far fa-bookmark fa-2x"></i></a>
				</c:otherwise>
			</c:choose>
		</span> <span class="blockquote-footer">저작자·발명가·과학기술자와 예술가의 권리는 법률로써
			보호한다. 법원은 최고법원인 대법원과 각급법원으로 조직된다. 모든 국민은 소급입법에 의하여 참정권의 제한을 받거나 재산권을
			박탈당하지 아니한다. 국회는 국정을 감사하거나 특정한 국정사안에 대하여 조사할 수 있으며, 이에 필요한 서류의 제출 또는
			증인의 출석과 증언이나 의견의 진술을 요구할 수 있다.</span>
	</div>


	<div class="ce_board_list_category">
		<c:forEach begin="1" end="5">
			<button type="button" class="btn btn-info mb-1"
				onclick="location.ref=''">{bCategory}</button>
		</c:forEach>
	</div>


	<div class="ce_board_list my-2 table-responsive text-nowrap">
			<table class="table text-center table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">분류</th>
						<th scope="col">제목</th>
						<th scope="col">글쓴이</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
						<th scope="col">추천수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="20" varStatus="var">
						<tr>
							<td><a class="text-dark"
								href="/communityexample/search?bCategory=">{bCategory}</a></td>
							<td><a class="text-dark"
								href="/communityexample/${bId}/${bIndex}">{bTitle}<span class="badge badge-info mx-1">{bCommentnum}</span></a></td>
							<td><a class="text-decoration-none text-dark"
								href="/communityexample/search?mNickname="><img
									src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png"
									width="15" height="15" class="mx-1" alt="">{mNickname}</a></td>
							<td>{bDate}</td>
							<td>{bHit}</td>
							<td>{bUpVote-bDownVote}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


	<div class="ce_board_list_form text-center">
		<form action="">
			<div class="form-row">
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control" name="bCategory">
						<option value="all">전체</option>
						<option value="">잡담</option>
						<option value="">질문</option>
					</select>
				</div>
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control" name="target">
						<option value="both">제목+내용</option>
						<option value="title">제목</option>
						<option value="nickname">글쓴이</option>
						<option value="content">내용</option>
					</select>
				</div>
				<div class="form-group col-xl-6">
					<input type="text" class="form-control" placeholder="검색"
						name="query">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">검색</button>
				</div>
				<div class="form-group col-xl-1">
					<button type="button" class="btn btn-info">작성</button>
				</div>
			</div>
		</form>
	</div>


	<div class="ce_board_list_pagination">
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
<%@include file="../include/footer.jsp"%>