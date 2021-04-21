var main = {
    init : function () {
        var _this = this;
        $('#btn-user-save').on('click', function () {
            _this.save();
        })
    },
    save : function () {
        var data = {
            user_name : $("#user_name").val(),
            user_email : $("#user_email").val(),
            user_church : $("#user_church").val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/user',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
};

main.init();