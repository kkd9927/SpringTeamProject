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
</head>
<body>
	<c:set value="${rest}" var="rest"/>
    <!-- 헤더 -->
    <%@ include file="/WEB-INF/view/include/header.jsp" %>
    <!-- 컨텐츠 -->
    <div class="contents">
        <div class="container-md">
			<form action="/menu/menuRegister" method="post" class="text-align" >
	            <div class="row">
	                <!-- 타이틀 -->
	                <div class="col-12">
	                    <div class="card bg-light mt-4">
	                        <div class="card-body">
	                            <div class="image-box">
	                                <img src="/resources/upload/${rest.r_img}">
	                            </div>
	
	                            <h3 class="mt-1">${rest.r_lname}</h3>
	                        </div>
	                    </div>
	                </div>
	                
	                <!-- 메인 -->
	                <div class="col-12">
	                    <div class="card bg-light mb-4">
	                        <div class="card-body">
	                            <span class="h5 fw-bold">메뉴목록</span>
	
	                            <hr>
	
	                            <div class="pb-3">
	                                <button type="button" id="cat-add" class="btn btn-primary">분류추가</button>
	                            </div>
	
	                            <div class="card">
	                                <div class="card-body p-0">
	                                    <!-- 분류명 템플릿 -->
	                                    <!-- 분류 추가 버튼 클릭시 아래 템플릿 append -->
	                                    <c:forEach items="${menuCatList}" var="menuCat">
	                                    <div class="d-grid gap-2">
	                                        <span class="bg-light rounded p-2">
	                                            <b>분류명</b>
	
	                                            <span class="position-absolute end-0 pe-2">
	                                                <button type="button" id="menu-add" class="btn btn-light p-0" data-bs-toggle="tooltip" data-bs-placement="bottom" title="메뉴 추가"><i class="bi bi-plus-square"></i></button>
	                                                <button type="button" id="cat-edit" class="btn btn-light p-0" data-bs-toggle="tooltip" data-bs-placement="bottom" title="분류 수정"><i class="bi bi-pencil-square"></i></button>
	                                                <button type="button" id="cat-delete" class="btn btn-light p-0" data-bs-toggle="tooltip" data-bs-placement="bottom" title="분류 삭제"><i class="bi bi-x-square"></i></button>
	                                            </span>
	                                        </span>
	                                    </div>
	                                    <!-- 분류명 템플릿 -->
	
	                                    <!-- 분류 수정 템플릿 -->
	                                    <!-- 분류 수정 버튼 클릭시 아래 템플릿 append -->
	                                    <div class="d-grid gap-2">
	                                        <span class="bg-white rounded shadow-sm mb-1 p-2">
	                                            <div class="row edit-box">
	                                                <label for="m_cat" class="col-md-2 col-sm-12 col-form-label">분류명</label>
	                                                <div class="col-md-4 col-sm-12">
	                                                    <input type="text" id="m_cat" value="${menuCat.m_cat}" class="form-control">
	                                                </div>
	
	                                                <div class="col-12 btn-box ps-0">
	                                                    <button type="button" id="" class="btn btn-primary btn-sm m-1">적용</button>
	                                                    <button type="button" id="" class="btn btn-secondary btn-sm m-1">취소</button>
	                                                </div>
	                                            </div>
	                                        </span>
	                                    </div>
	                                    <!-- 분류 수정 템플릿 -->
	
	
	
	                                    <!-- 메뉴 템플릿 -->
	                                    <!-- 메뉴 추가 버튼 클릭시 아래 템플릿 append -->
	                                    <div class="d-grid gap-2">
	                                        <span class="bg-white rounded p-2">
	                                            <span>메뉴명</span>
	                                            
	                                            <span class="btn-box position-absolute end-0 pe-2">
	                                                <button type="button" id="submenu-add" class="btn btn-white p-0" data-bs-toggle="tooltip" data-bs-placement="bottom" title="부가메뉴 추가"><i class="bi bi-plus-square"></i></button>
	                                                <button type="button" id="menu-edit" class="btn btn-white p-0" data-bs-toggle="tooltip" data-bs-placement="bottom" title="메뉴 수정"><i class="bi bi-pencil-square"></i></button>
	                                                <button type="button" id="menu-delete" class="btn btn-white p-0" data-bs-toggle="tooltip" data-bs-placement="bottom" title="메뉴 삭제"><i class="bi bi-x-square"></i></button>
	                                            </span>
	                                        </span>
	                                    </div>
	                                    <!-- 메뉴 템플릿 -->
	
	                                    <!-- 메뉴 수정 템플릿 -->
	                                    <!-- 메뉴 수정 버튼 클릭시 아래 템플릿 append -->
	                                    <c:forEach items="${menuList}" var="menu">
                                        	<c:if test="${menu.m_cat eq menuCat.m_cat}">
			                                    <div class="d-grid gap-2">
			                                        <span class="bg-white rounded shadow-sm mb-1 p-2">
			                                            <div class="row edit-box">
			                                                <label for="m_name" class="col-md-2 col-sm-12 col-form-label">메뉴명</label>
			                                                <div class="col-md-4 col-sm-12">
			                                                    <input type="text" id="m_name" value="${menu.m_name}" class="form-control">
			                                                </div>
			
			                                                <label for="m_price" class="col-md-2 col-sm-12 col-form-label">가격</label>
			                                                <div class="col-md-4 col-sm-12">
			                                                    <input type="text" value="${menu.m_price}" id="m_price" class="form-control">
			                                                </div>
			
			                                                <label for="m_intro" class="col-2 col-form-label">설명</label>
			                                                <div class="col-10">
			                                                    <textarea type="text" id="m_intro" placeholder="${menu.m_intro}" class="form-control"></textarea>
			                                                </div>
			
			                                                <label for="m_img" class="col-2 col-form-label">대표사진</label>
			                                                <div class="col-4">
			                                                    <input class="form-control" value="${menu.m_img}" type="file" id="m_img">
			                                                </div>
			
			                                                <div class="col-12 btn-box ps-0">
			                                                    <button type="button" id="" class="btn btn-primary btn-sm m-1">적용</button>
			                                                    <button type="button" id="" class="btn btn-secondary btn-sm m-1">취소</button>
			                                                </div>
			                                            </div>
			                                        </span>
			                                    </div>
	                                    <!-- 메뉴 수정 템플릿 -->
	                                    <!-- 부가메뉴 템플릿 -->
	                                    <!-- 부가메뉴 추가 버튼 클릭시 아래 템플릿 append -->
	                                    		<c:forEach items="${menuAddR}" var="menuAdd">
                                        			<c:if test="${menuAdd.m_id eq menu.m_id}">	
					                                    <div class="d-grid gap-2">
					                                        <span class="bg-white rounded p-2">
					                                            <span>└</span>
					                                            <span>부가메뉴명</span>
					                                            
					                                            <span class="btn-box position-absolute end-0 pe-2">
					                                                <button type="button" id="menu-edit" class="btn btn-white p-0" data-bs-toggle="tooltip" data-bs-placement="bottom" title="부가메뉴 수정"><i class="bi bi-pencil-square"></i></button>
					                                                <button type="button" id="menu-delete" class="btn btn-white p-0" data-bs-toggle="tooltip" data-bs-placement="bottom" title="부가메뉴 삭제"><i class="bi bi-x-square"></i></button>
					                                            </span>
					                                        </span>
					                                    </div>
					                                    <!-- 부가메뉴 템플릿 -->
					
					                                    <!-- 부가메뉴 수정 템플릿 -->
					                                    <!-- 부가메뉴 수정 버튼 클릭시 아래 템플릿 append -->
					                                    <div class="d-grid gap-2">
					                                        <span class="bg-white rounded shadow-sm mb-1 p-2">
					                                            <div class="row edit-box">
					                                                <label for="m_name" class="col-md-2 col-sm-12 col-form-label">메뉴명</label>
					                                                <div class="col-md-4 col-sm-12">
					                                                    <input type="text" id="a_name" value="${menuAdd.a_name }" class="form-control">
					                                                </div>
					
					                                                <label for="m_price" class="col-md-2 col-sm-12 col-form-label">가격</label>
					                                                <div class="col-md-4 col-sm-12">
					                                                    <input type="text" id="a_price" value="${menuAdd.a_price }" class="form-control">
					                                                </div>
					
					                                                <div class="col-12 btn-box ps-0">
					                                                    <button type="button" id="" class="btn btn-primary btn-sm m-1">적용</button>
					                                                    <button type="button" id="" class="btn btn-secondary btn-sm m-1">취소</button>
					                                                </div>
					                                            </div>
					                                        </span>
					                                    </div>
					                                    </c:if>
				                                    </c:forEach>
			                                   	</c:if>
		                               		</c:forEach>
	                                    <!-- 부가메뉴 수정 템플릿 -->
	                                    </c:forEach>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	    	</form>
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
    <script src="/resources/js/restaurant-editmenu.js"></script>
</body>
</html>