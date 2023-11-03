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
		
		//모달창
        function loadMenuAddList(m_id,m_num, m_price) {
        $.ajax({
            url: "/menu/menuAddList",
            type: "GET",
            data: {m_id: m_id},
            success: function(menuAddList) 
            {
                var html = "";
                $.each(menuAddList, function(index, menuAdd) 
                {
                    html += '<li>';
                    html += '<input type="checkbox" class="menu-add-checkbox" data-a-id="'+menuAdd.a_id+'" data-a-name="' + menuAdd.a_name + '"data-a-price="' + menuAdd.a_price + '">';                                 
                    html +=  menuAdd.a_name + ":" + menuAdd.a_price + "원";
                    html += '수량 : <select class="menu-add-quantity">';
                        for(var i =1; i<=5; i++) 
                        {
                            html += '<option value="' + i + '">' + i + '</option>';
                        }
                    html += '</select>';        
                    html += '</li>';
                });
                $("#ulModal").html(html);
                $('#add-to-cart-btn').data('m-id', m_id);
                $('#add-to-cart-btn').data('m-num', m_num);
                $('#add-to-cart-btn').data('m-price', m_price);
                $("#menuModal").modal('show');
            },
            error: function(error) 
            {
                console.error("Error", error);
            }
            });
        }
		
	</script>
	<%@ include file="/WEB-INF/view/include/header.jsp" %>
	<!-- 헤더 -->
<!--     <nav class="navbar navbar-light bg-danger position-fixed"> -->
<!--         <div class="container-md"> -->
<!--             <div> -->
<!--                 <a class="navbar-brand" href="/"> -->
<!--                     <img src="/resources/img/no-img.png"> -->
<!--                 </a> -->

                <!-- * 로그인 전에는 표시안함 -->
                <!-- <span class="navbar-text text-white"><i class="bi bi-geo-alt-fill"></i>&nbsp;<b>주소표시</b></span>
                <button type="button" class="btn btn-danger btn-sm"><i class="bi bi-caret-down-fill"></i></button> -->
                <!-- -->
<!--             </div> -->

            <!-- 로그인 전 -->
<!--             <div> -->
<!--                 <button type="button" class="btn btn-light">로그인</button> -->
<!--             </div> -->

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
<!--         </div> -->
<!--     </nav> -->

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
			                            <button type="button" onclick="loadMenuAddList(${menu.m_id}, 1, ${menu.m_price})" class="menuitem-box p-1 bg-white border-0">
			                                <div class="card rounded-0 border-0">
			                                	
			                                    <div class="row g-0">
			                                        <div class="col-2">
			                                            <div class="image-box">
			                                                <img src="/resources/upload/${menu.m_img}" class="img-fluid rounded-start">
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

	<!--모달 -->
	<div class="modal fade" id="menuModal" tabindex="-1" aria-labelledby="menuAddModalLabel" aria-hidden="true">
		<div class="modal-dialog">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<h5 class="modal-title" id="menuAddModalLabel">추가 메뉴</h5>
	        		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">x</button>
	     		</div>
		      	<div class="modal-body">
		      	    <input type="hidden" id="m_id_input" name="m_id">
				    <input type="hidden" id="m_num_input" name="m_num">
				    <input type="hidden" id="m_price_input" name="m_price">
			        
			        <ul id="ulModal">

			        </ul>
			        
		      	</div>
	   			<div class="modal-footer">
	   			
					<!--세션에 담겨야하는 컨트롤러를 구현 --> 	
					 				
	   				<button onclick="addToCart($(this).data('m-id'), $(this).data('m-num'), $(this).data('m-price'))">담기</button>

		      	</div>
    		</div>
   		</div>
	</div>
    <!--모달 -->
	
	<!-- 주문서 작성 -->
	<button id="orderDetail">주문서 이동</button>
	<!-- 주문서 작성 -->    
    
    <script>
	    $(document).ready(function() {
	        // 페이지가 로드될 때 메뉴 정보를 가져오는 AJAX 요청
	        $.ajax({
	            url: '/menu/getMenuInfo',
	            type: 'GET',
	            success: function(menu) {
	                // 버튼에 click 이벤트 리스너 추가
	                $('#addToCartButton').click(function() {
	                    addToCart(menu.mId, 1, menu.mPrice);
	                });
	            },
	            error: function(error) {
	                console.error('메뉴 정보를 가져오는데 실패했습니다.', error);
	            }
	        });
	    });
        //세션에 저장하는 스크립트
        function addToCart(m_id, m_num, m_price)
        {
            var selectedItems = []//배열 초기화
        
            $('.menu-add-checkbox:checked').each(function(){
                //메뉴항목 정보
                var MenuItem = {
                    //m_id값도 저장할수있나?
                    m_id: m_id,
                    m_num: m_num,
                    m_price: m_price,
                    a_id: $(this).data("a-id"),
                    a_name: $(this).data("a-name"),
                    a_price: $(this).data("a-price"),
                    a_quantity: $(this).closest("li").find(".menu-add-quantity").val()
                };            
                selectedItems.push(MenuItem);
            });
            $.ajax({
            url: "/menu/sessionCart",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(selectedItems),
            success: function(response) 
            {
                console.log("메뉴가 담겼습니다.:", response);
                alert("성공적으로 담겼습니다.!");
                $("#menuModal").modal('hide');
            },
            error: function(error) {
                console.error("메뉴를 담는데 실패하였습니다.", error);
                alert("메뉴를 담는데 실패");
            }
        });
        }
        
        //cart 내용을 디비에 저장하고 세션에서 삭제
        $('#orderDetail').click(function() 
        {
    		$.ajax({
	    	    url: "/menu/orderdetail",
	    	    type: "POST",
	    	    contentType: "application/json",
	    	    success: function(response) 
	    	    {
	    	      console.log("메뉴가 담겨졌습니다.");
	    	      window.location.href = "/order/complete";
	    	    },
	    	    error: function(error) 
	    	    {
	    	      console.error("담기 실패:", error);
	    	      alert("담기에 실패했습니다. 다시 시도해주세요.");
	    	    }
        	});
        });
        
        
        
    </script>

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