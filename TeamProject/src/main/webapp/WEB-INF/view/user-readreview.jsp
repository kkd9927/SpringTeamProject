<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="../css/restaurant-manage.css" rel="stylesheet">
</head>

<body>
    <!-- 헤더 -->
    <nav class="navbar navbar-light bg-danger position-fixed">
        <div class="container-md">
            <div>
                <a class="navbar-brand" href="/">
                    <img src="../img/no-photo.png">
                </a>
            <!-- * 로그인 전에는 표시안함 -->
                <!-- <span class="navbar-text text-white"><i class="bi bi-geo-alt-fill"></i>&nbsp;<b>주소표시</b></span>
                <button type="button" class="btn btn-danger btn-sm"><i class="bi bi-caret-down-fill"></i></button> -->
                <!-- -->
            </div>

            <!-- 로그인 전 -->
            <div>
                <button type="button" class="btn btn-light">로그인</button>
            </div>

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
            </div>
        </div>
    </nav>

    <!-- 컨텐츠 -->
    <div class="contents">
        <div class="container-md">
            <div class="row">
                <!-- 타이틀 -->
                <div class="col-12">
                    <div class="card bg-light mt-4">
                        <div class="card-body">
                            <div class="image-box" style="width: 100%;">
                                <img src="../resources/img/${reviews[0].u_img}" class="img-fluid rounded-start" alt="User Image" />
                            </div>
                            <h3 class="mt-1"><c:out value="${reviews[0].u_nname}" /></h3>
                        </div>
                    </div>
                </div>
                <!-- 메인 -->
                <div class="col-12">
                    <div class="card bg-light mb-4">
                        <div class="card-body">
                            <span class="h5 fw-bold">리뷰목록</span>
                            <hr>
                            <div class="card">
                                <div class="card-body p-0">
                                    <c:forEach items="${reviews}" var="review">
                                        <!-- 리뷰 템플릿 -->
                                        <div class="reviewitem-box d-grid">
                                            <div class="card p-1 rounded-0 border-0">
                                                <div class="row g-0">
                                                    <div class="col-2">
                                                        <div class="image-box position-relative">
                                                            <img src="../img/no-photo.png" class="img-fluid rounded-start" alt="Review Image" />
                                                            <button class="bg-white bg-opacity-10 border-0 position-absolute bottom-0 end-0"
                                                                onclick="openImageModal()"><i class="bi bi-plus"></i></button>
                                                        </div>
                                                    </div>
                                                    <div class="col-10">
                                                        <div class="card-body position-relative">
                                                            <div class="row reviewtop-box card-title">
                                                                <span class="col-4 fw-bold"><c:out value="${review.u_nname}" /></span>
                                                                <span class="col-2"><i class="bi bi-star-fill text-warning"></i>&nbsp;<c:out value="${review.r_score}" /></span>
                                                                <span class="col-6 reviewdate">
                                                                    <fmt:formatDate pattern="yyyy-MM-dd" value="${review.r_wridate}" />
                                                                </span>
                                                            </div>
                                                            <p class="card-text"><c:out value="${review.r_content}" /></p>
                                                            <button class="bg-white border-0 position-absolute bottom-0 end-0" data-bs-toggle="modal"
                                                                data-bs-target="#rvModal"><span class="badge bg-light text-dark">더보기</span></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <!-- 리뷰 템플릿 -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal" id="rvModal" tabindex="-1" aria-hidden="true" style="display: none;">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">리뷰 상세</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row reviewtop-box card-title">
                        <span class="col-4 fw-bold"><c:out value="${reviews[0].u_nname}" /></span>
                        <span class="col-2"><i class="bi bi-star-fill text-warning"><c:out value="${reviews[0].r_score}" /></i></span>
                        <span class="col-6 reviewdate">
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${reviews[0].r_wridate}" />
                        </span>
                    </div>
                    <div style="display: grid; grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); gap: 10px;">
                        <img src="../img/no-photo.png" class="img-fluid" alt="Image 1" />
                        <img src="../img/no-photo.png" class="img-fluid" alt="Image 2" />
                        <img src="../img/no-photo.png" class="img-fluid" alt="Image 3" />
                    </div>
                    <p class="card-text"><c:out value="${reviews[0].r_content}" /></p>
                </div>
                <div class="modal-footer">
                    <!-- 수정 버튼 -->
                    <button type="button" class="btn btn-warning">수정</button>
                    <!-- 삭제 버튼 -->
                    <button type="button" class="btn btn-danger">삭제</button>
                    <!-- 닫기 버튼 -->
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>
    <!-- img 모달 -->
    <div class="modal" id="imgModal" tabindex="-1" aria-hidden="true" style="display: none;">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">새로운 모달</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" style="display: grid; grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); gap: 10px;">
                    <img src="../img/no-photo.png" class="img-fluid" alt="Image 1" />
                    <img src="../img/no-photo.png" class="img-fluid" alt="Image 2" />
                    <img src="../img/no-photo.png" class="img-fluid" alt="Image 3" />
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
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
    <script>
        function openReviewModal() {
            var modal = document.getElementById("rvModal");
            modal.style.display = "block";
        }
    </script>
    <script>
        function openImageModal() {
            var modal = new bootstrap.Modal(document.getElementById("imgModal"));
            modal.show();
        }
    </script>
    <script src="/js/delivery.js"></script>
</body>
</html>
