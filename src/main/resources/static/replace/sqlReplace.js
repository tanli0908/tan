$(function () {

    var eqlvl;

    /**点击方法*/
    clickTransform = function () {
        //输入配置末班
        var esql=$("#e-sql").val();
        var divTab= $("#divTab");
         eqlvl=[];
         eqlvl=esql.split("?");
        var len=eqlvl.length-1; //?多少个
        divTab.empty();
        for (var i=0;i<len;i++){
            var vac=eqlvl[i];
            divTab.append(vac.substring(vac.lastIndexOf(" "),vac.length-1)+"<textarea cols='30' rows='8' id='tab1_"+i+"'/>");
        }
        // alert(len+"M--M"+esql);
    }
    pcSql=function (){
        //获取框框的值
        var tabSize=eqlvl.length;
        //获取框框中最大列表
        var  forSize=0;
        //数据存储
        var mapTabData=[];
        for (var i=0;i<tabSize-1;i++){
            //获取所有框框的值
            var tablevalue= $("#tab1_"+i).val();
            var ssd=tablevalue.split("\n");
            if(forSize<ssd.length){
                forSize=ssd.length;
            }
            var obj={};
            obj.name="#tab1_"+i;
            obj.value=ssd;
            mapTabData.push(obj);
        }

        var divValueTab=$("#divValueTab");
        divValueTab.val("");
        //循环最大的一个值 pc多条
        var sqlData="";
        for(var i=0;i<forSize;i++){
            //pc多个参数
            var sqlText="";
            for (var xi=0;xi<tabSize;xi++){
                var tableId="#tab1_"+xi;
                var valuetb=seachDate(mapTabData,tableId,i);

                var vac=eqlvl[xi];
                var cole=vac.substring(vac.lastIndexOf(" "),vac.length-1).trim();
                if(cole.toLowerCase()=="cost"){
                    sqlText=sqlText+eqlvl[xi]+valuetb;
                }else{
                    if(""==valuetb) {
                        sqlText = sqlText + eqlvl[xi];
                    }else{
                        sqlText = sqlText + eqlvl[xi] + "'" + valuetb + "'";
                    }
                }

            }
            // divValueTab.append(sqlText+"\n");
            sqlData=sqlData+sqlText+"\n";
            // console.log(sqlText);
        }
        divValueTab.val(sqlData);
    }

    //获取数组中的值
    seachDate=function (mapTableData,tableId,index){
        var valueName="";
        mapTableData.forEach(function (obj) {
            if(obj.name==tableId){
                valueName=obj.value[index]
                if(valueName==undefined){
                    valueName=obj.value[obj.value.length-1];
                }
            }
        })
        return valueName;
    }
});

