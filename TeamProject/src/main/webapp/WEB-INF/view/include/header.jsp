<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.user.u_id" var="u_id"/>
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
            		<b id="text-address">주소표시</b>
            	</span>
           		<button type="button" class="btn btn-danger btn-sm"><i class="bi bi-caret-down-fill"></i></button>
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
	<script>
		$(function() {
			let u_id = $(".btn-user").attr("id");
			
			$.ajax({
				type: "GET",
				url: `/address?u_id=${u_id}`,
				dataType: "json"
			})
			.done(function(data) {
				if(data.length == 0) {					
					$("#text-address").text("주소를 설정해주세요.");
				} else {
					for(let i=0; i<data.length; i++) {
						$("#text-address").text(data[i].atag);
					}
				}
			});
		});
	</script>
</sec:authorize>