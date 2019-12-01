<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_dm_info mb-5">
		<span class="h3 mr-2">쪽지</span> <span class="blockquote-footer">게시판
			설명</span>
	</div>

	<div class="ce_dm_content mb-5 pb-5">
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
						<div class="ce_board_article py-3 mb-3">글내용을 이렇게
							쫘아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아아악
						</div>
					</td>
				</tr>
				<tr>
					<td class="text-right" colspan="2"><i
						class="fas fa-paperclip fa-2x mx-2"></i> <i
						class="fas fa-share-alt fa-2x mx-2"></i> <i
						class="far fa-flag fa-2x mx-2"></i></td>
				</tr>
				<tr>
					<td class="text-right" colspan="2"><i
						class="fas fa-reply fa-2x mx-2"></i> <i
						class="far fa-trash-alt fa-2x mx-2"></i></td>
				</tr>
			</tbody>
		</table>
	</div>


	<div class="ce_dm_info mb-5">
		<span class="h3 mr-2">쪽지</span> <span class="blockquote-footer">게시판
			설명</span>
	</div>


	<div class="ce_dm_list">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">First</th>
					<th scope="col">Last</th>
					<th scope="col">Handle</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach begin="1" end="20" varStatus="var">
					<tr>
						<th scope="row">${var.count}</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>@mdo</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<div class="ce_dm_form text-center">
		<form>
			<div class="form-row">
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control">
						<option selected>제목+내용</option>
						<option>...</option>
					</select>
				</div>
				<div class="form-group col-xl-8">
					<input type="text" class="form-control" placeholder="검색">
				</div>
				<div class="form-group col-xl-1"><button type="submit" class="btn btn-info">검색</button></div>
				<div class="form-group col-xl-1"><button type="button" class="btn btn-info">작성</button></div>
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