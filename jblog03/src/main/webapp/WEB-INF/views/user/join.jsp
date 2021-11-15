<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

<script src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function(){
	
	$("#finally").click(function (){
	
		if($("#id").val() == '' || $("#password").val() == '' || $("#name").val() == ''){
			alert("필수항목을 입력해 주십시오");
			return false;
		}
		
		if($("input:checkbox[id=agree-prov]").is(":checked") == false) {
			alert("약관에 동의하지 않으셨습니다.");
			return false;
		}
		
		return true;
		
	});
	
	
	$("#btn-checkemail").click(function() {
		
		var id = $("#id").val();
		if(id == '') {
			alert("ID를 입력하십시오");
			return;
		} //if(id == '') end
		
		console.log(id);
		
		$.ajax({
			
			url: "${pageContext.request.contextPath }/user/api/checkID?id=" + id,
			type: "get",
			dataType: "json",
			
			/* 에러 발생시 */
			error: function(xhr, status, e) {
				console.log(status, e);
			},
			
			/* 성공 시 */
			success: function(response) {
				
				console.log(response);
				
				/* 데이터 전송 후 에러 발생시 */
				if(response.result != "success") {
					console.error(response.message);
					return;
				}
				
				if(response.data == true) {
					alert("존재하는 ID입니다. 다른 이메일을 사용하세요.");
					$("#id")
						.val("")
						.focus();
					$("#finally").hide();
					return;
				} else if (response.data == false){
					alert("사용 가능한 ID 입니다.");
					$("#finally").show();
				}
				
			}
			
		});	// 중복체크 ajax 엔드
		
	});	//btn-checkemail 엔드
	
});
</script>

</head>
<body>
	<div class="center-content">
		<h1 class="logo" style="background:url(${pageContext.request.contextPath}/assets/images/logo.jpg) no-repeat 0 0">JBlog</h1>
		<ul class="menu">
			<c:choose>
			<c:when test="${empty User }">
				<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
				<li><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/blog">내블로그</a></li>
			</c:otherwise>
			</c:choose>
		</ul>
		<form class="join-form" id="join-form" method="post" onsubmit="return finallyCheck();" 
		action="${pageContext.request.contextPath }/user/join">
			<label class="block-label" for="name">이름</label>
			
			<!-- name value -->
			<input id="name"name="name" type="text" value="">
			
			<label class="block-label" for="blog-id">아이디</label>
			
			<!-- ID value -->
			<input id="id" name="id" type="text">
			
			<!-- 중복체크 --> 
			<input id="btn-checkemail" type="button" value="id 중복체크">
			
			<img id="img-checkemail" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label>
			
			<!-- passwrod value -->
			<input id="password" name="password" type="password" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input id="finally" type="submit" value="가입하기">

		</form>
	</div>
</body>
</html>
