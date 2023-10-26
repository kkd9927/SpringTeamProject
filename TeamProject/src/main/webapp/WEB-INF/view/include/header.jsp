<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
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
            		<b id="current-addr">${principal.addr[0].u_atag}</b>
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
			    <a href="/user/${principal.user.u_id}" id="${principal.user.u_id}" class="btn btn-danger btn-user"><i class="bi bi-person-fill" style="font-size: 1.5rem;"></i></a>
			
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
	                	<c:forEach var="addr" items="${principal.addr}" varStatus="stat">                	
		                    <li id="list-addr-${stat.count}" class="list-group-item">
			                    <c:choose>
			                    	<c:when test="${principal.addr[0].u_atag eq addr.u_atag}">
			                    		<button type="button" id="addr-select" class="bg-white border-0 text-dark" disabled>
			                    	</c:when>
			                    	<c:otherwise>
			                    		<button type="button" id="addr-select" class="bg-white border-0">
			                    	</c:otherwise>
			                    </c:choose>
		                            <b id="addr-${stat.count}-tag">${addr.u_atag}</b>
		                            <span id="addr-${stat.count}-addr">${addr.u_addr}</span>
		                            <span id="addr-${stat.count}-dtad">${addr.u_dtad}</span>
		                        </button>
		                        <c:if test="${principal.addr[0].u_atag eq addr.u_atag}">                        
		                        	<span class="badge bg-danger">현재위치</span>	
		                        </c:if>
		                        <button type="button" id="addr-${stat.count}-delete" class="bg-white border-0"><i class="bi bi-x-lg text-danger"></i></button>
		                    </li>
	                	</c:forEach>
	                	
	                    <li class="list-group-item">
	                        <button type="button" id="btn-addr-add" class="bg-white border-0"><i class="bi bi-plus-lg text-primary"></i></button>
	                    </li>
	                    
						<!-- 등록 폼 -->
	                    <li id="form-addr" class="list-group-item form-toggle">
		                    <form action="/address/add" method="post">
		                        <div class="row">
		                            <label class="col-2 col-form-label">태그</label>
		                            <div class="col-4">
		                                <select id="select-addr-tag" class="form-select">
		                                    <option value="1">집</option>
		                                    <option value="2">회사</option>
		                                    <option value="3">직접입력</option>
		                                </select>
		                            </div>
		
		                            <div class="col-6">
		                                <input type="text" id="input-addr-tag" class="form-control form-toggle">
		                            </div>
		                        </div>
		
		                        <div class="row">
		                            <label class="col-2 col-form-label">주소</label>
		                            <div class="col-7">
		                                <input type="text" id="input-addr" class="form-control">
		                            </div>
		                            <div class="col-3">
		                                <button id="addr-find" class="btn btn-primary">주소찾기</button>
		                            </div>
		                            <div class="col-2"></div>
		                            <div class="col-10">
		                                <input type="text" id="input-dtad" class="form-control">
		                            </div>
		                        </div>
		
		                        <div class="row">
		                            <div class="col-12">
		                                <button id="accept-addr-add" class="btn btn-primary">확인</button>
		                                <button id="accept-addr-cancel" class="btn btn-secondary">취소</button>
		                            </div>
		                        </div>
		                    </form>
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

<script type="text/javascript">
	$("#btn-addr-add").on("click", function() {
		$("#form-addr").toggleClass("form-toggle");
	});
	
	$("#select-addr-tag").change(function() {
		if($("#select-addr-tag option:selected").val() == 3) {
			$("#input-addr-tag").removeClass("form-toggle");
		} else {
			$("#input-addr-tag").addClass("form-toggle");
		}
	});
	
	$("#accept-addr-add").on("click", function() {
		let id = $(".btn-user").attr("id");
		let tag;
		let addr;
		let dtad;
		
		let selNum = $("#select-addr-tag option:selected").val()
		if(selNum == 1) {
			tag = "집";
		} else if(selNum == 2) {
			tag = "회사";
		} else {
			tag = $("#input-addr-tag").val() == "" ? "null" : $("#input-addr-tag").val();
		}
		
		addr = $("#input-addr").val();
		dtad = $("#input-dtad").val();
		
		const data = {
			u_id: id, 
			u_atag: tag, 
			u_addr: addr, 
			u_dtad: dtad
		}
		
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "/address/add",
			data: JSON.stringify(data),
			dataType: "json"
		});
	});
</script>