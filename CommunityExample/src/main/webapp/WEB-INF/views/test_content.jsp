<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="test_header.jsp"%>
<div class="container bg-white col-lg-8 p-4">

	<!-- start of content -->
	<div class="board_info mb-5">
		<span class="h3 mr-2">게시판 명</span> <span class="ce_bookmark"> <c:choose>
				<c:when test="${title eq null}">
					<i class="fas fa-bookmark fa-2x"></i>
				</c:when>
				<c:otherwise>
					<i class="far fa-bookmark fa-2x"></i>
				</c:otherwise>
			</c:choose>
		</span> <span class="blockquote-footer">게시판 설명</span>
	</div>

	<div class="board_category">
		<button type="button" class="btn btn-info mb-1">Info</button>
		<button type="button" class="btn btn-info mb-1">Info</button>
		<button type="button" class="btn btn-info mb-1">Info</button>
		<button type="button" class="btn btn-info mb-1">Info</button>
		<button type="button" class="btn btn-info mb-1">Info</button>
	</div>

	<div class="board my-2">
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

	<div class="board_form"></div>

	<div class="board_pagination">
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
<%@ include file="test_footer.jsp"%>
