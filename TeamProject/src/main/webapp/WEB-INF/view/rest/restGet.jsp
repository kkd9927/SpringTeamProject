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
    <link href="/resources/css/restaurant.css" rel="stylesheet">
    <style>
		#review-box { 
				display: none; 
		} 
		#info-box {
				display: none;
		}
	</style>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function(){
			$('input[type=radio][name=btnradio]').on('click', function(){
				var chkValue = $('input[type=radio][name=btnradio]:checked').val();
				
				if(chkValue == 'menu'){
					$('#menu-box').css('display', 'block');
					$('#review-box').css('display', 'none');
					$('#info-box').css('display', 'none');
				}
				
				else if(chkValue == 'review'){
					$('#menu-box').css('display', 'none');
					$('#review-box').css('display', 'block');
					$('#info-box').css('display', 'none');
				}
				
				else if(chkValue == 'info'){
					$('#menu-box').css('display', 'none');
					$('#review-box').css('display', 'none');
					$('#info-box').css('display', 'block');
				}
			});
		});
		
	</script>
	<!-- 헤더 -->
    <nav class="navbar navbar-light bg-danger position-fixed">
        <div class="container-md">
            <div>
                <a class="navbar-brand" href="/">
                    <img src="/resources/img/no-img.png">
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

    <!-- 컨텐츠 -->
    <c:set var="rest" value="${rest}"/>
    <div class="contents">
        <div class="container-md">
            <div class="restaurant-box">
                <div class="titleimg-box">
                    <img src="/resources/upload/${rest.r_img}" class="img-fluid">
                </div>

                <!-- JS 이용해 라디오 버튼의 체크에 따라 해당 탭 보여줌 (부트스트랩 visually-hidden 클래스 넣고 빼는식) -->
                <div class="title-box pt-4">
