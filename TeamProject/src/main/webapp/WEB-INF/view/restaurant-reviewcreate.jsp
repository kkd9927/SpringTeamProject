<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    <link href="../css/delivery.css" rel="stylesheet">
    <link href="../css/register-form.css" rel="stylesheet>
</head>
<body>
    <!-- 헤더 -->
    <nav class="navbar navbar-light bg-danger position-fixed">
        <div class="container-md">
            <div>
                <a class="navbar-brand" href="/">
                    <img src="no-photo.png" width="30" height="30">
                </a>
            </div>
            <!-- 로그인 전 -->
            <div>
                <button type="button" class="btn btn-light">로그인</button>
            </div>
        </div>
    </nav>

    <!-- 컨텐츠 -->
    <div class="contents">
        <div class="container-md">
            <div class="register-box">
                <form action="/review-input" method="post" class="text-align" enctype="multipart/form-data">
                    <h4>리뷰작성</h4>
                    <hr>
                    <div class="row">
                        <label for="r_lname" class="col-md-3 col-sm-12 col-form-label">상호명
                            <input type="text" id="r_lname" name="r_bname" value="${reviewInput.r_bname}" readonly>
                        </label>
                        <label for="r_nname" class="col-md-3 col-sm-12 col-form-label">닉네임
                            <input type="text" id="r_nname" name="r_nname" value="${reviewInput.u_nname}" readonly>
                        </label>
                    </div>
                    <div class="row">
                        <label for="r_onum" class="col-md-3 col-sm-12 col-form-label">주문번호
                            <input type="text" id="r_onum" name="o_num" value="${reviewInput.o_num}">
                        </label>
                    </div>
                    <div class="row">
                        <label for="r_img" class="col-md-3 col-sm-12 col-form-label">이미지 업로드
                            <input type="file" id="r_img" name="r_img">
                        </label>
                    </div>
                    <div class="row">
                        <label for="r_content" class="col-12 col-form-label">리뷰내용
                            <textarea id="r_content" name="r_content" rows="10">${reviewInput.r_content}</textarea>
                        </label>
                    </div>
                    <div class="row">
                        <label for="r_date" class="col-md-3 col-sm-12 col-form-label">작성날짜
                            <input type="text" id="r_date" name="r_wriDate" value="${reviewInput.r_wriDate}" readonly>
                        </label>
                    </div>
                    <div class="row">
                        <label for="r_score" class="col-md-3 col-sm-12 col-form-label">리뷰점수
                            <input type="text" id="r_score" name="r_score" value="${reviewInput.r_score}">
                            <div class="star-container"></div>
                        </label>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">등록하기</button>
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
