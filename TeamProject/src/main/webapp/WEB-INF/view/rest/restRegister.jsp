<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <!-- 헤더 -->
    <%@ include file="/WEB-INF/view/include/header.jsp" %>
    <div class="contents">
        <div class="container-md">
            <div class="register-box">
                <form action="/rest/restRegister" method="post" class="text-align" >
                    <h4>사업자정보</h4>
                    <hr>

                    <div class="row">
                        <label for="r_licnum" class="col-md-3 col-sm-12 col-form-label">사업자번호</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_licnum" name="r_licnum" class="form-control">
                        </div>
                    </div>
                    
                    <div class="row">
                        <label for="u_id" class="col-md-3 col-sm-12 col-form-label">사업자아이디</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="u_id" name="u_id" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_lname" class="col-md-3 col-sm-12 col-form-label">상호명</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_lname" name="r_lname" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_addr" class="col-md-3 col-sm-12 col-form-label">사업장소재지</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_addr" name="r_addr" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_dtad" class="col-md-3 col-sm-12 col-form-label">상세주소</label>
                        <div class="col-md-9 col-sm-12">
                            <input type="text" id="r_dtad" name="r_dtad" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_tel" class="col-md-3 col-sm-12 col-form-label">매장전화번호</label>
                        <div class="col-md-6 col-sm-4">
                            <input type="text" id="r_tel" name="r_tel" placeholder="'-'제외 9~11자리" value="가게 전화번호" class="form-control" maxlength="11">
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
                            <input type="text" id="r_bname" name="r_bname" class="form-control">
                        </div>
                    </div>

                    <div class="row">
                        <label for="rcaDTOList" class="col-md-3 col-sm-12 col-form-label">카테고리</label>
                        <div class="col-md-9 col-sm-12">
                        	<label><input type="checkbox" name="rcaDTOList[0].c_code" value="0"> 전체</label>
      						<label><input type="checkbox" name="rcaDTOList[1].c_code" value="1"> 치킨</label>
                        	<label><input type="checkbox" name="rcaDTOList[2].c_code" value="2"> 피자</label>
      						<label><input type="checkbox" name="rcaDTOList[3].c_code" value="3"> 한식</label>
                        	<label><input type="checkbox" name="rcaDTOList[4].c_code" value="4"> 고기/족발</label>
      						<label><input type="checkbox" name="rcaDTOList[5].c_code" value="5"> 회</label>
                        	<label><input type="checkbox" name="rcaDTOList[6].c_code" value="6"> 중식</label>
      						<label><input type="checkbox" name="rcaDTOList[7].c_code" value="7"> 일식/돈까스</label>
                        	<label><input type="checkbox" name="rcaDTOList[8].c_code" value="8"> 아시안</label>
      						<label><input type="checkbox" name="rcaDTOList[9].c_code" value="9"> 양식</label>
                        	<label><input type="checkbox" name="rcaDTOList[10].c_code" value="10"> 도시락</label>
      						<label><input type="checkbox" name="rcaDTOList[11].c_code" value="11"> 분식</label>
                        	<label><input type="checkbox" name="rcaDTOList[12].c_code" value="12"> 패스트푸드</label>
      						<label><input type="checkbox" name="rcaDTOList[13].c_code" value="13"> 카페/디저트</label>
                        	<label><input type="checkbox" name="rcaDTOList[14].c_code" value="20"> 포장</label>
      						<label><input type="checkbox" name="rcaDTOList[15].c_code" value="21"> 신속배달</label>
                        	<label><input type="checkbox" name="rcaDTOList[16].c_code" value="22"> 프렌차이즈</label>
      						<label><input type="checkbox" name="rcaDTOList[17].c_code" value="23"> 1인분</label>
                        	<label><input type="checkbox" name="rcaDTOList[18].c_code" value="24"> 야식</label>
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_img" class="col-md-3 col-sm-12 col-form-label">대표사진</label>
                        <div class="col-md-9 col-sm-12">
                            <input class="form-control" type="file" name="r_img" id="r_img">
                        </div>
                    </div>

                    <div class="row">
                        <label for="r_intro" class="col-12 col-form-label">알림사항</label>
                        <div class="col-12">
                            <textarea id="r_intro" name="r_intro" rows="10" class="form-control"></textarea>
                        </div>
                    </div>
                    
                    <div class="row">
                        <label for="r_opentS" class="col-md-3 col-sm-12 col-form-label">영업시간</label>
                        <div class="col-md-4 col-sm-6">
                            <select class="form-select" name="restOpen.r_opentS" id="r_opentS">
                                <!-- DB에서 R_OPENT 데이터 들고와서 맞는곳에 selected 속성 부여해야함 -->
                                <option value="01:00">01:00</option>
                                <option value="02:00">02:00</option>
                                <option value="03:00">03:00</option>
                                <option value="04:00">04:00</option>
                                <option value="05:00">05:00</option>
                                <option value="06:00">06:00</option>
                                <option value="07:00">07:00</option>
                                <option value="08:00">08:00</option>
                                <option value="09:00">09:00</option>
                                <option value="10:00">10:00</option>
                                <option value="11:00">11:00</option>
                                <option value="12:00">12:00</option>
                                <option value="13:00">13:00</option>
                                <option value="14:00">14:00</option>
                                <option value="15:00">15:00</option>
                                <option value="16:00">16:00</option>
                                <option value="17:00">17:00</option>
                                <option value="18:00">18:00</option>
                                <option value="19:00">19:00</option>
                                <option value="20:00">20:00</option>
                                <option value="21:00">21:00</option>
                                <option value="22:00">22:00</option>
                                <option value="23:00">23:00</option>
                                <option value="24:00">24:00</option>
                            </select>
                        </div>
                        <label for="r_closetS" class="col-md-1 col-sm-12 col-form-label">~</label>
                        <div class="col-md-4 col-sm-6">
                            <select class="form-select" name="restOpen.r_closetS" id="r_closetS">
                                <!-- DB에서 R_OPENT 데이터 들고와서 맞는곳에 selected 속성 부여해야함 -->
                                <option value="01:00">01:00</option>
                                <option value="02:00">02:00</option>
                                <option value="03:00">03:00</option>
                                <option value="04:00">04:00</option>
                                <option value="05:00">05:00</option>
                                <option value="06:00">06:00</option>
                                <option value="07:00">07:00</option>
                                <option value="08:00">08:00</option>
                                <option value="09:00">09:00</option>
                                <option value="10:00">10:00</option>
                                <option value="11:00">11:00</option>
                                <option value="12:00">12:00</option>
                                <option value="13:00">13:00</option>
                                <option value="14:00">14:00</option>
                                <option value="15:00">15:00</option>
                                <option value="16:00">16:00</option>
                                <option value="17:00">17:00</option>
                                <option value="18:00">18:00</option>
                                <option value="19:00">19:00</option>
                                <option value="20:00">20:00</option>
                                <option value="21:00">21:00</option>
                                <option value="22:00">22:00</option>
                                <option value="23:00">23:00</option>
                                <option value="24:00">24:00</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="row">
                        <label for="w_code" class="col-md-3 col-sm-12 col-form-label">휴무요일</label>
                        <div class="col-md-9 col-sm-12">
                            <select class="form-select" name="restClosed.w_code" id="w_code">
                                <!-- DB에서 WEEK_CODE 데이터 들고와서 맞는곳에 selected 속성 부여해야함 -->
                                <option value="0">일</option>
                                <option value="1">월</option>
                                <option value="2">화</option>
                                <option value="3">수</option>
                                <option value="4">목</option>
                                <option value="5">금</option>
                                <option value="6">토</option>
                            </select>
                        </div>
                    </div>

                    <h4>결제정보</h4>
                    <hr>

                    <div class="row">
                        <label for="r_minprice" class="col-md-3 col-sm-12 col-form-label">최소주문금액</label>
                        <div class="col-md-9 col-sm-12">
                            <select class="form-select" name="r_minprice" id="r_minprice">
                                <!-- DB에서 최소주문금액 데이터 들고와서 맞는곳에 selected 속성 부여해야함 -->
                                <option value="0">0</option>
                                <option value="1000">1000</option>
                                <option value="2000">2000</option>
                                <option value="3000">3000</option>
                                <option value="4000">4000</option>
                                <option value="5000">5000</option>
                                <option value="6000">6000</option>
                                <option value="7000">7000</option>
                                <option value="8000">8000</option>
                                <option value="9000">9000</option>
                                <option value="10000">10000</option>
                                <option value="11000">11000</option>
                                <option value="12000">12000</option>
                                <option value="13000">13000</option>
                                <option value="14000">14000</option>
                                <option value="15000">15000</option>
                                <option value="16000">16000</option>
                                <option value="17000">17000</option>
                                <option value="18000">18000</option>
                                <option value="19000">19000</option>
                                <option value="20000">20000</option>
                                <option value="21000">21000</option>
                                <option value="22000">22000</option>
                                <option value="23000">23000</option>
                                <option value="24000">24000</option>
                                <option value="25000">25000</option>
                                <option value="26000">26000</option>
                                <option value="27000">27000</option>
                                <option value="28000">28000</option>
                                <option value="29000">29000</option>
                                <option value="30000">30000</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label for="mDTOList" class="col-md-3 col-sm-12 col-form-label">결제수단</label>
                        <div class="col-md-9 col-sm-12">
                        	<label><input type="checkbox" name="mDTOList[0].p_code" value="0"> 현금</label>
                        	<label><input type="checkbox" name="mDTOList[1].p_code" value="1"> 카드</label>
                        	<label><input type="checkbox" name="mDTOList[2].p_code" value="2"> 네이버페이</label>
                        	<label><input type="checkbox" name="mDTOList[3].p_code" value="3"> 카카오페이</label>
                        	<label><input type="checkbox" name="mDTOList[4].p_code" value="4"> 삼성페이</label>
                        	<label><input type="checkbox" name="mDTOList[5].p_code" value="5"> 애플페이</label>
                        </div>
                    </div>



                    <div class="row">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">입력하기</button>
                            <a href="/" class="btn btn-light">취소하기</a>
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