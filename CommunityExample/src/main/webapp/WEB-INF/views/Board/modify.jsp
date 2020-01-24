<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="board_info mb-5 pb-5">
		<span class="h3 mr-2"><a href="/communityexample/${boardDto.bId}"
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
		<form action="/communityexample/${boardDto.bId}/modify" method="post">
			<div class="row my-2">
				<div class="col-xl-2 mb-2">
					<select class="form-control" name="bCategory">
						<c:forEach items="${boardCategoryList}" var="bCategory" >
							<option value="${bCategory}">${bCategory}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group col-xl-10">
					<input type="text" class="form-control" placeholder="제목"
						name="bTitle" value="${boardDto.bTitle}">
				</div>
			</div>
			<div class="form-group my-2">
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="10" placeholder="내용" name="bContent">${boardDto.bContent}</textarea>
			</div>
			<div class="form-group my-2">
				<input type="file" class="form-control-file">
			</div>
			<div class="form-group my-2 text-right">
				<button type="submit" class="btn btn-info">작성</button>
				<button type="button" class="btn btn-danger"
					onclick="location.href='/communityexample/${boardDto.bId}'">취소</</button>
			</div>
			<input type="hidden" name="bIdx" value="${boardDto.bIdx}">
		</form>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
