let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
    },

    save: function() {
        // alert("user의 save함수");
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
        };

        // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청

        $.ajax({
            // 회원가입 수행 요청
            type: "POST",
            url: "/blog/api/user",
            data: JSON.stringify(data), //http body data
            contentType: "application/json; charset=utf-8", //mime type
            dataType: "json" // 응답이 왔을때 json을 js object로 parsing 해준다.
        }).done(function(resp) {
            alert("회원가입이 완료되었습니다.")

            location.href = "/blog";
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
}

index.init();
