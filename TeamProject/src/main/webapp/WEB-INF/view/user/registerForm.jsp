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
                <h4>회원가입</h4>
                <hr>
                <form action="/register" method="post" class="text-align">
                    <input type="hidden" id="u_code" name="u_code" value="${u_code}">

                    <div class="row">
                        <label for="u_rname" class="col-md-3 col-sm-12 col-form-label">성명</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="u_rname" name="u_rname" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="u_id" class="col-md-3 col-sm-12 col-form-label">아이디</label>
                        <div class="col-md-6 col-sm-9">
                            <input type="text" id="u_id" name="u_id" class="form-control">
                            <p id="id-check-result">중복확인 체크 표시</p>
                        </div>
                        <div class="col-md-3 col-sm-3">
                            <button class="btn btn-primary">중복확인</button>
                        </div>
                    </div>

                    <div class="row">
                        <label for="u_pw" class="col-md-3 col-sm-12 col-form-label">비밀번호</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="password" id="u_pw" name="u_pw" class="form-control">
                            <p id="pw-check-result">비밀번호 유효성 검사 표시</p>
                        </div>
                    </div>

                    <div class="row">
                        <label for="u_nname" class="col-md-3 col-sm-12 col-form-label">닉네임</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="u_nname" name="u_nname" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="u_phone" class="col-md-3 col-sm-12 col-form-label">전화번호</label>
                        <div class="col-md-6 col-sm-8">
                            <input type="text" id="u_phone" name="u_phone" class="form-control" maxlength="11">
                        </div>
                        <div class="col-md-3 col-sm-4">
                            <button class="btn btn-primary">전송하기</button>
                        </div>
                    </div>

                    <div class="row">
                        <label for="u_phone_auth" class="col-md-3 col-sm-12 col-form-label">인증번호</label>
                        <div class="col-md-6 col-sm-4">
                            <input type="text" id="u_phone_auth" name="u_phone_auth" class="form-control" maxlength="6">
                            <p id="pn-check-result">전화번호 인증 결과 표시</p>
                        </div>
                        <div class="col-md-3 col-sm-4">
                            <button class="btn btn-primary">인증확인</button>
                        </div>
                    </div>

<!--                     <div class="row"> -->
<!--                         <label for="u_addr" class="col-md-3 col-sm-12 col-form-label">주소</label> -->
<!--                         <div class="col-md-6 col-sm-12"> -->
<!--                             <input type="text" id="u_addr" name="u_addr" class="form-control"> -->
<!--                         </div> -->
<!--                         <div class="col-md-3 col-sm-4"> -->
<!--                             <button class="btn btn-primary">주소찾기</button> -->
<!--                         </div> -->
<!--                     </div> -->

<!--                     <div class="row"> -->
<!--                         <label for="u_addr" class="col-md-3 col-sm-12 col-form-label">상세주소</label> -->
<!--                         <div class="col-md-9 col-sm-12"> -->
<!--                             <input type="text" id="u_dtad" name="u_dtad" class="form-control"> -->
<!--                         </div> -->
<!--                     </div> -->

<!--                     <div class="row"> -->
<!--                         <label for="u_atag" class="col-md-3 col-sm-12 col-form-label">태그</label> -->
<!--                         <div class="col-md-4 col-sm-4"> -->
<!--                             <select class="form-select"> -->
<!--                                 <option value="집">집</option> -->
<!--                                 <option value="회사">회사</option> -->
<!--                                 <option value="직접입력">직접입력</option> -->
<!--                             </select> -->
<!--                         </div> -->
<!--                         <div class="col-md-5 col-sm-8"> -->
<!--                             <input type="text" id="u_phone" name="u_phone" class="form-control visually-hidden" maxlength="8"> -->
<!--                         </div> -->
<!--                     </div> -->

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