<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_admin_shop_title mb-5">
		<h3 class="h3 text-center">판매 검토</h3>
	</div>


	<div class="ce_admin_shop_content table-responsive text-nowrap">
			<table class="table text-center">
				<thead class="thead-light">
					<tr>
						<th scope="col">아이템</th>
						<th scope="col">제목</th>
						<th scope="col">글쓴이</th>
						<th scope="col">조회수</th>
						<th scope="col">추천수</th>
						<th scope="col">판매허가</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><a class="" href=""><img src="${iconPath}/lol.png"
								height="50" weight="50"></a></td>
						<td><a class="text-center text-info" href="/communityexample/shop/${shop_index}">목제목제목제목제목제목목제목제목제목제목제목</a></td>
						<td>Otto</td>
						<td>Mark</td>
						<td>Otto</td>
						<td><button type="button" class="btn btn-success">수락</button>
							<button type="button" class="btn btn-danger">거절</button></td>
					</tr>
				</tbody>
			</table>
		</div>


	<div class="ce_admin_shop_form my-3">
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