<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">

	<!-- start of content -->
	<div class="board_info mb-5">
		<span class="h3 mr-2"> <a href="/communityexample/${boardTypeDto.bId}" class="text-dark text-decoration-none">${boardTypeDto.bIdKor}</a>
		</span> <span class="ce_bookmark"> <c:choose>
				<c:when test="${isBookmarkedBoard eq 1}">
					<a id="bookmark_board" href="javascript:void(0);" onclick="unBookmarkBoard('${memberDto.mId}','${boardTypeDto.bType}','${boardTypeDto.bId}','${boardTypeDto.bTypeKor}','${boardTypeDto.bIdKor}');" class="text-decoration-none text-warning"> <i class="fas fa-bookmark fa-2x"></i>
					</a>
				</c:when>
				<c:otherwise>
					<a id="bookmark_board" href="javascript:void(0);" onclick="bookmarkBoard('${memberDto.mId}','${boardTypeDto.bType}','${boardTypeDto.bId}','${boardTypeDto.bTypeKor}','${boardTypeDto.bIdKor}');" class="text-decoration-none text-warning"> <i class="far fa-bookmark fa-2x"></i>
					</a>
				</c:otherwise>
			</c:choose>
		</span> <span class="blockquote-footer">${boardTypeDto.bIntroduce}</span>
	</div>


	<div class="ce_board_list_category">
		<c:forEach items="${boardCategoryList}" var="boardCategory">
			<button type="button" class="btn btn-info mb-1" onclick="location.href='/communityexample/${boardTypeDto.bId}?bCategory=${boardCategory}'">${boardCategory}</button>
		</c:forEach>
	</div>


	<div class="ce_board_list my-2 table-responsive text-nowrap">
		<table class="table text-center table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">분류</th>
					<th scope="col" class="w-75">제목</th>
					<th scope="col">글쓴이</th>
					<th scope="col">작성일</th>
					<th scope="col">조회수</th>
					<th scope="col">추천수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardDtoList}" var="boardDto">
					<tr>
						<td>
							<a class="text-dark" href="/communityexample/${bId}?bCategory=${boardDto.bCategory}">${boardDto.bCategory}</a>
						</td>
						<c:choose>
							<c:when test="${searchHelper.query ne null}">
								<td>
									<a class="text-dark" href="/communityexample/${boardDto.bId}/${boardDto.bIdx}?query=${searchHelper.query}&title=${searchHelper.target}">${boardDto.bTitle} <span class="badge badge-info mx-1">${boardDto.boardInfoDto.bCommentNum}</span>
									</a>
								</td>
							</c:when>
							<c:when test="${searchHelper.bCategory ne 'all'}">
								<td>
									<a class="text-dark" href="/communityexample/${boardDto.bId}/${boardDto.bIdx}?bCategory=${searchHelper.bCategory}">${boardDto.bTitle} <span class="badge badge-info mx-1">${boardDto.boardInfoDto.bCommentNum}</span>
									</a>
								</td>
							</c:when>
							<c:otherwise>
								<td>
									<a class="text-dark" href="/communityexample/${boardDto.bId}/${boardDto.bIdx}">${boardDto.bTitle} <span class="badge badge-info mx-1">${boardDto.boardInfoDto.bCommentNum}</span>
									</a>
								</td>
							</c:otherwise>
						</c:choose>
						<td>
							<a class="text-decoration-none text-dark" href="/communityexample/search?mNickname="> <img src="${iconPath}/0.png" width="15" height="15" class="mx-1" alt="">${boardDto.mNickname}
							</a>
						</td>
						<td>${boardDto.bRegDate}</td>
						<td>${boardDto.boardInfoDto.bHit}</td>
						<td>${boardDto.boardInfoDto.bUpvote-boardInfoDto.bDownvote}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<div class="ce_board_list_form text-center">
		<form action="/communityexample/${bId}">
			<div class="form-row">
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control" name="bCategory">
						<option value="all">전체</option>
						<c:forEach items="${boardCategoryList}" var="bCategory">
							<option value="${bCategory}">${bCategory}</option>
						</c:forEach>
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
					<input type="text" class="form-control" placeholder="검색" name="query">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">검색</button>
				</div>
				<div class="form-group col-xl-1">
					<button type="button" class="btn btn-info" onclick="location.href='/communityexample/${bId}/write'">작성</button>
				</div>
			</div>
		</form>
	</div>

	<div class="ce_board_list_pagination">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="/communityexample/${boardTypeDto.bId}?page=${pageHelper.page-1}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach items="${pageHelper.pageGroup}" var="page">
					<c:choose>
						<c:when test="${pageHelper.page eq page}">
							<li class="page-item active"><a class="page-link" href="/communityexample/${boardTypeDto.bId}?page=${page}">${page}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="/communityexample/${boardTypeDto.bId}?page=${page}">${page}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li class="page-item"><a class="page-link" href="/communityexample/${boardTypeDto.bId}?page=${pageHelper.page+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
	<!-- end of content -->

</div>
<%@include file="../include/footer.jsp"%>