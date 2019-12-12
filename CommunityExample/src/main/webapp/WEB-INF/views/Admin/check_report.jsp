<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_admin_report_title mb-5">
		<h3 class="h3 text-center">신고 검토</h3>
	</div>


	<div class="ce_admin_report_content table-responsive text-nowrap">
		<table class="table text-center">
			<thead class="thead-light">
				<tr>
					<th scope="col">게시판</th>
					<th scope="col">제목</th>
					<th scope="col">글쓴이</th>
					<th scope="col">조회수</th>
					<th scope="col">추천수</th>
					<th scope="col">신고수</th>
					<th scope="col">블라인드</th>
					<th scope="col">이용정지</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td scope="row"><a class="text-dark" href="/communityexample/${board_id}">{board_id}</a></td>
					<td><a class="text-decoration-none" href="/communityexample/${board_id}/${board_index}">MarkMarkMarkMarkMarkMarkMarkMark</a></td>
					<td>Mark</td>
					<td>Mark</td>
					<td>Mark</td>
					<td>Mark</td>
					<td><button type="button" class="btn btn-warning">블라인드</button></td>
					<td><button type="button" class="btn btn-danger">이용정지</button></td>
				</tr>
			</tbody>
		</table>
	</div>


	<div class="ce_admin_report_form my-3">
		<form>
			<div class="form-row">
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control" name="target">
						<option value="both">제목+내용</option>
						<option value="title">제목</option>
						<option value="nickname">글쓴이</option>
						<option value="content">내용</option>
					</select>
				</div>
				<div class="form-group col-xl-9">
					<input type="text" class="form-control" placeholder="검색" name="query">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-dark">검색</button>
				</div>
			</div>
		</form>
	</div>


	<div class="ce_admin_report_pagination">
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