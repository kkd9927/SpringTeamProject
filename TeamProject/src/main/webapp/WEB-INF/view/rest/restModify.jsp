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
</head>
<body>
	<script type="text/javascript">
		function deleteConfirm(id) {
			if(confirm("가게 정보를 삭제하시겠습니까?")==true){
				location.href="/rest/restRemove?r_id=" + id;
			}
			else
				return;
		}
	</script>
    <!-- 헤더 -->
    <%@ include file="/WEB-INF/view/include/header.jsp" %>
    <c:set var="rest" value="${rest}"/>
    <div class="contents">
        <div class="container-md">
            <div class="register-box">
                <form action="/rest/restModify?r_id=${rest.r_id}" method="post" class="text-align" >
                    <h4>사업자정보</h4>
                    <hr>

                    <div class="row">
                        <label for="r_licnum" class="col-md-3 col-sm-12 col-form-label">사업자번호</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_licnum" value="${rest.r_licnum}" name="r_licnum" class="form-control" readonly>
                        </div>
                    </div>
                    
                    <div class="row">
                        <label for="u_id" class="col-md-3 col-sm-12 col-form-label">사업자아이디</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="u_id" value="${rest.u_id}" name="u_id" class="form-control" readonly>
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_lname" class="col-md-3 col-sm-12 col-form-label">상호명</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_lname" value="${rest.r_lname}" name="r_lname" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_addr" class="col-md-3 col-sm-12 col-form-label">사업장소재지</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_addr" value="${rest.r_addr}" name="r_addr" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_dtad" class="col-md-3 col-sm-12 col-form-label">상세주소</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_dtad" value="${rest.r_dtad}" name="r_dtad" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_tel" class="col-md-3 col-sm-12 col-form-label">매장전화번호</label>
                        <div class="col-md-6 col-sm-4">
                            <input type="text" id="r_tel" value="${rest.r_tel}" name="r_tel" placeholder="'-'제외 9~11자리" value="가게 전화번호" class="form-control" maxlength="11">
                        </div>
                        <div class="col-md-3 col-sm-4">
                            <button class="btn btn-primary">전송하기</button>
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_tel_auth" class="col-md-3 col-sm-12 col-form-label">인증번호</label>
                        <div class="col-md-6 col-sm-4">
                            <input type="text" id="r_tel_auth" name="r_tel_auth" class="form-control" maxlength="6" readonly>
                            <p id="pn-check-result">전화번호 인증 결과 표시</p>
                        </div>
                        <div class="col-md-3 col-sm-4">
                            <button class="btn btn-primary">인증확인</button>
                        </div>
                    </div>
                    
                    <h4>가게정보</h4>
                    <hr>
                    
                    <div class="row">
                        <label for="r_bname" class="col-md-3 col-sm-12 col-form-label">브랜드명</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_bname" value="${rest.r_bname}" name="r_bname" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_img" class="col-md-3 col-sm-12 col-form-label">대표사진</label>
                        <div class="col-md-9 col-sm-12">
                            <input class="form-control" type="file" value="${rest.r_img}" name="r_img" id="r_img">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_intro" class="col-12 col-form-label">알림사항</label>
                        <div class="col-12">
                            <textarea id="r_intro" name="r_intro" rows="10" class="form-control" placeholder="${rest.r_intro}"></textarea>
                        </div>
                    </div>
                    <c:set var="open" value="${restOpen}"/>
					<fmt:formatDate value="${open.r_opent}" pattern="HH:mm" var="opent"/>
                    
                    <div class="row">
                        <label for="r_opentS" class="col-md-3 col-sm-12 col-form-label">영업시간</label>
                        <div class="col-md-4 col-sm-6">
                            <select class="form-select" name="restOpen.r_opentS" id="r_opentS">
                                <!-- DB에서 R_OPENT 데이터 들고와서 맞는곳에 selected 속성 부여해야함 -->
                                <option value="01:00" <c:if test="${opent eq '01:00'}">selected</c:if> >01:00</option>
                                <option value="02:00" <c:if test="${opent eq '02:00'}">selected</c:if>>02:00</option>
                                <option value="03:00" <c:if test="${opent eq '03:00'}">selected</c:if>>03:00</option>
                                <option value="04:00" <c:if test="${opent eq '04:00'}">selected</c:if>>04:00</option>
                                <option value="05:00" <c:if test="${opent eq '05:00'}">selected</c:if>>05:00</option>
                                <option value="06:00" <c:if test="${opent eq '06:00'}">selected</c:if>>06:00</option>
                                <option value="07:00" <c:if test="${opent eq '07:00'}">selected</c:if>>07:00</option>
                                <option value="08:00" <c:if test="${opent eq '08:00'}">selected</c:if>>08:00</option>
                                <option value="09:00" <c:if test="${opent eq '09:00'}">selected</c:if>>09:00</option>
                                <option value="10:00" <c:if test="${opent eq '10:00'}">selected</c:if>>10:00</option>
                                <option value="11:00" <c:if test="${opent eq '11:00'}">selected</c:if>>11:00</option>
                                <option value="12:00" <c:if test="${opent eq '12:00'}">selected</c:if>>12:00</option>
                                <option value="13:00" <c:if test="${opent eq '13:00'}">selected</c:if>>13:00</option>
                                <option value="14:00" <c:if test="${opent eq '14:00'}">selected</c:if>>14:00</option>
                                <option value="15:00" <c:if test="${opent eq '15:00'}">selected</c:if>>15:00</option>
                                <option value="16:00" <c:if test="${opent eq '16:00'}">selected</c:if>>16:00</option>
                                <option value="17:00" <c:if test="${opent eq '17:00'}">selected</c:if>>17:00</option>
                                <option value="18:00" <c:if test="${opent eq '18:00'}">selected</c:if>>18:00</option>
                                <option value="19:00" <c:if test="${opent eq '19:00'}">selected</c:if>>19:00</option>
                                <option value="20:00" <c:if test="${opent eq '20:00'}">selected</c:if>>20:00</option>
                                <option value="21:00" <c:if test="${opent eq '21:00'}">selected</c:if>>21:00</option>
                                <option value="22:00" <c:if test="${opent eq '22:00'}">selected</c:if>>22:00</option>
                                <option value="23:00" <c:if test="${opent eq '23:00'}">selected</c:if>>23:00</option>
                                <option value="24:00" <c:if test="${opent eq '24:00'}">selected</c:if>>24:00</option>
                            </select>
                        </div>
                        <fmt:formatDate value="${open.r_closet}" pattern="HH:mm" var="closet"/>
                        <label for="r_closetS" class="col-md-1 col-sm-12 col-form-label">~</label>
                        <div class="col-md-4 col-sm-6">
                            <select class="form-select" name="restOpen.r_closetS" id="r_closetS">
                                <!-- DB에서 R_OPENT 데이터 들고와서 맞는곳에 selected 속성 부여해야함 -->
                                <option value="01:00" <c:if test="${closet eq '01:00'}">selected</c:if> >01:00</option>
                                <option value="02:00" <c:if test="${closet eq '02:00'}">selected</c:if>>02:00</option>
                                <option value="03:00" <c:if test="${closet eq '03:00'}">selected</c:if>>03:00</option>
                                <option value="04:00" <c:if test="${closet eq '04:00'}">selected</c:if>>04:00</option>
                                <option value="05:00" <c:if test="${closet eq '05:00'}">selected</c:if>>05:00</option>
                                <option value="06:00" <c:if test="${closet eq '06:00'}">selected</c:if>>06:00</option>
                                <option value="07:00" <c:if test="${closet eq '07:00'}">selected</c:if>>07:00</option>
                                <option value="08:00" <c:if test="${closet eq '08:00'}">selected</c:if>>08:00</option>
                                <option value="09:00" <c:if test="${closet eq '09:00'}">selected</c:if>>09:00</option>
                                <option value="10:00" <c:if test="${closet eq '10:00'}">selected</c:if>>10:00</option>
                                <option value="11:00" <c:if test="${closet eq '11:00'}">selected</c:if>>11:00</option>
                                <option value="12:00" <c:if test="${closet eq '12:00'}">selected</c:if>>12:00</option>
                                <option value="13:00" <c:if test="${closet eq '13:00'}">selected</c:if>>13:00</option>
                                <option value="14:00" <c:if test="${closet eq '14:00'}">selected</c:if>>14:00</option>
                                <option value="15:00" <c:if test="${closet eq '15:00'}">selected</c:if>>15:00</option>
                                <option value="16:00" <c:if test="${closet eq '16:00'}">selected</c:if>>16:00</option>
                                <option value="17:00" <c:if test="${closet eq '17:00'}">selected</c:if>>17:00</option>
                                <option value="18:00" <c:if test="${closet eq '18:00'}">selected</c:if>>18:00</option>
                                <option value="19:00" <c:if test="${closet eq '19:00'}">selected</c:if>>19:00</option>
                                <option value="20:00" <c:if test="${closet eq '20:00'}">selected</c:if>>20:00</option>
                                <option value="21:00" <c:if test="${closet eq '21:00'}">selected</c:if>>21:00</option>
                                <option value="22:00" <c:if test="${closet eq '22:00'}">selected</c:if>>22:00</option>
                                <option value="23:00" <c:if test="${closet eq '23:00'}">selected</c:if>>23:00</option>
                                <option value="24:00" <c:if test="${closet eq '24:00'}">selected</c:if>>24:00</option>
                            </select>
                        </div>
                    </div>
                    <c:set value="${restClosed}" var="closed"></c:set>
                    <div class="row">
                        <label for="w_code" class="col-md-3 col-sm-12 col-form-label">휴무요일</label>
                        <div class="col-md-9 col-sm-12">
                            <select class="form-select" name="restClosed.w_code" id="w_code">
                                <!-- DB에서 WEEK_CODE 데이터 들고와서 맞는곳에 selected 속성 부여해야함 -->
                                <option value="0" <c:if test="${closed eq '0'}">selected</c:if>>일</option>
                                <option value="1" <c:if test="${closed eq '1'}">selected</c:if>>월</option>
                                <option value="2" <c:if test="${closed eq '2'}">selected</c:if>>화</option>
                                <option value="3" <c:if test="${closed eq '3'}">selected</c:if>>수</option>
                                <option value="4" <c:if test="${closed eq '4'}">selected</c:if>>목</option>
                                <option value="5" <c:if test="${closed eq '5'}">selected</c:if>>금</option>
                                <option value="6" <c:if test="${closed eq '6'}">selected</c:if>>토</option>
                            </select>
                        </div>
                    </div>

                    <h4>결제정보</h4>
                    <hr>
					<c:set value="${rest.r_minprice}" var="min"/>
                    <div class="row">
                        <label for="r_minprice" class="col-md-3 col-sm-12 col-form-label">최소주문금액</label>
                        <div class="col-md-9 col-sm-12">
                            <select class="form-select" name="r_minprice" id="r_minprice">
                                <!-- DB에서 최소주문금액 데이터 들고와서 맞는곳에 selected 속성 부여해야함 -->
                                <option value="0" <c:if test="${min eq '0'}">selected</c:if>>0</option>
                                <option value="1000" <c:if test="${min eq '1000'}">selected</c:if>>1000</option>
                                <option value="2000" <c:if test="${min eq '2000'}">selected</c:if>>2000</option>
                                <option value="3000" <c:if test="${min eq '3000'}">selected</c:if>>3000</option>
                                <option value="4000" <c:if test="${min eq '4000'}">selected</c:if>>4000</option>
                                <option value="5000" <c:if test="${min eq '5000'}">selected</c:if>>5000</option>
                                <option value="6000" <c:if test="${min eq '6000'}">selected</c:if>>6000</option>
                                <option value="7000" <c:if test="${min eq '7000'}">selected</c:if>>7000</option>
                                <option value="8000" <c:if test="${min eq '8000'}">selected</c:if>>8000</option>
                                <option value="9000" <c:if test="${min eq '9000'}">selected</c:if>>9000</option>
                                <option value="10000" <c:if test="${min eq '10000'}">selected</c:if>>10000</option>
                                <option value="11000" <c:if test="${min eq '11000'}">selected</c:if>>11000</option>
                                <option value="12000" <c:if test="${min eq '12000'}">selected</c:if>>12000</option>
                                <option value="13000" <c:if test="${min eq '13000'}">selected</c:if>>13000</option>
                                <option value="14000" <c:if test="${min eq '14000'}">selected</c:if>>14000</option>
                                <option value="15000" <c:if test="${min eq '15000'}">selected</c:if>>15000</option>
                                <option value="16000" <c:if test="${min eq '16000'}">selected</c:if>>16000</option>
                                <option value="17000" <c:if test="${min eq '17000'}">selected</c:if>>17000</option>
                                <option value="18000" <c:if test="${min eq '18000'}">selected</c:if>>18000</option>
                                <option value="19000" <c:if test="${min eq '19000'}">selected</c:if>>19000</option>
                                <option value="20000" <c:if test="${min eq '20000'}">selected</c:if>>20000</option>
                                <option value="21000" <c:if test="${min eq '21000'}">selected</c:if>>21000</option>
                                <option value="22000" <c:if test="${min eq '22000'}">selected</c:if>>22000</option>
                                <option value="23000" <c:if test="${min eq '23000'}">selected</c:if>>23000</option>
                                <option value="24000" <c:if test="${min eq '24000'}">selected</c:if>>24000</option>
                                <option value="25000" <c:if test="${min eq '25000'}">selected</c:if>>25000</option>
                                <option value="26000" <c:if test="${min eq '26000'}">selected</c:if>>26000</option>
                                <option value="27000" <c:if test="${min eq '27000'}">selected</c:if>>27000</option>
                                <option value="28000" <c:if test="${min eq '28000'}">selected</c:if>>28000</option>
                                <option value="29000" <c:if test="${min eq '29000'}">selected</c:if>>29000</option>
                                <option value="30000" <c:if test="${min eq '30000'}">selected</c:if>>30000</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">수정하기</button>
                            <a href="/" class="btn btn-light">취소하기</a>
                            <a href="#" onclick="deleteConfirm('${rest.r_id}')" class="btn btn-danger">삭제하기</a>
                        </div>
                    </div>

                </form>
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