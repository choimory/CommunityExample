function check(variable) {
	alert("check");
}
function createForm(formName, formMethod, formAction) {
	var formVar = document.createElement("form");

	formVar.setAttribute("charset", "UTF-8");
	formVar.setAttribute("method", formMethod); // Post 방식
	formVar.setAttribute("action", formAction); // 요청 보낼 주소

	return formVar;
}

function createInput(formVar, inputType, inputName, inputValue) {
	var inputVar = document.createElement("input");

	inputVar.setAttribute("type", inputType); // 인풋타입정하기
	inputVar.setAttribute("name", inputName); // 인풋name정하기
	inputVar.setAttribute("value", inputValue); // 인풋값정하기

	formVar.appendChild(inputVar);

	return formVar;
}

function blind(bid, bidx) {
	var formVar = createForm("formname", "post",
			"/communityexample/admin/blind");
	formVar = createInput(formVar, "text", "bId", bid);
	formVar = createInput(formVar, "text", "bIdx", bidx);

	document.body.appendChild(formVar);
	formVar.submit();
}

function permission(sidx, permission) {
	var f = createForm("formname", "post", "/communityexample/admin/permission");
	f = createInput(f, "text", "sIdx", sidx);
	f = createInput(f, "text", "sPermission", permission);

	document.body.appendChild(f);
	f.submit();
}
function logout() {
	var f = createForm("formname", "post", "/communityexample/logout");

	document.body.appendChild(f);
	f.submit();
}
function idCheck() {
	var mId = $("#join_id").val();

	if (mId != null && mId != "") {
		$
				.ajax({
					async : true,
					type : "post",
					url : "/communityexample/id_check",
					contentType : "text/plain",
					data : mId,
					success : function(data) {
						if (data == 1) {
							$("#ce_alert")
									.html(
											"<div class='alert alert-success alert-dismissible fade show' role='alert'>	<strong>사용가능</strong> 해당 아이디는 사용하실 수 있습니다<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>	</button></div>");
							result[0] = 1;
							if (result[0] == 1 && result[1] == 1
									&& result[2] == 1) {
								$("#join_submit").removeAttr("disalbed");
							}
						} else {
							$("#ce_alert")
									.html(
											"<div class='alert alert-danger alert-dismissible fade show' role='alert'>	<strong>사용불가</strong> 해당 아이디는 사용하실 수 없습니다<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>	</button></div>");
							result[0] = -1;
							$("#join_submit").attr("disabled", "disabled");
						}
					},
					error : function(data) {
						$("#ce_alert")
								.html(
										"<div class='alert alert-warning alert-dismissible fade show' role='alert'>	<strong>죄송합니다</strong> 서버에 이상이 생겨 작업에 실패했습니다<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>	</button></div>");
						result[0] = -1;
						$("#join_submit").attr("disabled", "disabled");
					},
					complete : function(data) {
					}
				});
	}
}
function nicknameCheck() {
	var mNickname = $("#join_nickname").val();

	if (mNickname != null && mNickname != "") {
		$
				.ajax({
					async : true,
					type : "post",
					url : "/communityexample/nickname_check",
					contentType : "text/plain",
					data : mNickname,
					success : function(data) {
						if (data == 1) {
							$("#ce_alert")
									.html(
											"<div class='alert alert-success alert-dismissible fade show' role='alert'>	<strong>사용가능</strong> 사용하실 수 있습니다<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>	</button></div>");
							result[1] = 1;
							if (result[0] == 1 && result[1] == 1
									&& result[2] == 1) {
								$("#join_submit").removeAttr("disalbed");
							}
						} else {
							$("#ce_alert")
									.html(
											"<div class='alert alert-danger alert-dismissible fade show' role='alert'>	<strong>사용불가</strong> 사용하실 수 없습니다<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>	</button></div>");
							result[1] = -1;
							$("#join_submit").attr("disabled", "disabled");
						}
					},
					error : function(data) {
						$("#ce_alert")
								.html(
										"<div class='alert alert-warning alert-dismissible fade show' role='alert'>	<strong>죄송합니다</strong> 서버에 이상이 생겨 작업에 실패했습니다<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>	</button></div>");
						result[1] = -1;
						$("#join_submit").attr("disabled", "disabled");
					},
					complete : function(data) {
					}
				});
	}
}
function emailCheck() {
	var mEmail = $("#join_email").val();

	if (mEmail != null && mEmail != "") {
		$
				.ajax({
					async : true,
					type : "post",
					url : "/communityexample/email_check",
					contentType : "text/plain",
					data : mEmail,
					success : function(data) {
						if (data == 1) {
							$("#ce_alert")
									.html(
											"<div class='alert alert-success alert-dismissible fade show' role='alert'>	<strong>사용가능</strong> 사용하실 수 있습니다<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>	</button></div>");
							result[2] = 1;
							if (result[0] == 1 && result[1] == 1
									&& result[2] == 1) {
								$("#join_submit").removeAttr("disabled");
							}
						} else {
							$("#ce_alert")
									.html(
											"<div class='alert alert-danger alert-dismissible fade show' role='alert'>	<strong>사용불가</strong> 사용하실 수 없습니다<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>	</button></div>");
							result[2] = -1;
							$("#join_submit").attr("disabled", "disabled");
						}
					},
					error : function(data) {
						$("#ce_alert")
								.html(
										"<div class='alert alert-warning alert-dismissible fade show' role='alert'>	<strong>죄송합니다</strong> 서버에 이상이 생겨 작업에 실패했습니다<button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span>	</button></div>");
						result[2] = -1;
						$("#join_submit").attr("disabled", "disabled");
					},
					complete : function(data) {
					}
				});
	}
}
function modifyArticle(memberDtoId, boardDtoId, bId, bIdx) {
	if (memberDtoId == boardDtoId) {
		location.href = "/communityexample/" + bId + "/modify?bIdx=" + bIdx;
	} else {
		location.href = "/communityexample/main";
	}
}
function deleteArticle(bId, bIdx) {
	var f = createForm("formName", "post", "/communityexample/" + bId
			+ "/delete")
	f = createInput(f, "text", "bIdx", bIdx);

	document.body.appendChild(f);
	f.submit();
	alert("삭제되었습니다");
}
function replyComment() {
	alert();
}
function deleteComment() {
	alert();
}
function bookmarkBoard(mId, bType, bId, bTypeKor, bIdKor) {
	if (mId == null || mId == "") {
		alert("회원만 북마크 기능을 사용하실 수 있습니다");
	} else if (mId != null) {
		var bbdto = {
			mId : mId,
			bType : bType,
			bId : bId,
			bTypeKor : bTypeKor,
			bIdKor : bIdKor
		};

		$.ajax({
			async : true,
			type : "post",
			url : "http://localhost:8080/communityexample/bookmarkBoard",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(bbdto),
			dataType : "json",
			success : function(data) {
				if (data == -1) {
					alert("이미 북마크한 게시판입니다");
				} else if (data < -1 || data == 0) {
					alert("오류가 발생했습니다. (error code:" + data + ")");
				} else {
					$("#bookmark_board").html(
							'<i class="fas fa-bookmark fa-2x"></i>');
					$("#bookmark_board").removeAttr("onclick");
					$("#bookmark_board").attr(
							"onclick",
							"unBookmarkBoard('" + mId + "','" + bType + "','"
									+ bId + "','" + bTypeKor + "','" + bIdKor
									+ "')");

					// $("#bookmark_list").append("<a
					// href='/communityexample/abc' class='badge badge-secondary
					// mx-1'>abc</a>");
				}
			},
			error : function() {

			},
			complete : function() {

			}
		});
	}
}
function unBookmarkBoard(mId, bType, bId, bTypeKor, bIdKor) {
	if (mId == null || mId == "") {
		alert("회원만 북마크 기능을 사용하실 수 있습니다");
	} else if (mId != null) {
		var bbdto = {
			mId : mId,
			bType : bType,
			bId : bId,
			bTypeKor : bTypeKor,
			bIdKor : bIdKor
		};

		$.ajax({
			async : true,
			type : "post",
			url : "http://localhost:8080/communityexample/unBookmarkBoard",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(bbdto),
			dataType : "json",
			success : function(data) {
				if (data == -1) {
					alert("북마크된 게시판이 아닙니다");
				} else if (data < -1 || data == 0) {
					alert("오류가 발생했습니다. (error code:" + data + ")");
				} else {
					$("#bookmark_board").html(
							'<i class="far fa-bookmark fa-2x"></i>');
					$("#bookmark_board").removeAttr("onclick");
					$("#bookmark_board").attr(
							"onclick",
							"bookmarkBoard('" + mId + "','" + bType + "','"
									+ bId + "','" + bTypeKor + "','" + bIdKor
									+ "')");
				}
			},
			error : function() {
			},
			complete : function() {
			}
		});
	}
}
function bookmarkArticle(mId, bId, bIdx) {
	if (mId == null || mId == "") {
		alert("회원만 북마크 기능을 사용하실 수 있습니다");
	} else if (mId != null) {
		var badto = {
			mId : mId,
			bId : bId,
			bIdx : bIdx
		};

		$.ajax({
			async : true,
			type : "post",
			url : "http://localhost:8080/communityexample/bookmarkContent",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(badto),
			dataType : "json",
			success : function(data) {
				if (data == -1) {
					alert("이미 북마크한 게시물입니다");
				} else if (data < -1 || data == 0) {
					alert("오류가 발생했습니다. (error code:" + data + ")");
				} else {
					$("#bookmark_article").attr("class", "btn btn-danger");
					$("#bookmark_article").removeAttr("onclick");
					$("#bookmark_article").attr(
							"onclick",
							"unBookmarkArticle('" + mId + "','" + bId + "','"
									+ bIdx + "');");
				}
			},
			error : function() {
			},
			complete : function() {
			}
		});
	}
}
function unBookmarkArticle(mId, bId, bIdx) {
	if (mId == null || mId == "") {
		alert("회원만 북마크 기능을 사용하실 수 있습니다");
	} else if (mId != null) {
		var badto = {
			mId : mId,
			bId : bId,
			bIdx : bIdx
		};

		$.ajax({
			async : true,
			type : "post",
			url : "http://localhost:8080/communityexample/unBookmarkContent",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(badto),
			dataType : "json",
			success : function(data) {
				if (data == -1) {
					alert("이미 북마크한 게시물입니다");
				} else if (data < -1 || data == 0) {
					alert("오류가 발생했습니다. (error code:" + data + ")");
				} else {
					$("#bookmark_article").attr("class",
							"btn btn-outline-danger");
					$("#bookmark_article").removeAttr("onclick");
					$("#bookmark_article").attr(
							"onclick",
							"bookmarkArticle('" + mId + "','" + bId + "','"
									+ bIdx + "');");
				}
			},
			error : function() {
			},
			complete : function() {
			}
		});
	}
}
function reportArticle(mId, bType, bId, bIdx) {
	if (mId == null || mId == "") {
		alert("회원만 신고기능을 사용하실 수 있습니다");
	} else {
		var radto = {
			mId : mId,
			bType : bType,
			bId : bId,
			bIdx : bIdx
		};

		$.ajax({
			async : true,
			type : "post",
			url : "http://localhost:8080/communityexample/reportContent",
			contentType : "application/json;charset:utf-8",
			data : JSON.stringify(radto),
			dataType : "json",
			success : function(data) {
				if (data == 1) {
					alert("정상적으로 접수되었습니다");
				} else if (data == -1) {
					alert("이미 신고한 게시물입니다");
				} else {
					alert("서버오류, errorcode:" + data);
				}
			},
			error : function() {
			},
			complete : function() {
			}
		});
	}
}
function thumbsUpArticle(mId, bId, bIdx) {
	if (mId == null || mId == "") {
		alert("회원만 추천/비추천기능을 사용하실 수 있습니다");
	} else if (mId != null) {
		var vadto = {
			mId : mId,
			bId : bId,
			bIdx : bIdx,
			vUpDown : 1
		};

		$
				.ajax({
					async : true,
					type : "post",
					url : "http://localhost:8080/communityexample/thumbsUpContent",
					contentType : "application/json;charset=utf-8",
					data : JSON.stringify(vadto),
					dataType : "json",
					success : function(data) {
						if (data == -1) {
							alert("이미 추천/비추천한 게시물입니다");
						} else if (data < -1 || data == 0) {
							alert("오류가 발생했습니다. (error code:" + data + ")");
						} else {
							alert("추천/비추천이 적용되었습니다");
							$("#board_article_thumbsup")
									.html(
											data
													+ '<i class="far fa-thumbs-up fa-2x mx-2"></i>');
						}
					},
					error : function() {

					},
					complete : function() {

					}
				});
	}
}
function thumbsDownArticle(mId, bId, bIdx) {
	if (mId == null || mId == "") {
		alert("회원만 추천/비추천기능을 사용하실 수 있습니다");
	} else if (mId != null) {
		var vadto = {
			mId : mId,
			bId : bId,
			bIdx : bIdx,
			vUpDown : -1
		};

		$.ajax({
			async : true,
			type : "post",
			url : "http://localhost:8080/communityexample/thumbsDownContent",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(vadto),
			dataType : "json",
			success : function(data) {
				if (data == -1) {
					alert("이미 추천/비추천한 게시물입니다");
				} else if (data < -1 || data == 0) {
					alert("오류가 발생했습니다. (error code:" + data + ")");
				} else {
					$("#board_article_thumbsdown").html(
							'<i class="far fa-thumbs-down fa-2x mx-2"></i>'
									+ data);
				}
			},
			error : function() {

			},
			complete : function() {

			}
		});
	}
}
function thumbsUpComment(mId, bId, bcIdx) {
	if (mId == null || mId == "") {
		alert("회원만 추천/비추천기능을 사용하실 수 있습니다");
	} else if (mId != null) {
		var vcdto = {
			mId : mId,
			bId : bId,
			bcIdx : bcIdx,
			vUpDown : 1
		};

		$.ajax({
			async : true,
			type : "post",
			url : "http://localhost:8080/communityexample/thumbsUpComment",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(vcdto),
			dataType : "json",
			success : function(data) {
				if (data == -1) {
					alert("이미 추천/비추천한 댓글입니다");
				} else if (data < -1 || data == 0) {
					alert("오류가 발생했습니다. (error code:" + data + ")");
				} else {
					$("#comment_upvote_" + bcIdx).text(data);
				}
			},
			error : function() {

			},
			complete : function() {

			}
		});
	}
}
function thumbsDownComment(mId, bId, bcIdx) {
	if (mId == null || mId == "") {
		alert("회원만 추천/비추천기능을 사용하실 수 있습니다");
	} else if (mId != null) {
		var vcdto = {
			mId : mId,
			bId : bId,
			bcIdx : bcIdx,
			vUpDown : -1
		};

		$.ajax({
			async : true,
			type : "post",
			url : "http://localhost:8080/communityexample/thumbsDownComment",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(vcdto),
			dataType : "json",
			success : function(data) {
				if (data == -1) {
					alert("이미 추천/비추천한 댓글입니다");
				} else if (data < -1 || data == 0) {
					alert("오류가 발생했습니다. (error code:" + data + ")");
				} else {
					$("#comment_downvote_" + bcIdx).text(data);
				}
			},
			error : function() {

			},
			complete : function() {

			}
		});
	}
}
function comment(bId, bIdx, page) {
	var variable = {
		page : page
	}

	$.ajax({
		async : true,
		type : "post",
		url : "http://localhost:8080/communityexample/" + bId + "/" + bIdx
				+ "/comment",
		contentType : "application/json;chartset=utf-8",
		data : JSON.stringify(variable),
		dataType : "json",
		success : function(data) {
			$.each(data.boardCommentDtoList, function(i, item) {
				if (item.boardCommentInfoDto.bcNotice == 1) {
					$("#ce_comment_list").html();
				} else if (item.boardCommentInfoDto.bcBest == 1) {
					$("#ce_comment_list").html();
				} else if (item.boardCommentInfoDto.bcBlind == 1) {
					$("#ce_comment_list").html();
				} else {
					$("#ce_comment_list").html();
				}
			});
			$("#ce_comment_pagination").html();
		},
		error : function() {
		},
		complete : function() {
		}
	});
}