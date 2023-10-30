<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/view/include/metadata.jsp" %>
	<link href="/resources/css/register-form.css" rel="stylesheet">
	
	<title>${principal.user.u_id}</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/header.jsp" %>
	
	<div class="contents">
        <div class="container-md">
            <div class="register-box">
                <h4>회원정보</h4>
                
                <hr>
                
                <div class="row">
                    <label for="u_rname" class="col-md-3 col-sm-12 col-form-label">성명</label>
                    <div class="col-md-9 col-sm-12">
                        <input type="text" id="u_rname" name="u_rname" value="${principal.user.u_rname}" class="form-control bg-white border-0" readonly>
                    </div>
                </div>

                <div class="row">
                    <label for="u_id" class="col-md-3 col-sm-12 col-form-label">아이디</label>
                    <div class="col-md-9 col-sm-12">
                        <input type="text" id="u_id" name="u_id" value="${principal.user.u_id}" class="form-control bg-white border-0" readonly>
                    </div>
                </div>

                <div class="row">
                    <label for="u_nname" class="col-md-3 col-sm-12 col-form-label">닉네임</label>
                    <div class="col-md-6 col-sm-9">
                        <input type="text" id="u_nname" name="u_nname" value="${principal.user.u_nname}" class="form-control">
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <button id="btn-nname-change" class="btn btn-primary">변경하기</button>
                    </div>
                </div>
                
                <div class="row">
                    <label for="u_img" class="col-md-3 col-sm-12 col-form-label">프로필사진</label>
                    <div class="col-md-6 col-sm-9">
                        <input type="file" id="u_img" name="u_img" class="form-control" disabled>
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <button id="btn-img-change" class="btn btn-primary" disabled>변경하기</button>
                    </div>
                </div>

                <h4>비밀번호 변경</h4>
                <hr>
                <div class="row">
                    <label for="u_pw" class="col-md-3 col-sm-12 col-form-label">현재비밀번호</label>
                    <div class="col-md-9 col-sm-12">
                        <input type="password" id="u_pw_before" name="u_pw_before" class="form-control">
                    </div>
                </div>

                <div class="row">
                    <label for="u_pw" class="col-md-3 col-sm-12 col-form-label">변경비밀번호</label>
                    <div class="col-md-6 col-sm-9">
                        <input type="password" id="u_pw_after" name="u_pw_after" class="form-control">
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <button id="btn-pw-change" class="btn btn-primary">변경하기</button>
                    </div>
                </div>

                <h4>전화번호 변경</h4>
                <hr>
                <div class="row">
                    <label for="u_phone" class="col-md-3 col-sm-12 col-form-label">전화번호</label>
                    <div class="col-md-6 col-sm-9">
                        <input type="text" id="u_phone" name="u_phone" placeholder="'-' 제외 11자리" class="form-control" maxlength="11">
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <button class="btn btn-primary">전송하기</button>
                    </div>
                </div>

                <div class="row">
                    <label for="u_phone_auth" class="col-md-3 col-sm-12 col-form-label">인증번호</label>
                    <div class="col-md-6 col-sm-4">
                        <input type="text" id="u_phone_auth" name="u_phone_auth" class="form-control" maxlength="6" readonly>
                        <p id="pn-check-result">전화번호 인증 결과 표시</p>
                    </div>
                    <div class="col-md-3 col-sm-4">
                        <button id="btn-phone-change" class="btn btn-primary">변경하기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
	<%@ include file="/WEB-INF/view/include/footer.jsp" %>
	
	<script src="/resources/js/delivery.js"></script>
	
	<script type="text/javascript">
		$("#btn-nname-change").on("click", function() {
			let id = $(".btn-user").attr("id");
			let nname = $("#u_nname").val();
			
			const data = {
				u_id: id,
				u_nname: nname
			}
			
			$.ajax({
				type: "put",
				url: `/user/${id}/modify-nname`,
				headers: {
				    'Content-Type': 'application/json'
				},
				data: JSON.stringify(data),
				success: function(result) {
					location.reload();
				}
			});
		});
		
		$("#btn-img-change").on("click", function() {
			let id = $(".btn-user").attr("id");
			let img = $("#u_img").val();
			
			const data = {
				u_id: id,
				u_img: img
			}
			
			$.ajax({
				type: "put",
				url: `/user/${id}/modify-img`,
				headers: {
				    'Content-Type': 'multipart/form-data'
				},
				data: JSON.stringify(data),
				success: function(result) {
					location.reload();
				}
			});
		});
		
		$("#btn-pw-change").on("click", function() {
			let id = $(".btn-user").attr("id");
			let pwBefore = $("#u_pw_before").val();
			let pwAfter = $("#u_pw_after").val();
			
			const data = {
				u_id: id,
				u_pw_before: pwBefore,
				u_pw_after: pwAfter
			}
			
			$.ajax({
				type: "put",
				url: `/user/${id}/modify-password`,
				headers: {
				    'Content-Type': 'application/json'
				},
				data: JSON.stringify(data),
				success: function(result) {
					location.reload();
				}
			});
		});
		
		$("#btn-phone-change").on("click", function() {
			let id = $(".btn-user").attr("id");
			let phone = $("#u_phone").val();
			const data = {
				u_id: id,
				u_phone: phone
			}
			
			$.ajax({
				type: "put",
				url: `/user/${id}/modify-phone`,
				headers: {
				    'Content-Type': 'application/json'
				},
				data: JSON.stringify(data),
				success: function(result) {
					location.reload();
				}
			});
		});
	</script>
</body>
</html>