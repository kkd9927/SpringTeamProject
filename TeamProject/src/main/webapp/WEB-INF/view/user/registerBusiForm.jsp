<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/view/include/metadata.jsp" %>
	<link href="/resources/css/register-form.css" rel="stylesheet">
	
	<title>회원가입</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/header.jsp" %>
	
	<div class="contents">
        <div class="container-md">
            <div class="register-box">
                <h4>가게등록</h4>
                <hr>
                <form action="/register" method="post" class="text-align">
                	<div class="row">
                        <label for="r_licnum" class="col-md-3 col-sm-12 col-form-label">사업자번호</label>
                        <div class="col-md-6 col-sm-9">
                            <input type="text" id="r_licnum" name="r_licnum" class="form-control">
                        </div>
                        <div class="col-md-3 col-sm-3">
                            <button class="btn btn-primary">번호찾기</button>
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_lname" class="col-md-3 col-sm-12 col-form-label">상호명</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_lname" name="r_lname" class="form-control" readonly>
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_addr" class="col-md-3 col-sm-12 col-form-label">사업장소재지</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_addr" name="r_addr" class="form-control" readonly>
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_tel" class="col-md-3 col-sm-12 col-form-label">매장전화번호</label>
                        <div class="col-md-6 col-sm-4">
                            <input type="text" id="r_tel" name="r_tel" placeholder="'-'제외 9~11자리" class="form-control" maxlength="11">
                        </div>
                        <div class="col-md-3 col-sm-4">
                            <button class="btn btn-primary">전송하기</button>
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_tel_auth" class="col-md-3 col-sm-12 col-form-label">인증번호</label>
                        <div class="col-md-6 col-sm-4">
                            <input type="text" id="r_tel_auth" name="r_tel_auth" class="form-control" maxlength="6" readonly>
                            <p id="pn-check-result">전화번호 인증 결과 표시</p>
                        </div>
                        <div class="col-md-3 col-sm-4">
                            <button class="btn btn-primary">인증확인</button>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">가입하기</button>
                            <a href="/" class="btn btn-light">가입취소</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
	
	<%@ include file="/WEB-INF/view/include/footer.jsp" %>
	
	<script src="/resources/js/delivery.js"></script>
</body>
</html>