<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/view/include/metadata.jsp" %>
	<link href="/resources/css/home.css" rel="stylesheet">
	
	<title>WELCOME DELIVERY WEB!</title>
</head>
<body>
	<%@ include file="/WEB-INF/view/include/header.jsp" %>
	
	<div class="contents">
        <div class="container-md">
        
            <!-- 광고 시작 -->
            <div class="ad-box">
                <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="image-box">
                                <a href="#">
                                    <img src="/resources/img/no-img.png">
                                </a>
                            </div>
                        </div>

                        <div class="carousel-item">
                            <div class="image-box">
                                <a href="#">
                                    <img src="/resources/img/no-img.png">
                                </a>
                            </div>
                        </div>

                        <div class="carousel-item">
                            <div class="image-box">
                                <a href="#">
                                    <img src="/resources/img/no-img.png">
                                </a>
                            </div>
                        </div>
                    </div>

                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>

                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
            <!-- 광고 끝 -->

            <!-- 검색 시작 -->
            <div class="search-box position-relative">
                <form action="/search" method="get">
                    <input name="keyword" type="search" placeholder="음식점을 검색해보세요." class="form-control form-control-lg rounded-pill">
                    <button type="submit" class="btn-search bg-white rounded-pill border-0 position-absolute top-0 end-0"><i class="bi bi-search" style="font-size: 1.5rem;"></i></button>
                </form>
            </div>
            <!-- 검색 끝 -->

            <!-- 카테고리 시작 -->
            <!-- 
                * AJAX 통신 이용해서 DB CAT_CODE 테이블 갯수만큼 JS(jQuery)로 태그 생성
            -->
            <div class="category-box">
                <div class="row">
                	<c:forEach items="${category}" var="cat">
	                    <div class="col-md-2 col-sm-4">
	                        <div class="category-box">
	                            <a href="/rest/restList?c_code=${cat.c_code}">
	                                <img src="/resources/img/french.png">
	                            </a>
	                             <p>${cat.c_cname}
	                        </div>
	                    </div>
                	</c:forEach>
              
<!--                     <div class="col-md-2 col-sm-4"> -->
<!--                         <div class="category-box"> -->
<!--                             <a href="#"> -->
<!--                                 <img src="/resources/img/no-photo.png"> -->
<!--                             </a> -->
<!--                         </div> -->
<!--                     </div> -->

<!--                     <div class="col-md-2 col-sm-4"> -->
<!--                         <div class="category-box"> -->
<!--                             <a href="#"> -->
<!--                                 <img src="/resources/img/no-photo.png"> -->
<!--                             </a> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="col-md-2 col-sm-4"> -->
<!--                         <div class="category-box"> -->
<!--                             <a href="#"> -->
<!--                                 <img src="/resources/img/no-photo.png"> -->
<!--                             </a> -->
<!--                         </div> -->
<!--                     </div> -->

<!--                     <div class="col-md-2 col-sm-4"> -->
<!--                         <div class="category-box"> -->
<!--                             <a href="#"> -->
<!--                                 <img src="/resources/img/no-photo.png"> -->
<!--                             </a> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="col-md-2 col-sm-4"> -->
<!--                         <div class="category-box"> -->
<!--                             <a href="#"> -->
<!--                                 <img src="/resources/img/no-photo.png"> -->
<!--                             </a> -->
<!--                         </div> -->
<!--                     </div> -->
                </div>
            </div>
            <!-- 카테고리 끝 -->
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