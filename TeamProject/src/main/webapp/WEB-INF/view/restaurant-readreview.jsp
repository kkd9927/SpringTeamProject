<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WELCOME DELIVERY WEB!</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
    
    <!-- Bootstrap 5 JavaScript (including Popper.js) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- jQuery (if needed) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Your custom CSS files -->
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

            <div class="row">
                <!-- 타이틀 -->
                <div class="col-12">
                    <div class="card bg-light mt-4">
                        <div class="card-body">
                            <div class="image-box" style="width: 100%;">
                                <img src="../img/no-photo.png" class="img-fluid rounded-start" th:src="${review}">
                            </div>
                            <h3 class="mt-1" th:text="${review}">${reviews[0].r_bname}</h3>
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
                                <div class="card-body p-0" th:each="review : ${reviews}">
                                    <!-- 리뷰 템플릿 -->
                                    <div class="reviewitem-box d-grid">
                                        <c:forEach items="${reviews}" var="review">
                                            <div class="card p-1 rounded-0 border-0">
                                                <div class="row g-0">
                                                    <div class="col-2">
                                                        <div class="image-box position-relative">
                                                            <img src="../img/no-photo.png" class="img-fluid rounded-start" th:src="${review.r_img}">
                                                            <button class="bg-white bg-opacity-10 border-0 position-absolute bottom-0 end-0"
                                                                onclick="openImageModal()"><i class="bi bi-plus"></i></button>
                                                        </div>
                                                    </div>
                                                    <div class="col-10">
                                                        <div class="card-body position-relative">
                                                            <div class="row reviewtop-box card-title">
                                                                <span class="col-4 fw-bold" th:text="${review.u_nname}"></span>
                                                                <span class="col-2"><i class="bi bi-star-fill text-warning"></i>&nbsp;<span th:text="${review.r_score}"></span></span>
                                                                <span class="col-6 reviewdate" th:text="${#dates.format(review.r_wridate, 'yyyy-MM-dd')}"></span>
                                                            </div>
                                                            <p class="card-text" th:text="${review.r_content}"></p>
                                                            <button class="bg-white border-0 position-absolute bottom-0 end-0" data-bs-toggle="modal"
                                                                data-bs-target="#rvModal"><span class="badge bg-light text-dark">더보기</span></button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                                <!-- 리뷰 템플릿 -->
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
                        <span class="col-4 fw-bold" th:text="${review}">${reviews[0].u_nname}</span>
                        <span class="col-2"><i class="bi bi-star-fill text-warning" th:text="${review}"></i>&nbsp;${reviews[0].r_score}</span>
                        <span class="col-6 reviewdate" th:text="${review}"><fmt:formatDate pattern="yyyy-MM-dd" value="${reviews[0].r_wridate}" /></span>
                    </div>
                    <div style="display: grid; grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); gap: 10px;">
                        <img src="../img/no-photo.png" class="img-fluid" alt="Image 1">
                        <img src="../img/no-photo.png" class="img-fluid" alt="Image 2">
                        <img src="../img/no-photo.png" class="img-fluid" alt="Image 3">
                    </div>
                    <p class="card-text" th:text="${review}">${reviews[0].r_content}</p>
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
                <div class "modal-body" style="display: grid; grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); gap: 10px;">
                    <img src="../img/no-photo.png" class="img-fluid" alt="Image 1">
                    <img src="../img/no-photo.png" class="img-fluid" alt="Image 2">
                    <img src="../img/no-photo.png" class="img-fluid" alt="Image 3">
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
            modal.style display = "block";
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
