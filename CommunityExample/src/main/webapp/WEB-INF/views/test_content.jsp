<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<%@ include file="include/header.jsp"%>
<div class="container bg-white col-lg-8 p-4">
<!-- start of content -->
<script>
function ajaxtest(){
	alert();
	var formVar = createForm("formname", "post", "/communityexample/test2");
	formVar = createInput(formVar, "text", "test", "val");
	formVar = createInput(formVar, "hidden", "_method","put");
	
	document.body.appendChild(formVar);
	formVar.submit();
}
</script>

 
<button type="button" onclick="ajaxtest();">전송</button>




<!-- end of content -->
</div>
<%@ include file="include/footer.jsp"%>