<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/view/include/metadata.jsp" %>
	<link href="/resources/css/home.css" rel="stylesheet">
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 부트스트랩 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>

    <!-- 제이쿼리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <link href="/resources/css/delivery.css" rel="stylesheet">
    <link href="/resources/css/list.css" rel="stylesheet">
<title>Rest List</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/header.jsp" %>
	<!-- 헤더 -->
<!--     <nav class="navbar navbar-light bg-danger position-fixed"> -->
<!--         <div class="container-md"> -->
<!--             <div> -->
<!--                 <a class="navbar-brand" href="/"> -->
<!--                     <img src="no-photo.png" width="30" height="30"> -->
<!--                 </a> -->

<!--                 * 로그인 전에는 표시안함 -->
<!--                 <span class="navbar-text text-white"><i class="bi bi-geo-alt-fill"></i>&nbsp;<b>주소표시</b></span> -->
<!--                 <button type="button" class="btn btn-danger btn-sm"><i class="bi bi-caret-down-fill"></i></button> -->
<!--                 -->
<!--             </div> -->

<!--             로그인 전 -->
<!--             <div>
<!--                 <button type="button" class="btn btn-light">로그인</button> -->
<!--             </div> --> 

<!--             로그인 후 -->
<!--             <div> -->
<!--                 <a href="#" class="btn btn-danger"><i class="bi bi-shop" style="font-size: 1.5rem;"></i></a> -->

<!--                 <a href="#" class="btn btn-danger position-relative"> -->
<!--                     <i class="bi bi-cart" style="font-size: 1.5rem;"></i> -->

<!--                     * 장바구니에 아이템 있을 시 표시 -->
<!--                     <span class="position-absolute top-0 start-100 translate-middle p-2 bg-warning border border-light rounded-circle"> -->
<!--                         <span class="visually-hidden"></span> -->
<!--                     </span> -->
<!--                      -->
<!--                 </a> -->

<!--                 
<!--                     * 버튼 클릭시 회원정보 페이지로 이동 -->
<!--                 --> 
<!--                 <a href="#" class="btn btn-danger"><i class="bi bi-person-fill" style="font-size: 1.5rem;"></i></a> -->

<!--                 <button type="button" class="btn btn-light">로그아웃</button> -->
<!--             </div> -->
<!--         </div> -->
<!--     </nav> -->

	<script type="text/javascript">
		function clickFunction(c_code){
			location.href = '/rest/restList?c_code=' + c_code;
		}
// 				location.href = '/rest/restList?'+function().target.value
	
			
	</script>
    <!-- 컨텐츠 -->
    <div class="contents">
        <div class="container-md">
            <div class="search-box position-relative">
                <form action="/search" method="get">
                    <input name="keyword" type="search" placeholder="음식점을 검색해보세요."
                        class="form-control form-control-lg rounded-pill">
                    <button type="submit"
                        class="btn-search bg-white rounded-pill border-0 position-absolute top-0 end-0"><i
                            class="bi bi-search" style="font-size: 1.5rem;"></i></button>
                </form>
            </div>

            <div class="category-box">
                <div class="row">
                    <div class="col-12">
						<c:forEach items="${category}" var="cat">
							<button id="c-${cat.c_code}" class="btn btn-danger btn-sm btn-category" value="c_code=${cat.c_code}" onclick="clickFunction(${cat.c_code})">${cat.c_cname}</button>
						</c:forEach>
                        <!-- DB 카테고리 테이블에서 가져와 자동생성 -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->
<!--                         <button id="c-0" class="btn btn-danger btn-sm btn-category">카테고리</button> -->

                    </div>
                </div>
            </div>

            <hr>

            <div class="list-box">
                <div class="row">
                    <!-- 나중에 아래꺼 다 지우고 DB에서 가져와 자동 생성 -->

                    <!-- 가게 개별 템플릿 -->
                    <c:forEach items="${list}" var="rest">
	                    <div class="col-md-6 col-sm-12">
	                        <div class="card position-relative">
	                            <div class="image-box position-absolute start-0">
	                                <img src="no-photo.png" class="img-fluid rounded-start">
	                            </div>
	
	                            <div class="card-body position-relative">
	                                <h5 class="card-title"><a href="/rest/restGet?r_id=${rest.r_id}" class="text-decoration-none text-dark">${rest.r_lname}</a></h5>
	                                <p class="card-text"><i class="bi bi-star-fill text-warning"></i>&nbsp;<b>${rest.avg}</b><b>(${rest.sum2})</b></p>
<%-- 	                                <p class="card-text"><i class="bi bi-star-fill text-warning"></i>&nbsp;<b>${rest.avg}</b><b>(${rest.sum2})</b></p> --%>
	                                <p class="card-text">최소주문금액: <b>${rest.r_minprice}</b></p>
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                    <!-- 가게 개별 템플릿 -->

