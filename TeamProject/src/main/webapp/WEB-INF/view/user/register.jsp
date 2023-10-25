<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/view/include/metadata.jsp" %>
	<link href="/resources/css/register.css" rel="stylesheet">
	
	<title>회원가입</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/header.jsp" %>
	
	<div class="contents">
        <div class="container-md">
            <div class="register-box">
                <h4>회원가입</h4>
                <hr>
                <div class="row">
                    <div class="col-6">
                        <a href="/register/form?u_code=1" class="btn btn-primary btn-register border-0">
                            <img src="/resources/img/no-img.png">
                        </a>
                        <h5 class="p-2">일반 회원</h5>
                    </div>

                    <div class="col-6">
                        <a href="/register/form?u_code=2" class="btn btn-danger btn-register border-0">
                            <img src="/resources/img/no-img.png">
                        </a>
                        <h5 class="p-2">사업자 회원</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
	<%@ include file="/WEB-INF/view/include/footer.jsp" %>
	
	<script src="/resources/js/delivery.js"></script>
</body>
</html>