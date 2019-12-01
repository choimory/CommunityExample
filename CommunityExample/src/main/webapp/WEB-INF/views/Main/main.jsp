<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>

<!-- start of content -->
<div class="container bg-white col-lg-8 p-4">

	<div class="row my-3">	
		<div class="col-lg-6 col-md-12">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">BEST게시판</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="9" varStatus="var">
						<tr>
							<td>${var.count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		
		<div class="col-lg-6 col-md-12">
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col">게시판1</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="4" varStatus="var">
						<tr>
							<td>${var.count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col">게시판2</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="4" varStatus="var">
						<tr>
							<td>${var.count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>		
	</div>


	<div class="row my-3">
		<div class="col-lg-6 col-md-12">
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col">게시판3</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="4" varStatus="var">
						<tr>
							<td>${var.count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		
		<div class="col-lg-6 col-md-12">
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col">게시판4</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="4" varStatus="var">
						<tr>
							<td>${var.count}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>		
	</div>	
</div>
<!-- end of content -->


<%@ include file="../include/footer.jsp"%>