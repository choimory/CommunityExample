<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="shop_info mb-5">
		<span class="h3 mr-2"><a href="/communityexample/shop/${sid}"
			class="text-dark text-decoration-none">{sid}</a></span> <span
			class="ce_bookmark"><i
				class="fas fa-store-alt fa-2x text-warning"></i></span> <span class="blockquote-footer">저작자·발명가·과학기술자와
			예술가의 권리는 법률로써 보호한다. 법원은 최고법원인 대법원과 각급법원으로 조직된다. 모든 국민은 소급입법에 의하여 참정권의
			제한을 받거나 재산권을 박탈당하지 아니한다. 국회는 국정을 감사하거나 특정한 국정사안에 대하여 조사할 수 있으며, 이에
			필요한 서류의 제출 또는 증인의 출석과 증언이나 의견의 진술을 요구할 수 있다.</span>
	</div>


	<div class="ce_shop_content mb-5 pb-5">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col" colspan="2">제목</th>
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
						<div class="ce_shop_article py-3 mb-3">글내용을 이렇게
							쫘아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아악
						</div>
						<div class="ce_shop_btn text-center">
							<div class="ce_shop_thumbs my-2">
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
							<div class="ce_shop_page my-2">
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
					<td class="text-right" colspan="2"><i
						class="fas fa-won-sign fa-2x mx-2"></i> <i
						class="fas fa-cart-plus fa-2x mx-2"></i> <i
						class="far fa-flag fa-2x mx-2"></i></td>
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


	<div class="ce_shop_comment_list">
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
										width="15" height="15" class="mx-1" alt="">글쓴이<c:if
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


	<div class="ce_shop_comment_form text-center">
		<form action="" method="post">
			<div class="form-row">
				<div class="form-group col-xl-11">
					<input type="text" class="form-control" placeholder="댓글입력"
						name="scContent">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">작성</button>
				</div>
			</div>
		</form>
	</div>


	<div class="ce_shop_comment_pagination mb-5 pb-5">
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


	<div class="ce_shop_main_title mb-5 pb-5">
		<span class="h3 mr-2"><a href="/communityexample/shop"
			class="text-dark text-decoration-none">아이콘<i
				class="fas fa-store-alt mx-1 text-warning"></i></a></span> <span
			class="ce_btn float-right"><button type="button"
				class="btn btn-light btn-sm mx-1">분류</button>
			<button type="button" class="btn btn-light btn-sm mx-1" onclick="location.href='/communityexample/shop/write'">업로드</button></span>
		<span class="blockquote-footer">게시판 설명</span>
	</div>


	<div class="ce_shop_list_form text-center">
		<form action="/communityexample/shop/search" method="get">
			<div class="form-row">
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control">
						<option selected>분류</option>
						<option>...</option>
					</select>
				</div>
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control">
						<option selected>제목+내용</option>
						<option>...</option>
					</select>
				</div>
				<div class="form-group col-xl-6">
					<input type="text" class="form-control" placeholder="검색">
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


	<div class="ce_shop_list_icon mb-5">
		<c:forEach begin="1" end="3">
			<div class="card-deck my-3">
				<c:forEach begin="1" end="4">
					<div class="card">
						<a href="/communityexample/shop/${sindex}"><img src="http://placehold.it/250x250" class="card-img-top"
							alt="..."></a>
						<div class="card-body">
							<h5 class="card-title"><a class="text-dark" href="/communityexample/shop/${sindex}">Card title</a></h5>
							<p class="card-text">This is a wider card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Last updated 3 mins ago</small>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
	</div>


	<div class="ce_shop_list_icon_scroll text-center mb-5">
		<i class="fas fa-arrow-down fa-3x text-center"></i>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>