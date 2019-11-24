<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="board_info mb-5">
	<span class="h3 mr-2">게시판 명</span> <span class="ce_bookmark"> <c:choose>
			<c:when test="${title eq null}">
				<i class="fas fa-bookmark fa-2x"></i>
			</c:when>
			<c:otherwise>
				<i class="far fa-bookmark fa-2x"></i>
			</c:otherwise>
		</c:choose>
	</span> <span class="blockquote-footer">게시판 설명</span>
</div>