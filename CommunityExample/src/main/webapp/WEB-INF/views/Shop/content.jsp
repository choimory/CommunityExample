<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->

	<div class="ce_shop_info mb-5 pb-5">
		<span class="h3 mr-2">아이콘(혹은 프로필)</span> <span class="ce_shop_icon">
			<i class="fas fa-shopping-cart fa-2x"></i>
		</span> <span class="blockquote-footer">설명</span>
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
						<div class="text-center">
							<div>
								5 <i class="far fa-thumbs-up fa-2x mx-2"></i> <i
									class="far fa-heart fa-2x mx-2"></i><i
									class="fas fa-heart fa-2x mx-2"></i> <i
									class="far fa-thumbs-down fa-2x mx-2"></i>1
							</div>
							<div>
								<i class="fas fa-caret-left fa-2x mx-2"></i> <i
									class="fas fa-list fa-2x mx-2"></i> <i
									class="fas fa-caret-right fa-2x mx-2"></i>
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
				<tr>
					<td class="text-right" colspan="2"><i
						class="fas fa-pencil-alt fa-2x mx-2"></i> <i
						class="fas fa-eraser fa-2x mx-2"></i> <i
						class="far fa-trash-alt fa-2x mx-2"></i></td>
				</tr>
			</tbody>
		</table>
	</div>


	<div class="ce_shop_comment_list mt-5 pt-5">
		<small>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col" colspan="2">댓글(50)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="50">
						<tr class="table-active">
							<td class="py-2"><img
								src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Bootstrap_logo.svg/1200px-Bootstrap_logo.svg.png"
								width="15" height="15" class="mx-1" alt=""> 글쓴이 <i
								class="fas fa-pencil-alt ml-1"></i> <i
								class="fas fa-eraser ml-1"></i> <i class="far fa-trash-alt ml-1"></i></td>
							</td>
							<td class="text-right py-2"><i
								class="far fa-calendar-alt mx-1"></i>2020-01-01 00:00:00 <i
								class="far fa-thumbs-up mx-1"></i>135<i
								class="far fa-thumbs-up mx-1"></i>135</td>
						</tr>
						<tr>
							<td colspan="2" class="py-4">여기에다가 내용을 쫘아아아아아아아아아아아아아아악 고급지쥬</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</small>
	</div>


	<div class="ce_shop_comment_form text-center">
		<form>
			<div class="form-row">
				<div class="form-group col-xl-11">
					<input type="text" class="form-control" placeholder="댓글입력">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">작성</button>
				</div>
			</div>
		</form>
	</div>


	<div class="ce_shop_comment_pagination">
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


	<div class="ce_shop_info mt-5 pt-5">
		<span class="h3 mr-2">아이콘(혹은 프로필)</span> <span class="ce_shop_icon">
			<i class="fas fa-shopping-cart fa-2x"></i>
		</span> <span class="blockquote-footer">설명</span>
	</div>


	<div class="ce_shop_list_form text-center mt-5 pt-3">
		<form>
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


	<div class="ce_shop_list">
		<div class="card-deck my-3">
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This is a wider card with supporting text
						below as a natural lead-in to additional content. This content is
						a little bit longer.</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 3 mins ago</small>
				</div>
			</div>
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This card has supporting text below as a
						natural lead-in to additional content.</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 3 mins ago</small>
				</div>
			</div>
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This is a wider card with supporting text
						below as a natural lead-in to additional content. This card has
						even longer content than the first to show that equal height
						action.</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 3 mins ago</small>
				</div>
			</div>
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This is a wider card with supporting text
						below as a natural lead-in to additional content. This card has
						even longer content than the first to show that equal height
						action.</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 3 mins ago</small>
				</div>
			</div>
		</div>
		<div class="card-deck my-3">
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This is a wider card with supporting text
						below as a natural lead-in to additional content. This content is
						a little bit longer.</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 3 mins ago</small>
				</div>
			</div>
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This card has supporting text below as a
						natural lead-in to additional content.</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 3 mins ago</small>
				</div>
			</div>
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This is a wider card with supporting text
						below as a natural lead-in to additional content. This card has
						even longer content than the first to show that equal height
						action.</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 3 mins ago</small>
				</div>
			</div>
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This is a wider card with supporting text
						below as a natural lead-in to additional content. This card has
						even longer content than the first to show that equal height
						action.</p>
				</div>
				<div class="card-footer">
					<small class="text-muted">Last updated 3 mins ago</small>
				</div>
			</div>
		</div>
	</div>

	<div class="ce_shop_list_scroll text-center my-3">
		<i class="fas fa-arrow-down fa-3x text-center"></i>
	</div>

	<div class="ce_shop_list_pagination">
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
<%@ include file="../include/footer.jsp"%>