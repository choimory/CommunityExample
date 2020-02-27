<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4" style="font-size: 14px;">


	<!-- start of content -->
	<div class="row my-3">
		<div class="col-lg-6 col-md-12 text-truncate">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">
							<a class="text-decoration-none text-light" href="/communityexample/best">BEST게시판</a>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bestMap.best}" var="dto">
						<tr>
							<td>
								<a class="text-decoration-none text-info" href="/communityexample/best/${dto.bIdx}?bId=${dto.bId}">${dto.bTitle}<span class="badge badge-info mx-1">${dto.boardInfoDto.bCommentNum}</span>
								</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-lg-6 col-md-12 text-truncate">
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col">
							<a class="text-decoration-none text-dark" href="/communityexample/humor">유머</a>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bestMap.humor}" var="dto">
						<tr>
							<td>
								<a class="text-decoration-none text-info" href="/communityexample/humor/${dto.bIdx}">${dto.bTitle}<span class="badge badge-info mx-1">${dto.boardInfoDto.bCommentNum}</span></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="table mb-lg-0">
				<thead class="thead-light">
					<tr>
						<th scope="col">
							<a class="text-decoration-none text-dark" href="/communityexample/issue">이슈</a>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bestMap.issue}" var="dto">
						<tr>
							<td>
								<a class="text-decoration-none text-info" href="/communityexample/issue/${dto.bIdx}">${dto.bTitle}<span class="badge badge-info mx-1">${dto.boardInfoDto.bCommentNum}</span></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>


	<div class="row my-3">
		<c:forEach items="${otherMap}" var="entry">
			<c:set value="${entry.value}" var="dtoList" />
			<div class="col-lg-6 col-md-12 text-truncate">
				<table class="table mb-lg-0">
					<thead class="thead-light">
						<tr>
							<th scope="col">
								<c:choose>
									<c:when test="${dtoList[0] eq null}">
										<a class="text-decoration-none text-dark" href="/communityexample/${entry.key}">${entry.key}</a>
									</c:when>
									<c:otherwise>
										<a class="text-decoration-none text-dark" href="/communityexample/${entry.key}">${dtoList[0].boardTypeDto.bIdKor}</a>
									</c:otherwise>
								</c:choose>
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${entry.value}" var="dto">
							<tr>
								<td>
									<a class="text-decoration-none text-info" href="/communityexample/${entry.key}/${dto.bIdx}">${dto.bTitle}<span class="badge badge-info mx-1">${dto.boardInfoDto.bCommentNum}</span></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</div>


	<!-- end of content -->


</div>
<%@ include file="../include/footer.jsp"%>