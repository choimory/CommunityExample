function check() {
	alert('check');
}

function createForm(formName, formMethod, formAction){
	var formVar=document.createElement("form");
	
	formVar.setAttribute("charset", "UTF-8");
	formVar.setAttribute("method", formMethod);  //Post 방식
 	formVar.setAttribute("action", formAction); //요청 보낼 주소
	
	return formVar;
}

function createInput(formVar,inputType,inputName,inputValue){
	var inputVar=document.createElement("input");

	inputVar.setAttribute("type", inputType); // 인풋타입정하기
	inputVar.setAttribute("name", inputName); //인풋name정하기
	inputVar.setAttribute("value", inputValue); // 인풋값정하기
	
	formVar.appendChild(inputVar);
	
	return formVar;
}

function blind(bid,bidx) {
	var formVar=createForm("formname","post","/communityexample/admin/blind");
	formVar=createInput(formVar,"text","bId",bid);
	formVar=createInput(formVar,"text","bIdx",bidx); 

    document.body.appendChild(formVar);
	formVar.submit();
}

function permission(sidx, permission){
	var f=createForm("formname","post","/communityexample/admin/permission");
	f=createInput(f,"text","sIdx",sidx);
	f=createInput(f,"text","sPermission", permission);
	
	document.body.appendChild(f);
	f.submit();
}
function logout(){
	var f=createForm("formname","post","/communityexample/logout");
	
	document.body.appendChild(f);
	f.submit();
}
function modifyArticle(memberDtoId, boardDtoId, bId, bIdx){
	if(memberDtoId==boardDtoId){
		location.href="/communityexample/"+bId+"modify?bIdx="+bIdx;
	}else{
		location.href="/communityexample/main";
	}
}
function deleteArticle(bId, bIdx){
	var f=createForm("formName","post","/communityexample/"+bId+"/delete")
	f=createInput(f, "text", "bIdx", bIdx);
	
	document.body.appendChild(f);
	f.submit();
	alert("완료");
}
function bookmarkBoard(){}
function bookmarkArticle(){}
function thumbsUpArticle(){}
function thumbsDownArticle(){}
function thumbsUpComment(){}
function thumbsDownComment(){}

