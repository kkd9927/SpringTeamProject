<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/view/include/metadata.jsp" %>
	<link href="/resources/css/restaurant-manage.css" rel="stylesheet">
	
	<title>${principal.user.u_id}</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/header.jsp" %>
	
	<div class="contents">
        <div class="container-md">

            <div class="row">
                <!-- 타이틀 -->
                <div class="col-12">
                    <div class="card bg-light mt-4">
                        <div class="card-body">
                            <div class="image-box rounded-circle">
                                <img src="no-photo.png" class="rounded-circle">
                            </div>

                            <h3 class="mt-1">${principal.user.u_rname}</h3>
                        </div>
                    </div>
                </div>
                
                <!-- 메인 -->
                <div class="col-12">
                    <div class="row">
                        <div class="col-8 mainleft-col">
                            <div class="info-box">
                                <div class="card bg-light">
                                    <div class="card-body">
                                        <span class="h5 fw-bold">회원정보</span>
                                        <a href="/user/${principal.user.u_id}/modify" class="badge bg-secondary border-0 text-white text-decoration-none"><i class="bi bi-pencil"></i>&nbsp;수정</a>

                                        <hr>

                                        <div class="address-box">
                                            <span class="fw-bold"><i class="bi bi-house"></i>&nbsp;배달지정보</span>

                                            <div class="row p-2">
                                                <div class="col-3">
                                                    <p>기본주소</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>
                                                        <b>${principal.addr[0].u_atag}</b>
                                                        <span>${principal.addr[0].u_addr} ${principal.addr[0].u_dtad}</span>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>

                                        <hr>

                                        <div class="info-box">
                                            <span class="fw-bold"><i class="bi bi-person"></i>&nbsp;회원정보</span>

                                            <div class="row p-2">
                                                <div class="col-3">
                                                    <p>이름</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${principal.user.u_rname}</p>
                                                </div>

                                                <div class="col-3">
                                                    <p>닉네임</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${principal.user.u_nname}</p>
                                                </div>

                                                <div class="col-3">
                                                    <p>전화번호</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${principal.user.u_phone}</p>
                                                </div>

                                                <div class="col-3">
                                                    <p>가입일</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${principal.user.u_regdate}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
        
                        <div class="col-4 mainright-col">
                            <div class="row">
                                <!-- 찜목록 -->
                                <div class="col-12">
                                    <div class="card bg-light">
                                        <div class="card-body">
                                            <span class="h5 fw-bold">찜목록</span>
                                            <button type="button" class="badge bg-secondary border-0 text-white text-decoration-none"><i class="bi bi-pencil"></i>&nbsp;조회</button>

                                            <hr>

                                            <div class="list-box">
                                                <p>찜목록 <b>0</b>건</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- 찜목록 -->

                                <!-- 주문내역 -->
                                <div class="col-12">
                                    <div class="card bg-light">
                                        <div class="card-body">
                                            <span class="h5 fw-bold">주문내역</span>
                                            <button type="button" class="badge bg-secondary border-0 text-white text-decoration-none"><i class="bi bi-pencil"></i>&nbsp;조회</button>

                                            <hr>

                                            <div class="list-box">
                                                <p>주문내역 <b>0</b>건</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- 주문내역 -->
                                
                                <!-- 리뷰목록 -->
                                <div class="col-12">
                                    <div class="card bg-light">
                                        <div class="card-body">
                                            <span class="h5 fw-bold">리뷰목록</span>
                                            <button type="button" class="badge bg-secondary border-0 text-white text-decoration-none"><i class="bi bi-pencil"></i>&nbsp;조회</button>

                                            <hr>

                                            <div class="list-box">
                                                <p>리뷰 <b>0</b>건</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- 리뷰목록 -->
        
                            </div>

                            <div class="d-grid">
                                <button type="button" id="btn-user-remove" class="btn btn-danger" type="button">회원탈퇴</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	
	<%@ include file="/WEB-INF/view/include/footer.jsp" %>
	
	<script src="/resources/js/delivery.js"></script>
	
	<script type="text/javascript">
		$("#btn-user-remove").on("click", function() {
			if(confirm("정말 탈퇴 하시겠습니까?")) {
				location.href("/user/remove");
			}
		});
	</script>
</body>
</html>