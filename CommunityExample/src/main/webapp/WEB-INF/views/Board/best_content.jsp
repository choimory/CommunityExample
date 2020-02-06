<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>




<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="board_info mb-5">
		<span class="h3 mr-2">
			<a href="/communityexample/${boardTypeDto.bId}" class="text-dark text-decoration-none">${boardTypeDto.bIdKor}</a>
		</span>
		<span class="ce_bookmark">
			<c:choose>
				<c:when test="${isBookmarkedBoard eq 1}">
					<a id="bookmark_board" href="javascript:void(0);" onclick="unBookmarkBoard('${memberDto.mId}','${boardTypeDto.bType}','${boardTypeDto.bId}','${boardTypeDto.bTypeKor}','${boardTypeDto.bIdKor}');" class="text-decoration-none text-warning">
						<i class="fas fa-bookmark fa-2x"></i>
					</a>
				</c:when>
				<c:otherwise>
					<a id="bookmark_board" href="javascript:void(0);" onclick="bookmarkBoard('${memberDto.mId}','${boardTypeDto.bType}','${boardTypeDto.bId}','${boardTypeDto.bTypeKor}','${boardTypeDto.bIdKor}');" class="text-decoration-none text-warning">
						<i class="far fa-bookmark fa-2x"></i>
					</a>
				</c:otherwise>
			</c:choose>
		</span>
		<span class="blockquote-footer">${boardTypeDto.bIntroduce}</span>
	</div>


	<div class="ce_board_content mb-5 pb-5">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col" colspan="2">${boardDto.bTitle}</th>
				</tr>
			</thead>
			<tbody>
				<tr class="font-weight-light">
					<td class="text-left">
						<img src="${iconPath}/0.png" width="15" height="15" class="mx-1" alt="">
						<small>${boardDto.mNickname}</small>
					</td>
					<td class="text-md-right">
						<small>
							<i class="far fa-eye mx-1"></i>${boardDto.boardInfoDto.bHit}
							<i class="far fa-calendar-alt mx-1"></i>${boardDto.bRegDate}
							<i class="far fa-thumbs-up mx-1"></i>${boardDto.boardInfoDto.bUpvote-boardDto.boardInfoDto.bDownvote}
						</small>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="ce_board_article py-4 my-4">${boardDto.bContent}</div>

						<div class="ce_board_btn text-center">
							<div class="ce_board_thumbs my-2">
								<button class="btn btn-light" id="board_article_thumbsup" onclick="thumbsUpArticle('${memberDto.mId}','${boardDto.bId}','${boardDto.bIdx}');">
									${boardDto.boardInfoDto.bUpvote}
									<i class="far fa-thumbs-up fa-2x mx-2"></i>
								</button>
								<c:choose>
									<c:when test="${isBookmarkedArticle eq 1}">
										<button type="button" class="btn btn-danger" id="bookmark_article" onclick="unBookmarkArticle('${memberDto.mId}','${boardDto.bId}','${boardDto.bIdx}');" class="text-danger text-decoration-none">
											<i class="fas fa-heart fa-2x mx-2"></i>
										</button>
									</c:when>
									<c:otherwise>
										<button type="button" class="btn btn-outline-danger" id="bookmark_article" onclick="bookmarkArticle('${memberDto.mId}','${boardDto.bId}','${boardDto.bIdx}');" class="text-danger text-decoration-none">
											<i class="fas fa-heart fa-2x mx-2"></i>
										</button>
									</c:otherwise>
								</c:choose>
								<button type="button" class="btn btn-light" id="board_article_thumbsdown" onclick="thumbsDownArticle('${memberDto.mId}','${boardDto.bId}','${boardDto.bIdx}');">
									<i class="far fa-thumbs-down fa-2x mx-2"></i>${boardDto.boardInfoDto.bDownvote}</button>
							</div>
							<div class="ce_board_page my-2">
								<a href="" class="text-dark text-decoration-none">
									<i class="fas fa-caret-left fa-2x mx-2"></i>
								</a>
								<a href="/communityexample/${boardDto.bId}?page=${pageHelper.page}" class="text-success text-decoration-none">
									<i class="fas fa-list fa-2x mx-2"></i>
								</a>
								<a href="" class="text-dark text-decoration-none">
									<i class="fas fa-caret-right fa-2x mx-2"></i>
								</a>
							</div>
						</div>
					</td>
				</tr>

				<tr>
					<td class="text-right" colspan="2">
						<button type="button" class="btn btn-light" data-toggle="modal" data-target="#exampleModal">
							<i class="fas fa-paperclip fa-2x mx-2"></i>
						</button>
						<button type="button" class="btn btn-light">
							<i class="fas fa-share-alt fa-2x mx-2"></i>
						</button>
						<button type="button" class="btn btn-light" onclick="reportArticle('${memberDto.mId}','${boardTypeDto.bType}','${boardDto.bId}',${boardDto.bIdx});">
							<i class="far fa-flag fa-2x mx-2"></i>
						</button>
					</td>
				</tr>
				<c:if test="${boardDto.mId eq memberDto.mId}">
					<tr>
						<td class="text-right" colspan="2">
							<button type="button" class="btn btn-light" id="btn_modify" onclick="modifyArticle('${memberDto.mId}','${boardDto.mId}','${boardDto.bId}','${boardDto.bIdx}');">
								<i class="fas fa-eraser fa-2x mx-2"></i>
							</button>
							<button type="button" class="btn btn-light" id="btn_delete" onclick="deleteArticle('${boardDto.bId}','${boardDto.bIdx}');">
								<i class="far fa-trash-alt fa-2x mx-2"></i>
							</button>
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
	</div>

	<div class="ce_board_comment_list">
		<small>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col" colspan="2">
							<i class="far fa-comment-dots mx-1"></i>
							댓글(${boardDto.boardInfoDto.bCommentNum})
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardCommentDtoList}" var="boardCommentDto">
						<c:choose>
							<c:when test="${boardCommentDto.boardCommentInfoDto.bcNotice  eq 1}"></c:when>
							<c:when test="${boardCommentDto.boardCommentInfoDto.bcBest  eq 1}"></c:when>
							<c:when test="${boardCommentDto.boardCommentInfoDto.bcBlind  eq 1}"></c:when>
							<c:when test="${boardCommentDto.bcStep ne 0}">
								<tr class="table-active">
									<td class="py-2 pl-md-5">
										<img src="${iconPath}/0.png" width="15" height="15" class="mx-1" alt="">${boardCommentDto.mNickname}
										<c:if test="">
											<a href="" class="text-body text-decoration-none">
												<i class="fas fa-reply ml-1"></i>
											</a>
											<c:if test="">
												<a href="" class="text-body text-decoration-none">
													<i class="fas fa-eraser ml-1"></i>
												</a>
												<a href="#" onclick="check(123);" class="text-body text-decoration-none" id="btn_comment_delete">
													<i class="far fa-trash-alt ml-1"></i>
												</a>
											</c:if>
										</c:if>
									</td>
									<td class="text-right py-2">
										<i class="far fa-calendar-alt mx-1 text-body"></i>${boardCommentDto.bcRegDate}
										<a href="" class="text-decoration-none text-info">
											<i class="far fa-thumbs-up mx-1"></i>
										</a>${boardCommentDto.boardCommentInfoDto.bcUpvote}<a href="" class="text-decoration-none text-danger">
											<i class="far fa-thumbs-down mx-1"></i>
										</a>${boardCommentDto.boardCommentInfoDto.bcDownvote}</td>
								</tr>
								<tr>
									<td colspan="2" class="py-3 pl-md-5">
										<mark class="text-muted">@답글대상(이거 어케 변경해야할지)</mark>
										${boardCommentDto.bcContent}
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr class="table-active">
									<td class="py-2">
										<img src="${iconPath}/0.png" width="15" height="15" class="mx-1" alt="">${boardCommentDto.mNickname}
										<a href="javascript:void(0);" onclick="replyComment();" id="comment_reply" class="text-decoration-none text-info mx-2">
											<i class="far fa-comment-dots"></i>
										</a>
										<a href="javascript:void(0);" onclick="deleteComment();" id="delete_comment" class="text-decoration-none text-danger">
											<i class="far fa-trash-alt"></i>
										</a>
									</td>
									<td class="text-right py-2">
										<i class="far fa-calendar-alt mx-1 text-body"></i>
										<span id="comment_regdate" class="mr-1">${boardCommentDto.bcRegDate}</span>
										<a href="javascript:void(0);" onclick="thumbsUpComment('${memberDto.mId}','${boardDto.bId}','${boardCommentDto.bcIdx}');" id="comment_thumbsUp" class="text-decoration-none text-info">
											<i class="far fa-thumbs-up mx-1"></i>
										</a>
										<span id="comment_upvote_${boardCommentDto.bcIdx}" class="mr-1">${boardCommentDto.boardCommentInfoDto.bcUpvote}</span>
										<a href="javascript:void(0);" onclick="thumbsDownComment('${memberDto.mId}','${boardDto.bId}','${boardCommentDto.bcIdx}');" id="comment_thumbsDown" class="text-decoration-none text-danger">
											<i class="far fa-thumbs-down mx-1"></i>
										</a>
										<span id="comment_downvote_${boardCommentDto.bcIdx}">${boardCommentDto.boardCommentInfoDto.bcDownvote}</span>
									</td>
								</tr>
								<tr>
									<td colspan="2" class="py-3">${boardCommentDto.bcContent}</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</small>
	</div>

	<div class="ce_board_comment_form text-center">
		<form action="/communityexample/comment/write" method="post">
			<div class="form-row">
				<div class="form-group form-check">
					<input type="checkbox" class="form-check-input" name="bcNotice" value="1">
					<label class="form-check-label" for="exampleCheck1">댓글 공지사항으로 작성</label>
				</div>
				<div class="form-group col-xl-11">
					<input type="text" class="form-control" placeholder="댓글입력" name="bcContent">
				</div>
				<input type="hidden" name="bId" value="${boardDto.bId}">
				<input type="hidden" name="bIdx" value="${boardDto.bIdx}">
				<input type="hidden" name="mId" value="${memberDto.mId}">
				<input type="hidden" name="mNickname" value="${memberDto.mNickname}">
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">작성</button>
				</div>
			</div>
		</form>
	</div>


	<div id="ce_comment_pagination" class="ce_comment_pagination">
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<li class="page-item">
					<a class="page-link" aria-label="Previous" href="javascript:void(0);" onclick="comment('${boardDto.bId}','${boardDto.bIdx}','${commentPageHelper.page-1}');">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				<c:forEach items="${commentPageHelper.pageGroup}" var="page">
					<c:choose>
						<c:when test="${commentPageHelper.page eq page}">
							<li class="page-item active">
								<a class="page-link" href="javascript:void(0);" onclick="comment('${boardDto.bId}','${boardDto.bIdx}','${page}');">${page}</a>
							</li>
						</c:when>
						<c:otherwise>
							<li class="page-item">
								<a class="page-link" href="javascript:void(0);" onclick="comment('${boardDto.bId}','${boardDto.bIdx}','${page}');">${page}</a>
							</li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li class="page-item">
					<a class="page-link" aria-label="Next" href="javascript:void(0);" onclick="comment('${boardDto.bId}','${boardDto.bIdx}','${commentPageHelper.page+1}');">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul>
		</nav>
	</div>



	<div class="board_info mt-5 pt-5">
		<span class="h3 mr-2">
			<a href="/communityexample/${boardTypeDto.bId}" class="text-dark text-decoration-none">${boardTypeDto.bIdKor}</a>
		</span>
		<span class="ce_bookmark">
			<c:choose>
				<c:when test="${isBookmarkedBoard eq 1}">
					<a id="bookmark_board" href="javascript:void(0);" onclick="unBookmarkBoard('${memberDto.mId}','${boardTypeDto.bType}','${boardTypeDto.bId}','${boardTypeDto.bTypeKor}','${boardTypeDto.bIdKor}');" class="text-decoration-none text-warning">
						<i class="fas fa-bookmark fa-2x"></i>
					</a>
				</c:when>
				<c:otherwise>
					<a id="bookmark_board" href="javascript:void(0);" onclick="bookmarkBoard('${memberDto.mId}','${boardTypeDto.bType}','${boardTypeDto.bId}','${boardTypeDto.bTypeKor}','${boardTypeDto.bIdKor}');" class="text-decoration-none text-warning">
						<i class="far fa-bookmark fa-2x"></i>
					</a>
				</c:otherwise>
			</c:choose>
		</span>
		<span class="blockquote-footer">${boardTypeDto.bIntroduce}</span>


		<div class="ce_board_list_category mt-3">
			<c:forEach items="${boardCategoryList}" var="boardCategory">
				<button type="button" class="btn btn-info mb-1" onclick="location.href='/communityexample/${boardTypeDto.bId}?bCategory=${boardCategory}'">${boardCategory}</button>
			</c:forEach>
		</div>


		<div class="ce_board_list my-2 table-responsive text-nowrap" style="font-size: 14px;">
			<table class="table text-center table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">게시판</th>
						<th scope="col" class="w-75">제목</th>
						<th scope="col">글쓴이</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
						<th scope="col">추천수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardDtoList}" var="boardDto2">
						<tr>
							<td>${boardDto2.boardTypeDto.bIdKor}</td>
							<c:choose>
								<c:when test="${searchHelper.query ne null}">
									<c:choose>
										<c:when test="${boardDto.bIdx eq boardDto2.bIdx}">
											<td>
												<a class="text-info" href="/communityexample/${boardTypeDto.bId}/${boardDto2.bIdx}?bId=${boardDto2.bId}&query=${searchHelper.query}&title=${searchHelper.target}">${boardDto2.bTitle}
													<span class="badge badge-info mx-1">${boardDto2.boardInfoDto.bCommentNum}</span>
												</a>
											</td>
										</c:when>
										<c:otherwise>
											<td>
												<a class="text-dark" href="/communityexample/${boardTypeDto.bId}/${boardDto2.bIdx}?bId=${boardDto2.bId}&query=${searchHelper.query}&title=${searchHelper.target}">${boardDto2.bTitle}
													<span class="badge badge-info mx-1">${boardDto2.boardInfoDto.bCommentNum}</span>
												</a>
											</td>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${boardDto.bIdx eq boardDto2.bIdx}">
											<td>
												<a class="text-info" href="/communityexample/${boardTypeDto.bId}/${boardDto2.bIdx}?bId=${boardDto2.bId}&query=${searchHelper.query}&title=${searchHelper.target}">${boardDto2.bTitle}
													<span class="badge badge-info mx-1">${boardDto2.boardInfoDto.bCommentNum}</span>
												</a>
											</td>
										</c:when>
										<c:otherwise>
											<td>
												<a class="text-dark" href="/communityexample/${boardTypeDto.bId}/${boardDto2.bIdx}?bId=${boardDto2.bId}">${boardDto2.bTitle}
													<span class="badge badge-info mx-1">${boardDto2.boardInfoDto.bCommentNum}</span>
												</a>
											</td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							<td>
								<a class="text-decoration-none text-dark" href="/communityexample/search?mNickname=">
									<img src="${iconPath}/0.png" width="15" height="15" class="mx-1" alt="">${boardDto2.mNickname}
								</a>
							</td>
							<td>${boardDto2.bRegDate}</td>
							<td>${boardDto2.boardInfoDto.bHit}</td>
							<td>${boardDto2.boardInfoDto.bUpvote-boardInfoDto.bDownvote}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<div class="ce_board_list_form text-center">
			<form action="/communityexample/${boardTypeDto.bId}">
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
						<button type="submit" class="btn btn-info">검색</button>
					</div>
				</div>
			</form>
		</div>


		<div class="ce_board_list_pagination">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<li class="page-item">
						<a class="page-link" href="/communityexample/${boardTypeDto.bId}?page=${pageHelper.page-1}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					<c:forEach items="${pageHelper.pageGroup}" var="page">
						<c:choose>
							<c:when test="${pageHelper.page eq page}">
								<li class="page-item active">
									<a class="page-link" href="/communityexample/${boardTypeDto.bId}?page=${page}">${page}</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a class="page-link" href="/communityexample/${boardTypeDto.bId}?page=${page}">${page}</a>
								</li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<li class="page-item">
						<a class="page-link" href="/communityexample/${boardTypeDto.bId}?page=${pageHelper.page+1}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>>



<!-- file download modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					<i class="fas fa-paperclip mx-2"></i>
					첨부파일
				</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<c:forEach items="${boardDto.boardFileDtoList}" var="boardFileDto">
					<i class="fas fa-paperclip mx-1"></i>
					<a href="/communityexample/${boardDto.bId}/${boardDto.bIdx}/download?fIdx=${boardFileDto.fIdx}&fName=${boardFileDto.fOriginalName}">${boardFileDto.fOriginalName}</a>
					<br>
				</c:forEach>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
