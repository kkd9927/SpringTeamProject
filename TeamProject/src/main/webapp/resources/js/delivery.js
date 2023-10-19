// 모든 view에서 공통으로 사용되는 JS

// DOM(document)이 준비되면 브라우저 사이즈를 감지하여 클래스 결정
$(function() {
    let screenWidth = $(window).width();

    if (screenWidth <= 1200) {
        $(".container-md").attr("class", "container-fluid");
    } else {
        $(".container-fluid").attr("class", "container-md");
    }
});

// 브라우저 사이즈 변경이 감지되면 클래스 변경
$(window).resize(function () {
    let screenWidth = $(window).width();

    if (screenWidth <= 1200) {
        $(".container-md").attr("class", "container-fluid");
    } else {
        $(".container-fluid").attr("class", "container-md");
    }
});