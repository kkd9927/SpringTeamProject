<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.addr" var="addr"/>
	<c:set var="current-addr" value="${addr.get(0)"/>
</sec:authorize>

<nav class="navbar navbar-light bg-danger position-fixed">
    <div class="container-md">
        <div>
            <a class="navbar-brand" href="/">
                <img src="/resources/img/no-img.png" width="30" height="30">
            </a>

			<sec:authorize access="isAuthenticated()">
            	<span class="navbar-text text-white">
            		<i class="bi bi-geo-alt-fill"></i>
            		<b id="current-addr"></b>
            	</span>
           		<button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#addressModal"><i class="bi bi-caret-down-fill"></i></button>
        	</sec:authorize>
        </div>

        <sec:authorize access="!isAuthenticated()">
			<div>
				<a href="/login" class="btn btn-light">로그인</a>
			</div>
		</sec:authorize>

        <sec:authorize access="isAuthenticated()">
			<div>
				<sec:authorize access="hasRole('BUSINESS')">
			    	<a href="#" class="btn btn-danger"><i class="bi bi-shop" style="font-size: 1.5rem;"></i></a>
				</sec:authorize>
			
			    <a href="#" class="btn btn-danger position-relative">
			        <i class="bi bi-cart" style="font-size: 1.5rem;"></i>
			
			        <!-- * 장바구니에 아이템 있을 시 표시 -->
			        <span class="position-absolute top-0 start-100 translate-middle p-2 bg-warning border border-light rounded-circle">
			            <span class="visually-hidden"></span>
			        </span>
			    </a>
			    
			    <!-- * 버튼 클릭시 회원정보 페이지로 이동 -->
			    <a href="/user/${u_id}" id="${u_id}" class="btn btn-danger btn-user"><i class="bi bi-person-fill" style="font-size: 1.5rem;"></i></a>
			
			    <a href="/logout" class="btn btn-light">로그아웃</a>
			</div>
		</sec:authorize>
    </div>
</nav>

<sec:authorize access="isAuthenticated()">
<div class="modal fade" id="addressModal" tabindex="-1" aria-labelledby="addressModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-body">
                <h4>주소설정</h4>
                
                <hr>
                
                <ul id="addr-list" class="list-group list-group-flush">
                	<c:forEach var="addr-item" items="${addr}" varStatus="stat">                	
	                    <li id="list-addr-${stat.count}" class="list-group-item">
<%-- 	                    	<c:choose> --%>
<%-- 								<c:when test="${current-addr eq addr-item.u_atag}"> --%>
<!-- 									<button type="button" id="addr-select" class="bg-white border-0" disabled> -->
<%-- 								</c:when> --%>
<%-- 								<c:otherwise> --%>
<!-- 									<button type="button" id="addr-select" class="bg-white border-0"> -->
<%-- 								</c:otherwise> --%>
<%-- 	                    	</c:choose> --%>
<!-- 	                    	<button type="button" id="addr-select" class="bg-white border-0"> -->
<%-- 	                            <b id="addr-${stat.count}-tag"><c:out value="${addr-item.u_atag}"/></b> --%>
<%-- 	                            <span id="addr-${stat.count}-addr"><c:out value="${addr-item.u_addr}"/></span> --%>
<%-- 	                            <span id="addr-${stat.count}-dtad"><c:out value="${addr-item.u_dtad}"/></span> --%>
<!-- 	                        </button> -->
<%-- 	                        <c:if test="${addr.get(0).u_atag eq addr-item.u_atag}">	                    	 --%>
<!-- 	                        	<span class="badge bg-danger">현재위치</span>	 -->
<%-- 	                    	</c:if> --%>
<!-- 	                    	<span class="badge bg-danger">현재위치</span>	 -->
<%-- 	                        <button type="button" id="addr-${stat.count}-delete" class="bg-white border-0"><i class="bi bi-x-lg text-danger"></i></button> --%>
	                    </li>
                	</c:forEach>
                	
                    <li id="addr-add" class="list-group-item">
                        <button type="button" id="btn-add-addr" class="bg-white border-0"><i class="bi bi-plus-lg text-primary"></i></button>
                    </li>
                    
                    
					<!-- 등록 폼 -->
                    <li id="addr-add-form" class="list-group-item">
                        <div class="row">
                            <label class="col-2 col-form-label">태그</label>
                            <div class="col-4">
                                <select id="addr-tag-select" class="form-select">
                                    <option value="집">집</option>
                                    <option value="회사">회사</option>
                                    <option value="직접입력">직접입력</option>
                                </select>
                            </div>

                            <div class="col-6">
                                <input type="text" id="addr-tag-input" class="form-control">
                            </div>
                        </div>

                        <div class="row">
                            <label class="col-2 col-form-label">주소</label>
                            <div class="col-7">
                                <input type="text" id="addr-input" class="form-control" disabled>
                            </div>
                            <div class="col-3">
                                <button id="addr-find" class="btn btn-primary">주소찾기</button>
                            </div>
                            <div class="col-2"></div>
                            <div class="col-10">
                                <input type="text" id="dtad-input" class="form-control">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12">
                                <button id="addr-add-accept" class="btn btn-primary">확인</button>
                                <button id="addr-add-cancel" class="btn btn-secondary">취소</button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>

            <div class="modal-footer p-0">
                <button type="button" class="btn btn-secondary m-2" data-bs-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>
</sec:authorize>