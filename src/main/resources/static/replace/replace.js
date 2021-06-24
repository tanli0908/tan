$(function () {

    /**点击方法*/
    clickTransform = function () {

        var str=[];

        var replaceStr=$("#replaceStr").val();

        var inputExcelType=$("#inputExcelType").val();
        var inputStrType=$("#inputStrType").val();


        var beforRepStr=$("#beforRepStr").val();
        var repalceId=$("#repalceId").val();


        var isexcle=false;
        if(inputExcelType=='excel'){
            str=replaceStr.split("\n");
            isexcle=true;
        }else{
            str[0]=replaceStr;
        }



        var yh=false;
        if(inputStrType=='字符串'){
           yh=true;
        }

        if(isexcle && yh){
            var replacelist=[];
            for(tt in str){
                var sstr= tt.replaceAll(beforRepStr,repalceId);
                replacelist.push('\''+sstr+'\'');
            }
            $("#afferStr").val(replacelist.toString());
        }else{
            $("#afferStr").val(str[0].toString().replaceAll(beforRepStr,repalceId));
        }







    }

});

