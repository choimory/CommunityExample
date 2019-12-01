<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_dm_info mb-5">
		<span class="h3 mr-2">쪽지</span> <span class="blockquote-footer">게시판
			설명</span>
	</div>
	
	<div class="ce_dm_write_form">
		<form>
			<div class="form-group my-2">
				<input type="text" class="form-control" placeholder="받을사람">
			</div>
			<div class="form-group my-2">
				<input type="text" class="form-control" placeholder="제목">
			</div>
			<div class="form-group my-2">
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="10" placeholder="내용"></textarea>
			</div>
			<div class="form-group my-2">
				<input type="file" class="form-control-file">
			</div>
			<div class="form-group my-2 text-right">
				<button type="submit" class="btn btn-info">작성</button>
				<button type="button" class="btn btn-danger" location.href="">취소</</button>
			</div>
		</form>
	</div>	
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
