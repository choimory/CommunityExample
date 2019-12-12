<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="board_info mb-5 pb-5">
		<span class="h3 mr-2"><a href="/communityexample/${board_id}"
			class="text-dark text-decoration-none">${board_id}</a></span> <span
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
		</span> <span class="blockquote-footer">저작자·발명가·과학기술자와 예술가의 권리는 법률로써
			보호한다. 법원은 최고법원인 대법원과 각급법원으로 조직된다. 모든 국민은 소급입법에 의하여 참정권의 제한을 받거나 재산권을
			박탈당하지 아니한다. 국회는 국정을 감사하거나 특정한 국정사안에 대하여 조사할 수 있으며, 이에 필요한 서류의 제출 또는
			증인의 출석과 증언이나 의견의 진술을 요구할 수 있다.</span>
	</div>


	<div class="ce_board_write_form">
		<form action="/communityexample/${bId}/modify" method="post">
			<div class="row my-2">
				<div class="col-xl-2 mb-2">
					<select class="form-control" name="bCategory">
						<option selected value="잡담">잡담</option>
						<option value="질문">질문</option>
						<option>...</option></select>
				</div>
				<div class="form-group col-xl-10">
					<input type="text" class="form-control" placeholder="제목" name="bTitle" value="${bTitle}">
				</div>
			</div>
			<div class="form-group my-2">
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="10" placeholder="내용" name="bContent" value="${bContent}"></textarea>
			</div>
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
