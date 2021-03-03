$(function () {

    var sqlObj={};
    var javaObject={};
    var jdbcObject={};
    var ccleng=[];
    /**点击方法*/
    clickTransform = function () {

        var tablesql = $('#tableSql').val();
        //tablesql=tablesql.replaceAll("`","");
        //获取表名
        var tableName = tablesql.substring(tablesql.indexOf('TABLE') + 5, tablesql.indexOf('(')).trim();
        console.log("tableName" + tableName);

        var array = searchCreateColumData(tablesql);
        sqltableObj(tableName, array);
        javaVOData(tableName, array);
    },
        /**解析创建表的语句列*/
        searchCreateColumData = function (tablesql) {
            //解析创建表的语句获取所有 列名 类型  注解
            var columnsString = tablesql.substring(tablesql.indexOf('(') + 1, tablesql.lastIndexOf(')'));
            //console.log("columnsString:" + columnsString);
            columnsString = columnsString.substring(0, columnsString.lastIndexOf("PRIMARY") - 7);
            var columList = columnsString.split("',");
            //console.log("columList:" + columList.length);

            var array = new Array();
            for (var i = 0; i < columList.length; i++) {
                var columNameList = columList[i].split(" ");

                var columNameList = columNameList.filter(function (s) {
                    return s && s.trim();
                });
                if(columNameList[0]!=undefined){
                    if ("KEY" != columNameList[0].toLocaleUpperCase() || "PRIMARY" != columNameList[0].toLocaleUpperCase()) {
                        var columData = {};
                        columData.columName = replaceCcheck(columNameList[0]);
                        columData.columNameType = columNameList[1];
                        columData.columComment = columNameList[columNameList.length - 1];
                        array.push(columData);
                    }
                }
            }
            return array;
        }
        ,
        /**sqlTable转换**/
        sqltableObj = function (tableName, array) {
            /*table */
            var obj = {};
            obj.id = "tableColumnDiv";
            obj.tableName = tableName;
            obj.list = array;
            sqlObj.list=array;
            createTable(obj);
        },
        /**替换特殊的符号` */
        replaceCcheck = function (str) {
            return str.replaceAll("`", "").replaceAll("'", "");
        },
        /**驼峰名称转换*/
        humpTransform = function (strName) {
            var arr = strName.split('_')
            return arr.map(function (item, index) {
                if (index === 0) {
                    return item
                } else {
                    return item[0].toUpperCase() + item.slice(1)
                }
            }).join('')
        },
        /**j转换成JAVAD对象表格的操作*/
        javaVOData = function (tableName, array) {
            /*java**/
            var obj1 = {};
            obj1.id = "tableVoDiv";
            obj1.tableName = humpTransform(replaceCcheck(tableName));
            var arryTransform = new Array();
            for (var i = 0; i < array.length; i++) {
                var pojo = {};
                pojo.columComment = humpTransform(array[i].columComment);
                pojo.columName = humpTransform(array[i].columName);


                var columNameTypes = humpTransform(array[i].columNameType);
                if (columNameTypes.indexOf("(") != -1) {
                    columNameTypes = columNameTypes.substring(0, columNameTypes.indexOf("(")).toUpperCase()
                }
                columNameTypes = jdbcToJavaType(columNameTypes.toUpperCase());
                pojo.columNameType = columNameTypes;
                pojo.tableColumName = array[i].columName;
                pojo.tablejdbcType = jdbcToJavaTypeChar(array[i].columNameType);
                arryTransform.push(pojo);
            }
            obj1.list = arryTransform;
            javaObject.list=arryTransform;
            jdbcObject.list=arryTransform;
            jdbcObject.tableName=tableName;
            jdbcObject.javaObjctName=obj1.tableName;
            createTable(obj1);

        },
        /**数据库类型转换成java类型*/
        jdbcToJavaType = function (inKey) {
            var arry = [
                {key: "CHAR", value: "String"},
                {key: "VARCHAR", value: "String"},
                {key: "NUMERIC", value: "BigDecimal"},
                {key: "DECIMAL", value: "BigDecimal"},
                {key: "BIT", value: "Boolean"},
                {key: "TINYINT", value: "Byte"},
                {key: "SMALLINT", value: "Short"},
                {key: "TINYINT", value: "Integer"},
                {key: "INT", value: "Integer"},
                {key: "BIGINT", value: "Long"},
                {key: "REAL", value: "Float"},
                {key: "FLOAT", value: "Double"},
                {key: "DOUBLE", value: "Double"},
                {key: "DATE", value: "Date"},
                {key: "DATETIME", value: "Date"},
                {key: "TIME", value: "Time"},
                {key: "TIMESTAMP", value: "Timestamp"}
            ];
            for (var i = 0; i < arry.length; i++) {
                if (inKey == arry[i].key) {
                    return arry[i].value;
                }
            }
            return "";
        },
        /**创table结构*/
        createTable = function (obj) {
            var tableName = "表名解释失败";
            if (obj.tableName != undefined) {
                tableName = obj.tableName;
            }
            ;
            var div = $('#' + obj.id);
            div.empty(); //清空重新加
            var tableView = '<table id="tableColumn" border="1" cellspacing="0" width="400px">' +
                '                    <tr>' +
                '                        <td colspan="3">table对应字段名列</td>' +
                '                    </tr>' +
                '                    <tr>' +
                '                        <td colspan="1">表名</td>' +
                '                        <td colspan="2">' + replaceCcheck(tableName) + '</td>' +
                '                    </tr>';

            var arry = obj.list;
            if (arry != undefined && arry.length > 0) {
                for (var i = 0; i < arry.length; i++) {
                    var traddValue = '<tr>' + "<td>" + replaceCcheck(arry[i].columName) + "</td>"
                        + "<td>" + replaceCcheck(arry[i].columNameType) + "</td>" +
                        "<td>" + replaceCcheck(arry[i].columComment) + "</td>" + '</tr>';

                    tableView = tableView + traddValue;
                }
            }
            tableView = tableView + '</table>';
            div.append(tableView);
        },
        /**生成VO对象*/
        generateVOObjects=function(){
           if($.isEmptyObject(javaObject)){
               // alert("请先生成结构对象");
               clickTransform();
           }
           var showStr="";
            var javaObj=javaObject.list;
           for(var i=0;i<javaObj.length;i++){
               console.log(javaObj[i].columComment+"==="+javaObj[i].columName+"======"+javaObj[i].columNameType)
               var columnPirvate='/**'+javaObj[i].columComment+'*/</br>' +
                   "private "+javaObj[i].columNameType+" "+javaObj[i].columName+"; </br>"
               showStr+=columnPirvate;
           }

           // $('#javaVo').val(showStr);
            $('#generateVoDiv').empty();
            $("#generateVoDiv").append(showStr);


        }
        /**开*闭*/
        ,openClose=function(id){
        if(document.getElementById(id).style.display=='none'){
            document.getElementById(id).style.display='block';
        }else{
            document.getElementById(id).style.display='none';
        }
    },
        /**选中**/
        checkBoxName=function(){
           var checkBox= $("input[type='checkbox'][checked][name='generateSQl']");
            ccleng=[];
            for(var i=0;i<checkBox.length;i++){
                if(checkBox[i].checked){
                    ccleng.push(checkBox[i].value)
                }
            }

        },
        /**组装SQL  mapper文件**/
        generateSqlTable=function () {
            if($.isEmptyObject(jdbcObject)){
                clickTransform();
                // alert("请先生成结构对象")
            }

            checkBoxName();



            var mapperxml="";


            for (var i=0;i<ccleng.length;i++){
                if(ccleng[i]==1){
                    mapperxml+= generateCreateReturnMpper(jdbcObject);
                    mapperxml+="";
                }
                if(ccleng[i]==2){
                    mapperxml+=baseColumnListSQL(jdbcObject);
                    mapperxml+="";
                }
                if(ccleng[i]==3){
                    mapperxml+=searchConditionData(jdbcObject);
                    mapperxml+="";
                }
                if(ccleng[i]==4){
                    mapperxml+=selectCount(jdbcObject);
                    mapperxml+="";
                }
                if(ccleng[i]==5){
                    mapperxml+=selectPage(jdbcObject);
                    mapperxml+="";
                }
                if(ccleng[i]==6){
                    mapperxml+=insertSelective(jdbcObject);
                    mapperxml+="";
                }
                if(ccleng[i]==7){
                    mapperxml+=updateByPrimaryKeySelective(jdbcObject);
                    mapperxml+="";
                }
                if(ccleng[i]==8){
                    mapperxml+=deleteSelective(jdbcObject);
                    mapperxml+="";
                }


            }

            document.getElementById("generateSqlJDBCDiv_id_sql").innerHTML = "";
            document.getElementById("generateSqlJDBCDiv_id_sql").innerHTML = mapperxml;


    },
        /**汇总语句*/
        selectCount=function(jdbcObject){
            var selectCount='<select id="selectCount" resultType="java.lang.Integer">\n';
            selectCount+='\t\t SELECT COUNT(1) as s FROM '+replaceCcheck(jdbcObject.tableName)+' WHERE 1=1\n';
            selectCount+='\t\t <include refid="condition"/>\n';
            return selectCount+='</select>\n';


        },
        /**分页语句*/
        selectPage=function(jdbcObject){
            var selectPage='<select id="selectByPage" resultMap="BaseResultMap" parameterType="map">\n';
            selectPage+='\t\t  SELECT <include refid="Base_Column_List"/> FROM '+replaceCcheck(jdbcObject.tableName)+' WHERE 1=1 \n';
            selectPage+='\t\t <include refid="condition"/>\n';
            selectPage+='\t\t LIMIT #{page.startRowNum} ,#{page.pageSize}\n';
            return selectPage+='</select>\n';


        },
        /**分页语句*/
        insertSelective=function(jdbcObject){
            var selectPage='<insert id="insertSelective" parameterType="待写入返回对象">\n';
            selectPage+=' \t INSERT INTO '+replaceCcheck(jdbcObject.tableName)+'  \n';
            selectPage+='\t <trim prefix="(" suffix=")" suffixOverrides=",">\n';
            var jdbcTableObj= jdbcObject.list;
            for(var i=0;i<jdbcTableObj.length;i++){
                selectPage+='\t\t<if test="'+jdbcTableObj[i].columName+' != null">\n';
                selectPage+='\t\t\t '+jdbcTableObj[i].tableColumName+',\n';
                selectPage+='\t\t</if>\n';
            }
            selectPage+='\t</trim>\n';

            selectPage+='\t<trim prefix="values (" suffix=")" suffixOverrides=",">\n';
            for(var i=0;i<jdbcTableObj.length;i++) {
                selectPage += '\t\t<if test="'+jdbcTableObj[i].columName+'  != null">\n';
                selectPage += '\t\t\t   #{'+jdbcTableObj[i].columName+',jdbcType='+jdbcTableObj[i].tablejdbcType+'},\n';
                selectPage += ' \t\t</if>\n';
            }
            selectPage+='\t</trim>\n';
            selectPage+='</insert>\n';
            return selectPage;
        },
        /**更新语句根据第一个条件处理**/
        updateByPrimaryKeySelective=function(){
            var updateByPrimaryKeySelective='<update id="updateByPrimaryKeySelective" parameterType="待补充">\n';
            updateByPrimaryKeySelective+='   UPDATE '+replaceCcheck(jdbcObject.tableName)+' \n';
            updateByPrimaryKeySelective+='\t<set>\n';
            var jdbcTableObj= jdbcObject.list;
            var ttu=true;
            for(var i=0;i<jdbcTableObj.length;i++) {
                if(jdbcTableObj.length-1==i){
                    ttu=false;
                }
                updateByPrimaryKeySelective += '\t\t<if test="' + jdbcTableObj[i].columName + ' != null">\n';
                updateByPrimaryKeySelective += ' \t\t\t' + jdbcTableObj[i].tableColumName + ' = #{'+jdbcTableObj[i].columName+',jdbcType='+jdbcTableObj[i].tablejdbcType+'}';
                if(!ttu){
                    updateByPrimaryKeySelective+=',\n';
                }else{
                    updateByPrimaryKeySelective+=',\n';
                };
                updateByPrimaryKeySelective += '\t\t</if>\n';
            }
            updateByPrimaryKeySelective+='\t</set>\n';
            updateByPrimaryKeySelective+=' WHERE '+jdbcTableObj[0].tableColumName+' = #{' + jdbcTableObj[0].tableColumName + ',jdbcType='+jdbcTableObj[0].tablejdbcType+'}\n';
            updateByPrimaryKeySelective+='</update>\n';
            return updateByPrimaryKeySelective;


        },
        /**删除根据条件**/
        deleteSelective=function(){
            var updateByPrimaryKeySelective=' <DELETE id="deleteSelective">\n';
            updateByPrimaryKeySelective+='   DELETE FROM '+replaceCcheck(jdbcObject.tableName)+' \n';
            updateByPrimaryKeySelective+=' \t WHERE \n';
            var jdbcTableObj= jdbcObject.list;
            var ttu=true;
            for(var i=0;i<jdbcTableObj.length;i++) {
                if(jdbcTableObj.length-1==i){
                    ttu=false;
                }
                updateByPrimaryKeySelective += '\t\t<if test="' + jdbcTableObj[i].columName + ' != null">\n';

                updateByPrimaryKeySelective += ' \t\t\t AND ' + jdbcTableObj[i].tableColumName + ' = #{'+jdbcTableObj[i].columName+',jdbcType='+jdbcTableObj[i].tablejdbcType+'}';

                if(!ttu){
                    updateByPrimaryKeySelective+='\n';
                }else{
                    updateByPrimaryKeySelective+='\n';
                };
                updateByPrimaryKeySelective += '\t\t</if>\n';
            }
            updateByPrimaryKeySelective+=' WHERE '+jdbcTableObj[0].tableColumName+' = #{' + jdbcTableObj[0].tableColumName + ',jdbcType='+jdbcTableObj[0].tablejdbcType+'}\n';
            updateByPrimaryKeySelective+='</DELETE>\n';
            return updateByPrimaryKeySelective;
        },

        /***公共查询条件*/
        searchConditionData=function(jdbcObject){

            var condition='<sql id="condition">\n';
               condition+='\t<if test="null!=params">\n';
            var jdbcTableObj= jdbcObject.list;
            for(var i=0;i<jdbcTableObj.length;i++){
                    var columns='\t \t<if test="params.'+jdbcTableObj[i].columName+' != null and !\'\'.equals(params.'+jdbcTableObj[i].columName+')">\n';
                    columns+='\t \t AND '+jdbcTableObj[i].tableColumName+' = #{params.'+jdbcTableObj[i].columName+'}\n';
                    columns+=' \t\t</if>\n';
                    condition+=columns;
            }
            condition+='\t</if>\n';
            condition+='</sql>\n';
            return condition;


        },
        /**baseColumnList*/
        baseColumnListSQL=function(jdbcObject){
            var baseColumn="";
            baseColumn+='<sql id="Base_Column_List">\n';
            var jdbcTableObj= jdbcObject.list;
            for(var i=0;i<jdbcTableObj.length;i++){
                if(jdbcTableObj.length-1==i){
                var columns='\t '+jdbcTableObj[i].tableColumName+'\n';
                    baseColumn+=columns;
                }else{
                    var columns='\t '+jdbcTableObj[i].tableColumName+',\n';
                    baseColumn+=columns;
                }

            }
            baseColumn+='</sql>\n';
            return baseColumn;
        },
        /** resultMap */
        generateCreateReturnMpper=function(jdbcObject){
            var baseResultMap="";
              baseResultMap+= '<resultMap id="BaseResultMap" type="待补充返回对象"> \n';
           var jdbcTableObj= jdbcObject.list;
           for(var i=0;i<jdbcTableObj.length;i++){
               var columns='\t<result column="'+jdbcTableObj[i].tableColumName+'" property="'+jdbcTableObj[i].columName+'" jdbcType="'+jdbcTableObj[i].tablejdbcType+'"/>  \n';
               baseResultMap+=columns;
           }
            baseResultMap+='</resultMap>\n';
           return baseResultMap;

        },
        /**JDBC数据类型转成JDBCType */
        jdbcToJavaTypeChar=function(jdbcType) {
            if (jdbcType.indexOf("(") == -1) {
                return jdbcType.toUpperCase();
            } else {
                return jdbcType.substring(0, jdbcType.indexOf("(")).toUpperCase();
            }

     }

});

