$(function () {

    clickTransform=function () {
        var  sql=$("#tableSql").val();
        $.ajax({
            url:"/sqlSelectController/testCode",
            type: "post",
            dataType: 'json',
            contentType: "application/json",
            data: '{"sqldacode":"'+sql+'"}',
            success:function(result){
                alert(JSON.parse(result));
            }});
    }

});

