<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%
	boolean loginError = request.getAttribute("loginError") == null ? false : true;
%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/view/include/metadata.jsp" %>
	<link href="/resources/css/login.css" rel="stylesheet">
	
	<title>로그인</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/header.jsp" %>
	
	<div class="contents">
        <div class="container-md">
            <div class="login-box">
                <form id="loginForm" action="/login" method="post">
                    <div class="row">
                        <input type="text" name="u_id" placeholder="아이디" class="form-control">
                    </div>
    
                    <div class="row">
                        <input type="password" name="u_pw" placeholder="비밀번호" class="form-control">
                    </div>
    
                    <div class="row">
                        <button type="submit" id="btn-login" class="btn btn-danger col-6">로그인</button>
                        <a href="/register" id="btn-login" class="btn btn-light col-6">회원가입</a>
                    </div>    
                </form>
                <%
                	if(loginError) {
                %>
                	<div class="error-box">                	
                		<p class="text-danger">아이디 혹은 비밀번호가 틀렸습니다.</p>
                	</div>
                <%
                	}
                %>
                
                <div class="row">
                    <button type="button" id="btn-naver-login" class="btn btn-success">네이버 로그인</button>
                </div>
                
                <div class="row">
                    <button type="button" id="btn-kakao-login" class="btn btn-warning">카카오 로그인</button>
                </div>
            </div>
        </div>
    </div>
	
	<%@ include file="/WEB-INF/view/include/footer.jsp" %>
	
	<script src="/resources/js/delivery.js"></script>
</body>
</html>