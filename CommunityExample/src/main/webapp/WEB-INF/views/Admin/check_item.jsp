<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_admin_shop_title mb-5">
		<h3 class="h3 text-center">판매 검토</h3>
	</div>


	<div class="ce_alert">
		<c:choose>
			<c:when test="${result eq 1}">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					<strong>작업성공</strong> 정상적으로 처리되었습니다.
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:when>
			<c:when test="${result eq -1}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					<strong>작업실패</strong> 요청한 작업을 처리하는데 실패했습니다.
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:when>
		</c:choose>
	</div>

	<div class="ce_admin_shop_content table-responsive text-nowrap">
		<table class="table text-center">
			<thead class="thead-light">
				<tr>
					<th scope="col">아이템</th>
					<th scope="col" class="w-100">제목</th>
					<th scope="col">글쓴이</th>
					<th scope="col">조회수</th>
					<th scope="col">추천수</th>
					<th scope="col">판매허가</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a class="" href="/communityexample/shop/${shopDto.sIdx}"><img
							src="" height="50" weight="50"></a></td>
					<td><a class="text-center text-info"
						href="/communityexample/shop/${shopDto.sIdx}">{shopDto.sTitle}</a></td>
					<td>{shopDto.mNickname}</td>
					<td>{shopDto.shopInfoDto.sHit}</td>
					<td>{shopDto.shopInfoDto.sUpvote}</td>
					<td><button type="button" class="btn btn-success"
							onclick="permission(${shopDto.sIdx},1);">수락</button>
						<button type="button" class="btn btn-danger"
							onclick="permission(${shopDto.sIdx},0);">거절</button></td>
				</tr>
				<c:forEach items="${shopDtoList}" var="shopDto">
					<tr>
						<td><a class="" href="/communityexample/shop/${shopDto.sIdx}"><img
								src="" height="50" weight="50"></a></td>
						<td><a class="text-center text-info"
							href="/communityexample/shop/${shopDto.sIdx}">${shopDto.sTitle}</a></td>
						<td>${shopDto.mNickname}</td>
						<td>${shopDto.shopInfoDto.sHit}</td>
						<td>${shopDto.shopInfoDto.sUpvote}</td>
						<td><button type="button" class="btn btn-success"
								onclick="permission(${shopDto.sIdx},1);">수락</button>
							<button type="button" class="btn btn-danger"
								onclick="permission(${shopDto.sIdx},0);">거절</button></td>
					</tr>
				</c:forEach>
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
					<input type="text" class="form-control" placeholder="검색"
						name="query">
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
				<c:forEach items="${pageHelper.pageGroup}" var="page">
					<li class="page-item"><a class="page-link"
						href="/communityexample/admin/check_item?page=1"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="/communityexample/admin/check_item?page=${pageHelper.page}">${page}</a>
					<li class="page-item"><a class="page-link"
						href="/communityexample/admin/check_item?page=${pageHelper.totalPage}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>