<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WELCOME DELIVERY WEB!</title>

    <!-- 부트스트랩 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>

    <!-- 제이쿼리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <link href="/resources/css/delivery.css" rel="stylesheet">
    <link href="/resources/css/restaurant-manage.css" rel="stylesheet">
    <script type="text/javascript">
		function deleteConfirm(id) {
			if(confirm("가게 정보를 삭제하시겠습니까?")==true){
				location.href="/rest/restRemove?r_id=" + id;
			}
			else
				return;
		}
	</script>
</head>
<body>
	<!-- 헤더 -->
    <nav class="navbar navbar-light bg-danger position-fixed">
        <div class="container-md">
            <div>
                <a class="navbar-brand" href="/">
                    <img src="no-photo.png">
                </a>

                <!-- * 로그인 전에는 표시안함 -->
                <!-- <span class="navbar-text text-white"><i class="bi bi-geo-alt-fill"></i>&nbsp;<b>주소표시</b></span>
                <button type="button" class="btn btn-danger btn-sm"><i class="bi bi-caret-down-fill"></i></button> -->
                <!-- -->
            </div>

            <!-- 로그인 전 -->
            <div>
                <button type="button" class="btn btn-light">로그인</button>
            </div>

            <!-- 로그인 후 -->
            <!-- <div>
                <a href="#" class="btn btn-danger"><i class="bi bi-shop" style="font-size: 1.5rem;"></i></a>

                <a href="#" class="btn btn-danger position-relative">
                    <i class="bi bi-cart" style="font-size: 1.5rem;"></i> -->

            <!-- * 장바구니에 아이템 있을 시 표시 -->
            <!-- <span
                        class="position-absolute top-0 start-100 translate-middle p-2 bg-warning border border-light rounded-circle">
                        <span class="visually-hidden"></span>
                    </span> -->
            <!--  -->
            <!-- </a> -->

            <!-- 
                    * 버튼 클릭시 회원정보 페이지로 이동
                -->
            <!-- <a href="#" class="btn btn-danger"><i class="bi bi-person-fill" style="font-size: 1.5rem;"></i></a>

                <button type="button" class="btn btn-light">로그아웃</button> -->
        </div>
    </nav>
	<c:set value="${rest}" var="rest"/>
    <!-- 컨텐츠 -->
    <div class="contents">
        <div class="container-md">

            <div class="row">
                <!-- 타이틀 -->
                <div class="col-12">
                    <div class="card bg-light mt-4">
                        <div class="card-body">
                            <div class="image-box">
                                <img src="/resources/upload/${rest.r_img }">
                            </div>

                            <h3 class="mt-1">${rest.r_lname }</h3>
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
                                        <span class="h5 fw-bold">가게정보</span>
                                        <a href="/rest/restModify?r_id=${rest.r_id}" class="badge bg-secondary border-0"><i class="bi bi-pencil"></i>&nbsp;편집</a>

                                        <hr>

                                        <div class="infonotice-box">
                                            <span class="fw-bold"><i class="bi bi-info-lg"></i>&nbsp;알림사항</span>
                                            
                                            <div class="row p-2">
                                                <p>${rest.r_intro}</p>
                                            </div>
                                        </div>
                    
                                        <hr>
                    
                                        <div class="infoshop-box">
                                            <span class="fw-bold"><i class="bi bi-shop"></i>&nbsp;가게정보</span>
                    
                                            <div class="row p-2">
                                                <!-- 영업시간 -->
                                                <c:set value="${restOpen}" var="open"/>
												<fmt:formatDate value="${open.r_opent}" pattern="HH:mm" var ="opent"/>
												<fmt:formatDate value="${open.r_closet}" pattern="HH:mm" var="closet"/>
                                                <div class="col-3">
                                                    <p>영업시간</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${opent} ~ ${closet}</p>
                                                </div>
                    
                                                <!-- 휴무일 -->
                                                <c:set value="${restClosed}" var="closed"/>
                                                <div class="col-3">
                                                    <p>휴무일</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${closed.w_cname}요일</p>
                                                </div>
                    
                                                <!-- 주소 -->
                                                <div class="col-3">
                                                    <p>주소</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${rest.r_addr } ${rest.r_dtad }</p>
                                                </div>
                                            </div>
                                        </div>
                    
                                        <hr>
                    
                                        <div class="infopay-box">
                                            <span class="fw-bold"><i class="bi bi-credit-card-2-back"></i>&nbsp;결제정보</span>
                                            
                                            <div class="row p-2">
                                                <!-- 최소주문금액 -->
                                                <div class="col-3">
                                                    <p>최소주문금액</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${rest.r_minprice }</p>
                                                </div>
                    
                                                <!-- 결제수단 -->
                                                <div class="col-3">
                                                    <p>결제수단</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <c:forEach items="${restMethod}" var="method">
														${method.p_cname}
													</c:forEach>
                                                </div>
                                            </div>
                                        </div>
                    
                                        <hr>
                    
                                        <div class="infolicense-box">
                                            <span class="fw-bold"><i class="bi bi-person-vcard"></i>&nbsp;사업자정보</span>
                                            
                                            <div class="row p-2">
                                                <!-- 사업자등록번호 -->
                                                <div class="col-3">
                                                    <p>사업자등록번호</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${rest.r_licnum }</p>
                                                </div>
                    
                                                <!-- 결제수단 -->
                                                <div class="col-3">
                                                    <p>상호명</p>
                                                </div>
                    
                                                <div class="col-9">
                                                    <p>${rest.r_lname }</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
        
                        <div class="col-4 mainright-col">
                            <div class="row">
        
                                <div class="col-12">
                                    <div class="card bg-light">
                                        <div class="card-body">
                                            <span class="h5 fw-bold">메뉴목록</span>
                                            <a href="/menu/menuRegister?r_id=${rest.r_id}" class="badge bg-secondary border-0"><i class="bi bi-pencil"></i>&nbsp;편집</a>

                                            <hr>

                                            <div class="menulist-box">
                                            <c:forEach items="${menuCatList}" var="menuCat">
                                                <b>${menuCat.m_cat}</b>
	                                                <ol>
	                                                <c:forEach items="${menuList}" var="menu">
		                                                <c:if test="${menu.m_cat eq menuCat.m_cat}">
		                                                    <li>${menu.m_name}</li>
		                                                </c:if>
	                                                </c:forEach>
	                                                </ol>
											</c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
        
                                <div class="col-12">
                                    <div class="card bg-light">
                                        <div class="card-body">
                                            <span class="h5 fw-bold">리뷰목록</span>
                                            <button type="button" class="badge bg-secondary border-0"><i class="bi bi-pencil"></i>&nbsp;조회</button>

                                            <hr>

                                            <div class="review-box">
                                                <p>리뷰내용(가장 최신 n개)</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
        
                            </div>

                            <div class="d-grid">
                                <a href="#" onclick="deleteConfirm('${rest.r_id}')" class="btn btn-danger">등록해제</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 푸터 시작 -->
    <div class="footer bg-light position-relative bottom-0">
        <div class="container-md">
            <div class="p-3">
                <h4>DELIVERY WEB</h4>
                <hr>
                <p>개발: 김기덕, 노현서, 박종민, 정진성</p>
            </div>
        </div>
    </div>
    <!-- 푸터 끝 -->

    <script src="/resources/js/delivery.js"></script>
</body>
</html>