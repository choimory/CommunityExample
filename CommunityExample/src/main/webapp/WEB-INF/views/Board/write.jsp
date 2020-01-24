<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="board_info mb-5 pb-5">
		<span class="h3 mr-2"><a href="/communityexample/${boardTypeDto.bId}"
			class="text-dark text-decoration-none">${boardTypeDto.bIdKor}</a></span> <span
			class="ce_bookmark"> <c:choose>
				<c:when test="${title eq null}">
					<a href="" class="text-decoration-none text-warning"><i
						class="fas fa-bookmark fa-2x"></i></a>
				</c:when>
				<c:otherwise>
					<a href="" class="text-decoration-none text-warning"><i
						class="far fa-bookmark fa-2x"></i></a>
				</c:otherwise>
			</c:choose>
		</span> <span class="blockquote-footer">${boardTypeDto.bIntroduce}</span>
	</div>


	<div class="ce_board_write_form">
		<form action="/communityexample/${bId}/write" method="post">
			<div class="row my-2">
				<div class="col-xl-2 mb-2">
					<select class="form-control" name="bCategory">
						<c:forEach items="${boardCategoryList}" var="var" >
							<option value="${var}">${var}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-xl-10">
					<input type="text" class="form-control" placeholder="제목" name="bTitle">
				</div>
			</div>
			<div class="form-group my-2">
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="10" placeholder="내용" name="bContent"></textarea>
			</div>
			<input type="hidden" name="mId"	value="${memberDto.mId}">
			<input type="hidden" name="mNickname" value="${memberDto.mNickname}">
			<div class="form-group my-2">
				<input type="file" class="form-control-file">
			</div>
			<div class="form-group my-2 text-right">
				<button type="submit" class="btn btn-info">작성</button>
				<button type="button" class="btn btn-danger" onclick="location.href='/communityexample/${bId}'">취소</</button>
			</div>
		</form>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
