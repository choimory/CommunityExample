<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">


	<!-- start of content -->
	<div class="ce_shop_list_title mb-5">
		<span class="h3 mr-2">프로필</span> <span class="ce_btn float-right"><button type="button" class="btn btn-light btn-sm mx-1">최신순</button><button type="button" class="btn btn-light btn-sm mx-1">업로드</button></span> <span
			class="blockquote-footer">게시판 설명</span>
	</div>
	
	
	<div class="ce_shop_list_form text-center">
		<form>
			<div class="form-row">
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control">
						<option selected>분류</option>
						<option>...</option>
					</select>
				</div>
				<div class="form-group col-xl-2">
					<select id="inputState" class="form-control">
						<option selected>제목+내용</option>
						<option>...</option>
					</select>
				</div>
				<div class="form-group col-xl-6">
					<input type="text" class="form-control" placeholder="검색">
				</div>
				<div class="form-group col-xl-1">
					<button type="submit" class="btn btn-info">검색</button>
				</div>
				<div class="form-group col-xl-1">
					<button type="button" class="btn btn-info">작성</button>
				</div>
			</div>
		</form>
	</div>
	
	
	<div class="ce_shop_list_profile mb-5">
		<div class="card-columns">
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title that wraps to a new line</h5>
					<p class="card-text">This is a longer card with supporting text
						below as a natural lead-in to additional content. This content is
						a little bit longer.</p>
				</div>
			</div>
			<div class="card p-3">
				<blockquote class="blockquote mb-0 card-body">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Integer posuere erat a ante.</p>
					<footer class="blockquote-footer">
						<small class="text-muted"> Someone famous in <cite
							title="Source Title">Source Title</cite>
						</small>
					</footer>
				</blockquote>
			</div>
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This card has supporting text below as a
						natural lead-in to additional content.</p>
					<p class="card-text">
						<small class="text-muted">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>
			<div class="card bg-primary text-white text-center p-3">
				<blockquote class="blockquote mb-0">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Integer posuere erat.</p>
					<footer class="blockquote-footer text-white">
						<small> Someone famous in <cite title="Source Title">Source
								Title</cite>
						</small>
					</footer>
				</blockquote>
			</div>
			<div class="card text-center">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This card has a regular title and short
						paragraphy of text below it.</p>
					<p class="card-text">
						<small class="text-muted">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>
			<div class="card">
				<img src="..." class="card-img-top" alt="...">
			</div>
			<div class="card p-3 text-right">
				<blockquote class="blockquote mb-0">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Integer posuere erat a ante.</p>
					<footer class="blockquote-footer">
						<small class="text-muted"> Someone famous in <cite
							title="Source Title">Source Title</cite>
						</small>
					</footer>
				</blockquote>
			</div>
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This is another card with title and
						supporting text below. This card has some additional content to
						make it slightly taller overall.</p>
					<p class="card-text">
						<small class="text-muted">Last updated 3 mins ago</small>
					</p>
				</div>
			</div>
		</div>
	</div>


	<div class="ce_shop_list_icon_scroll text-center mb-5">
		<i class="fas fa-arrow-down fa-3x text-center"></i>
	</div>
	<!-- end of content -->

</div>
<%@ include file="../include/footer.jsp"%>