<!--                     <div class="col-md-6 col-sm-12"> -->
<!--                         <div class="card position-relative"> -->
<!--                             <div class="image-box position-absolute start-0"> -->
<!--                                 <img src="no-photo.png" class="img-fluid rounded-start"> -->
<!--                             </div> -->

<!--                             <div class="card-body position-relative"> -->
<!--                                 <h5 class="card-title"><a href="#" class="text-decoration-none text-dark">가게 이름</a></h5> -->
<!--                                 <p class="card-text"><i class="bi bi-star-fill text-warning"></i>&nbsp;0.0(리뷰수)</p> -->
<!--                                 <p class="card-text">결제방식 | 최소주문금액</p> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->

<!--                     <div class="col-md-6 col-sm-12"> -->
<!--                         <div class="card position-relative"> -->
<!--                             <div class="image-box position-absolute start-0"> -->
<!--                                 <img src="no-photo.png" class="img-fluid rounded-start"> -->
<!--                             </div> -->

<!--                             <div class="card-body position-relative"> -->
<!--                                 <h5 class="card-title"><a href="#" class="text-decoration-none text-dark">가게 이름</a></h5> -->
<!--                                 <p class="card-text"><i class="bi bi-star-fill text-warning"></i>&nbsp;0.0(리뷰수)</p> -->
<!--                                 <p class="card-text">결제방식 | 최소주문금액</p> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->

<!--                     <div class="col-md-6 col-sm-12"> -->
<!--                         <div class="card position-relative"> -->
<!--                             <div class="image-box position-absolute start-0"> -->
<!--                                 <img src="no-photo.png" class="img-fluid rounded-start"> -->
<!--                             </div> -->

<!--                             <div class="card-body position-relative"> -->
<!--                                 <h5 class="card-title"><a href="#" class="text-decoration-none text-dark">가게 이름</a></h5> -->
<!--                                 <p class="card-text"><i class="bi bi-star-fill text-warning"></i>&nbsp;0.0(리뷰수)</p> -->
<!--                                 <p class="card-text">결제방식 | 최소주문금액</p> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->

<!--                     <div class="col-md-6 col-sm-12"> -->
<!--                         <div class="card position-relative"> -->
<!--                             <div class="image-box position-absolute start-0"> -->
<!--                                 <img src="no-photo.png" class="img-fluid rounded-start"> -->
<!--                             </div> -->

<!--                             <div class="card-body position-relative"> -->
<!--                                 <h5 class="card-title"><a href="#" class="text-decoration-none text-dark">가게 이름</a></h5> -->
<!--                                 <p class="card-text"><i class="bi bi-star-fill text-warning"></i>&nbsp;0.0(리뷰수)</p> -->
<!--                                 <p class="card-text">결제방식 | 최소주문금액</p> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
                    
<!--                     <div class="col-md-6 col-sm-12"> -->
<!--                         <div class="card position-relative"> -->
<!--                             <div class="image-box position-absolute start-0"> -->
<!--                                 <img src="no-photo.png" class="img-fluid rounded-start"> -->
<!--                             </div> -->

<!--                             <div class="card-body position-relative"> -->
<!--                                 <h5 class="card-title"><a href="#" class="text-decoration-none text-dark">가게 이름</a></h5> -->
<!--                                 <p class="card-text"><i class="bi bi-star-fill text-warning"></i>&nbsp;0.0(리뷰수)</p> -->
<!--                                 <p class="card-text">결제방식 | 최소주문금액</p> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->

<!--                     <div class="col-md-6 col-sm-12"> -->
<!--                         <div class="card position-relative"> -->
<!--                             <div class="image-box position-absolute start-0"> -->
<!--                                 <img src="no-photo.png" class="img-fluid rounded-start"> -->
<!--                             </div> -->

<!--                             <div class="card-body position-relative"> -->
<!--                                 <h5 class="card-title"><a href="#" class="text-decoration-none text-dark">가게 이름</a></h5> -->
<!--                                 <p class="card-text"><i class="bi bi-star-fill text-warning"></i>&nbsp;0.0(리뷰수)</p> -->
<!--                                 <p class="card-text">결제방식 | 최소주문금액</p> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->

<!--                     <div class="col-md-6 col-sm-12"> -->
<!--                         <div class="card position-relative"> -->
<!--                             <div class="image-box position-absolute start-0"> -->
<!--                                 <img src="no-photo.png" class="img-fluid rounded-start"> -->
<!--                             </div> -->

<!--                             <div class="card-body position-relative"> -->
<!--                                 <h5 class="card-title"><a href="#" class="text-decoration-none text-dark">가게 이름</a></h5> -->
<!--                                 <p class="card-text"><i class="bi bi-star-fill text-warning"></i>&nbsp;0.0(리뷰수)</p> -->
<!--                                 <p class="card-text">결제방식 | 최소주문금액</p> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
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

    <script src="/js/delivery.js"></script>
</body>
</html>