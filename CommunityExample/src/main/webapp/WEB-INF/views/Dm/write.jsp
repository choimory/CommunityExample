<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_dm_info mb-5">
		<a class="text-decoration-none text-dark" href="/communityexample/dm"><span
			class="h3 mr-2">쪽지</span> <span class="text-info"><i
				class="far fa-envelope-open fa-2x"></i></span></a> <span
			class="blockquote-footer">쪽지 보내기</span>
	</div>

	<div class="ce_dm_write_form">
		<form action="/communityexample/dm/write" method="post" enctype="multipart/form-data">
			<div class="form-group my-2">
				<input type="text" class="form-control" placeholder="받을사람" name="dmReceiverNickname">
			</div>
			<div class="form-group my-2">
				<input type="text" class="form-control" placeholder="제목" name="dmTitle">
			</div>
			<div class="form-group my-2">
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="10" placeholder="내용" name="dmContent"></textarea>
			</div>
			<div class="form-group my-2">
				<input type="file" name="file" class="form-control-file">
			</div>
			<input type="hidden" name="dmSenderId" value="${memberDto.mId}">
			<input type="hidden" name="dmSenderNickname" value="${memberDto.mNickname}">
			
			<div class="form-group my-2 text-right">
				<button type="submit" class="btn btn-info">작성</button>
				<button type="button" class="btn btn-danger" onclick="location.href=''">취소</</button>
			</div>
		</form>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