<!--                     <h2>가게이름</h2> -->
                    <h2>${rest.r_lname}</h2>
                    <p><i class="bi bi-star-fill text-warning"></i>&nbsp;${rest.avg}</p>

                    <div class="row">
                        <div class="col-12 btn-group" role="group" aria-label="Basic radio toggle button group">
                            <input type="radio" class="btn-check" name="btnradio" id="btnradio1" value="menu" checked>
                            <label class="btn btn-outline-danger rounded-0 border-0" for="btnradio1">메뉴</label>

                            <input type="radio" class="btn-check" name="btnradio" id="btnradio2" value="review">
                            <label class="btn btn-outline-danger rounded-0 border-0" for="btnradio2">리뷰</label>

                            <input type="radio" class="btn-check" name="btnradio" id="btnradio3" value="info">
                            <label class="btn btn-outline-danger rounded-0 border-0" for="btnradio3">정보</label>
                        </div>
                    </div>
                </div>

                <!-- 메뉴 탭 -->
                <div class="menu-box" id="menu-box">
                	<c:forEach items="${menuCatList}" var="menuCat">
                    <!-- 메뉴 카테고리 -->
	                    <div class="menucat-box d-grid">
	                        <input type="checkbox" class="btn-check" id="btncheck1">
	                        <label class="btn btn-light rounded-0 fw-bold fs-5" for="btncheck1">${menuCat.m_cat}</label>   
	                        
	                        <!-- 메뉴 목록 -->
	                        <div class="menulist-box d-grid">
	                            <!-- 단일 메뉴 -->
	                            <!-- 
	                                버튼 id에 DB에서 가져온 M_ID 값 부여하고 버튼 누르면 modal 창 띄운 메뉴에 대한 상세 페이지 보여줌(메뉴 설명, 추가메뉴 등)
	                                modal 창에서 장바구니 담기 누르면 장바구니에 메뉴 추가되는 방식
	                            -->
	                            <c:forEach items="${menuList}" var="menu">
		                            <c:if test="${menu.m_cat eq menuCat.m_cat}">
			                            <button class="menuitem-box p-1 bg-white border-0" id="${menu.m_id}">
			                                <div class="card rounded-0 border-0">
			                                	
			                                    <div class="row g-0">
			                                        <div class="col-2">
			                                            <div class="image-box">
			                                                <img src="${menu.m_img}" class="img-fluid rounded-start">
			                                            </div>
			                                        </div>
			    
			                                        <div class="col-10">
			                                            <div class="card-body">
			                                                <h5 class="card-title">${menu.m_name}</h5>
			                                                <p class="card-text">${menu.m_intro}</p> 
			                                                <div class="menuprice-box">
			                                                    <p class="card-text fw-bold">가격: ${menu.m_price}원</p>
			                                                </div>
			                                            </div>
			                                        </div>
			                                    </div>
			                                </div>
			                            </button>
		                            </c:if>
	                            </c:forEach>
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
                <!-- 메뉴 탭 -->

                <!-- 리뷰 탭 -->
                <div class="review-box" id="review-box">
                    <!-- 단일 리뷰 -->
                    <div class="reviewitem-box d-grid">
                        <div class="card p-1 rounded-0 border-0">
                            <div class="row g-0">
                                <div class="col-2">
                                    <div class="image-box position-relative">
                                        <img src="no-photo.png" class="img-fluid rounded-start">
                                        <button class="bg-white bg-opacity-10 border-0 position-absolute bottom-0 end-0"><i class="bi bi-plus"></i></button>
                                    </div>
                                </div>

                                <div class="col-10">
                                    <div class="card-body position-relative">
                                        <div class="row reviewtop-box card-title">
                                            <span class="col-4 fw-bold">닉네임(10글자 까지)</span>
                                            <span class="col-2"><i class="bi bi-star-fill text-warning"></i>&nbsp;0.0</span>
                                            <span class="col-6 reviewdate">날짜</span>
                                        </div>
                                        
                                        <!-- 리뷰내용 두줄 넘어가면 안됨(카드 이상해짐) -->
                                        <p class="card-text">리뷰내용(2줄까지)</p>

                                        <button class="bg-white border-0 position-absolute bottom-0 end-0"><span class="badge bg-light text-dark">더보기</span></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- 리뷰 탭 -->

                <!-- 정보 탭 -->
                <div class="info-box p-3" id="info-box">
                    <div class="infonotice-box">
                        <span class="fw-bold"><i class="bi bi-info-lg"></i>&nbsp;알림사항</span>

                        <p class="p-2 pb-4">${rest.r_intro}</p>
                    </div>

                    <hr>

                    <div class="infoshop-box">
                        <span class="fw-bold"><i class="bi bi-shop"></i>&nbsp;가게정보</span>
						
                        <div class="row p-2">
                            <!-- 영업시간 -->
							<div class="col-3">
                                <p>영업시간</p>
                            </div>
                            <c:set value="${restOpen}" var="open"/>
							<fmt:formatDate value="${open.r_opent}" pattern="HH:mm" var ="opent"/>
							<fmt:formatDate value="${open.r_closet}" pattern="HH:mm" var="closet"/>
	                            <div class="col-9">
	                                <p><b> ${opent} ~ ${closet}</b></p>
	                            </div>
                            <!-- 휴무일 -->
                            <div class="col-3">
                                <p>휴무일</p>
                            </div>
                            <c:set value="${restClosed}" var="closed"/>
	                            <div class="col-9">
	                                <p><b>${closed.w_cname}요일</b></p>
	                            </div>
                            <!-- 주소 -->
                            <div class="col-3">
                                <p>주소</p>
                            </div>

                            <div class="col-9">
                                <p><b>${rest.r_addr}</b><b>${rest.r_dtad}</b></p>
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
                                <p><b>${rest.r_minprice }</b></p>
                            </div>

                            <!-- 결제수단 -->
                            <div class="col-3">
                                <p>결제수단</p>
                            </div>

                            <div class="col-9">
                                <p>
									<c:forEach items="${restMethod}" var="method">
										<b>${method.p_cname}</b>
									</c:forEach>
								</p>
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
                                <p><b>${rest.r_licnum}</b></p>
                            </div>

                            <!-- 결제수단 -->
                            <div class="col-3">
                                <p>상호명</p>
                            </div>

                            <div class="col-9">
                                <p><b>${rest.r_lname}</b></p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 정보 탭 -->
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