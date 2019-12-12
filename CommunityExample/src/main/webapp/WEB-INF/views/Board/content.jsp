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


	<div class="ce_board_content mb-5 pb-5">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col" colspan="2">저작자·발명가·과학기술자와 예술가의 권리는 법률로써 보호한다.
						법원은 최고법원인 대법원과 각급법원으로 조직된다. 모든 국민은 소급입법에 의하여 참정권의 제한을 받거나 재산권을
						박탈당하지 아니한다. 국회는 국정을 감사하거나 특정한 국정사안에 대하여 조사할 수 있으며, 이에 필요한 서류의 제출
						또는 증인의 출석과 증언이나 의견의 진술을 요구할 수 있다.</th>
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
						<div class="ce_board_article py-3 my-3">저작자·발명가·과학기술자와 예술가의
							권리는 법률로써 보호한다. 법원은 최고법원인 대법원과 각급법원으로 조직된다. 모든 국민은 소급입법에 의하여 참정권의
							제한을 받거나 재산권을 박탈당하지 아니한다. 국회는 국정을 감사하거나 특정한 국정사안에 대하여 조사할 수 있으며,
							이에 필요한 서류의 제출 또는 증인의 출석과 증언이나 의견의 진술을 요구할 수 있다.</div>

						<div class="ce_board_btn text-center">
							<div class="ce_board_thumbs my-2">
								5 <a href="" class="text-dark text-decoration-none"><i
									class="far fa-thumbs-up fa-2x mx-2"></i></a>
								<c:choose>
									<c:when test="">
										<a href="" class="text-danger text-decoration-none"> <i
											class="far fa-heart fa-2x mx-2"></i></a>
									</c:when>
									<c:otherwise>
										<a href="" class="text-danger text-decoration-none"> <i
											class="fas fa-heart fa-2x mx-2"></i></a>
									</c:otherwise>
								</c:choose>
								<a href="" class="text-dark text-decoration-none"><i
									class="far fa-thumbs-down fa-2x mx-2"></i></a>1
							</div>
							<div class="ce_board_page my-2">
								<a href="" class="text-dark text-decoration-none"><i
									class="fas fa-caret-left fa-2x mx-2"></i></a> <a href=""
									class="text-success text-decoration-none"><i
									class="fas fa-list fa-2x mx-2"></i></a> <a href=""
									class="text-dark text-decoration-none"><i
									class="fas fa-caret-right fa-2x mx-2"></i></a>
							</div>
						</div>
					</td>
				</tr>

				<tr>
					<td class="text-right" colspan="2"><a href=""
						class="text-dark text-decoration-none"><i
							class="fas fa-paperclip fa-2x mx-2"></i></a><a href=""
						class="text-dark text-decoration-none"><i
							class="fas fa-share-alt fa-2x mx-2"></i></a><a href=""
						class="text-dark text-decoration-none"> <i
							class="far fa-flag fa-2x mx-2"></i></a></td>
				</tr>
				<c:if test="">
					<tr>
						<td class="text-right" colspan="2"><a href=""
							class="text-dark text-decoration-none"><i
								class="fas fa-eraser fa-2x mx-2"></i></a><a href=""
							class="text-dark text-decoration-none"> <i
								class="far fa-trash-alt fa-2x mx-2"></i></a></td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>


	<div class="ce_board_comment_list">
		<small>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col" colspan="2"><i
							class="far fa-comment-dots mx-1"></i>댓글(50)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="50">
						<c:choose>
							<c:when test="${asdf ne null}">
								<tr class="table-active">
									<td class="py-2 pl-md-5"><img
										src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png"
										width="15" height="15" class="mx-1" alt=""> 글쓴이 <c:if
											test="">
											<a href="" class="text-body text-decoration-none"><i
												class="fas fa-reply ml-1"></i></a>
											<c:if test="">
												<a href="" class="text-body text-decoration-none"><i
													class="fas fa-eraser ml-1"></i></a>
												<a href="" class="text-body text-decoration-none"><i
													class="far fa-trash-alt ml-1"></i></a>
											</c:if>
										</c:if></td>
									<td class="text-right py-2"><i
										class="far fa-calendar-alt mx-1 text-body"></i>2020-01-01
										00:00:00 <a href="" class="text-decoration-none text-success"><i
											class="far fa-thumbs-up mx-1"></i></a>135<a href=""
										class="text-decoration-none text-danger"><i
											class="far fa-thumbs-up mx-1"></i></a>135</td>
								</tr>
								<tr>
									<td colspan="2" class="py-4 pl-md-5"><mark
											class="text-muted">@답글대상</mark> 답글테스트</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr class="table-active">
									<td class="py-2"><img
										src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png"
										width="15" height="15" class="mx-1" alt=""> 글쓴이<c:if
											test="">
											<a href="" class="text-body text-decoration-none"><i
												class="fas fa-reply ml-1"></i></a>
											<c:if test="">
												<a href="" class="text-body text-decoration-none"><i
													class="fas fa-eraser ml-1"></i></a>
												<a href="" class="text-body text-decoration-none"><i
													class="far fa-trash-alt ml-1"></i></a>
											</c:if>
										</c:if></td>
									<td class="text-right py-2"><i
										class="far fa-calendar-alt mx-1 text-body"></i>2020-01-01
										00:00:00 <a href="" class="text-decoration-none text-primary"><i
											class="far fa-thumbs-up mx-1"></i></a>135<a href=""
										class="text-decoration-none text-danger"><i
											class="far fa-thumbs-up mx-1"></i></a>135</td>
								</tr>
								<tr>
									<td colspan="2" class="py-3">저작자·발명가·과학기술자와 예술가의 권리는 법률로써
										보호한다. 법원은 최고법원인 대법원과 각급법원으로 조직된다. 모든 국민은 소급입법에 의하여 참정권의 제한을
										받거나 재산권을 박탈당하지 아니한다. 국회는 국정을 감사하거나 특정한 국정사안에 대하여 조사할 수 있으며, 이에
										필요한 서류의 제출 또는 증인의 출석과 증언이나 의견의 진술을 요구할 수 있다.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</small>
	</div>


	<div class="ce_board_comment_form text-center">
		<form action="" method="post">
			<div class="form-row">
				<div class="form-group col-xl-11">
					<input type="text" class="form-control" placeholder="댓글입력"
						name="cContent">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">작성</button>
				</div>
			</div>
		</form>
	</div>


	<div class="ce_board_comment_pagination">
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



	<div class="board_info mt-5 pt-5">
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


	<div class="ce_board_list_category mt-5">
		<c:forEach begin="1" end="5">
			<button type="button" class="btn btn-info mb-1"
				onclick="location.ref=''">잡담</button>
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
					<tr class="text-dark">
						<td><a class="text-dark"
							href="/communityexample/search?bCategory=">{bCategory}</a></td>
						<td><a class="text-dark"
							href="/communityexample/${bId}/${bIndex}">{bTitle}<span
								class="badge badge-info mx-1">{bCommentnum}</span></a></td>
						<td><a class="text-decoration text-dark"
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
					<button type="button" class="btn btn-info"
						onclick="location.href='/communityexample/${bId}/write'">작성</button>
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
</div>
<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>>
