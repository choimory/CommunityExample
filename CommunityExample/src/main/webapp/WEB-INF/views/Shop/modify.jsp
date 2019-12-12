<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_shop_main_title mb-5 pb-5">
		<span class="h3 mr-2"><a href="/communityexample/shop"
			class="text-dark text-decoration-none">게시물 수정<i
				class="fas fa-store-alt mx-1 text-warning"></i></a></span> <span
			class="blockquote-footer">아이콘 혹은 프로필 제목과 내용을 수정할 수 있습니다.</span>
	</div>


	<div class="ce_shop_write_form">
		<form action="/communityexample/shop/modify" method="post">
			<div class="row my-2">
				<div class="col-xl-2 mb-2">
					<select class="form-control" name="sType"><option value="icon">아이콘</option>
						<option value="profile">프로필</option></select>
				</div>
				<div class="form-group col-xl-10">
					<input type="text" class="form-control" placeholder="제목" name="sTitle" value="">
				</div>
			</div>
			<div class="form-group my-2">
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="10" placeholder="내용" name="sContent" value=""></textarea>
			</div>
			<div class="form-group my-2 text-right">
				<button type="submit" class="btn btn-info">작성</button>
				<button type="button" class="btn btn-danger" onclick="location.href='/communityexample/shop'">취소</button>
			</div>
		</form>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>