var main = {
    init : function () {
        var _this = this;
        $('#btn-pray-save').on('click', function () {
            _this.save();
        })
    },
    save : function () {
        var data = {
            prayType : $("#prayType").val(),
            prayTitle : $("#prayTitle").val(),
            prayContent : $("#prayContent").val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/pray',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function () {
            alert('기도가 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
};

main.init();