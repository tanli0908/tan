function clickTable() {
    // 获取带schema的表和不带schema的表
    var diy = "\\s+(join|from)\\s+(\\w+\\.?\\w*)[\\s^]*";
    // String diy = "\\s+(join|from)\\s+((\\w+\\.)\\w+)[\\s^]*";

    // var rule="\\s+(join|from)\\s+(\\w+\\.?\\w*)[\\s^]*"
    var sqlTable = $("#replaceStr").val();
    // var listFrom = sqlTable.split(/\s+(from|FROM)\s+/);

    var fromTableNames = fromTableName(sqlTable);
    console.log("From表名:" + fromTableNames)
    var joinTable = joinTableName(sqlTable);
    console.log("Join表名：" + joinTable);
    insertTable(fromTableNames, joinTable);
    goToHeavyTable(fromTableNames, joinTable);

}

//写入table中
function insertTable(fromTableNames, joinTable) {
    var show = fromTableNames + joinTable;
    show = show.replaceAll(" ", "")
    $("#tableAlls").text(show.substring(0, show.length - 1).split(",").length);
    $("#sqlTableCount").val(show.substring(0, show.length - 1));
}

//去重  goToHeavyTable 中
function goToHeavyTable(fromTableNames, joinTable) {
    var show = fromTableNames + joinTable;
    show = show.substring(0, show.length - 1);
    show = show.replaceAll(" ", "");

    var listsFrom = Array.from(new Set(show.split(",")))
    var showTable = "";
    listsFrom.forEach((obj, idx) => {
        showTable += obj + "\n";
    });

    $("#goToHeavyTables").text(listsFrom.length);
    $("#goToHeavyTable").val(showTable);
}

//Join Table 的所有表名
function joinTableName(sqlTable) {
    sqlTable = sqlTable.toUpperCase();
    var joinTableName = "";
    var listJion = sqlTable.split(new RegExp("JOIN", "i"));
    console.log("ListJoin:" + listJion.length);
    if (listJion.length > 1) {
        var listsFrom = Array.from(new Set(listJion))
        listsFrom.forEach((obj, idx) => {
            console.log(idx + "脚本：" + obj)
            if (idx != 0) {
                if (obj.indexOf("(") == -1 || obj.indexOf("(") > 1) {
                    var tname = joinSql(obj);
                    console.log("表名：" + tname);
                    if (tname.length != 0 && tname != "" && tname != undefined) {
                        joinTableName += tname + ","
                    }
                }
            }
        });
    }
    console.log("输出JION所有表：" + joinTableName);
    return joinTableName;
}

//Join table处理
function joinSql(str) {
    var tableName = "";
    let strLog = $.trim(str);
    let rule = new RegExp("ON", "i")
    if (rule.test(strLog)) {
        var table_as_str = strLog.substring(0, strLog.indexOf(" ON"))
        // console.log(table_as_str)
        tableName = replaceAsName(table_as_str)
        // console.log(strLog)
        // console.log(lowerCaseStrlog)
    }
    return tableName;
}

//from 的所有表名
function fromTableName(sqlTable) {
    sqlTable = sqlTable.toUpperCase();
    var listFrom = sqlTable.split(new RegExp(" FROM ", "i"));
    var listsFrom = Array.from(new Set(listFrom))
    var fromTableName = "";
    listsFrom.forEach((obj, idx) => {

        console.log(idx + "FROM脚本：" + obj)
        if (idx > 0) {
            var tname = fromSql(obj);
            console.log(idx + "FROM表名：" + tname);
            if (tname.length != 0 && tname != "" && tname != undefined) {
                fromTableName += tname + ","
            }
        }
    });
    console.log("FROM输出所有表：" + fromTableName);
    return fromTableName;
}

//from where 处理
function fromSql(str) {
    var tableName = "";
    let strLog = $.trim(str);
    // let rule = new RegExp("WHERE", "i")
    // if (rule.test(strLog)) {
    //     var lowerCaseStrlog = strLog.replaceAll("WHERE", "WHERE");
    //     var table_as_str = strLog.substring(0, lowerCaseStrlog.indexOf("WHERE"))
    //     tableName = replaceAsName(table_as_str)
    // } else {
    console.log("处理from的后面表")
    //子查询  "（" 开头 不做处理
    if (strLog.indexOf("(") != 0) {

        var where_p = strLog.indexOf("WHERE");
        var join_p = strLog.indexOf("JOIN");
        var dh_p = strLog.indexOf(",");

        //join == -1  没有join 有where关联
        if (join_p == -1 && where_p != -1) {

            //带逗号  from 后面表 带逗号  且在where里面 
            if (dh_p != -1 && dh_p < where_p) {
                var rtnotWhereTable = "";
                var forNotWhere = strLog.split(",");
                forNotWhere.forEach(obj => {
                    // console.log("not where: "+obj)
                    var notw = $.trim(obj);
                    if (notw.indexOf("(") == -1) {
                        rtnotWhereTable += replaceAsName(notw) + ",";
                    }
                });
                tableName = rtnotWhereTable;
                tableName = tableName.substring(0, tableName.length - 1);
            } else {
                //只有where
                var table_as_str = strLog.substring(0, strLog.indexOf("WHERE"))
                tableName = replaceAsName(table_as_str)
            }
        }
        // 有join  但是没有where  去join之间的的
        if (join_p != -1 && where_p == -1) {
            var table_as_str = strLog.substring(0, join_p)
            tableName = replaceAsName(table_as_str)
        }
        // //join  where 都有  取where
        if (join_p != -1 && where_p != -1) {
            //where 在 join前
            if (join_p > where_p) {
                //取where 前部分
                strLog = strLog.substring(0, where_p);
                //带逗号  from 后面表 带逗号  且在where里面 
                if (dh_p != -1 && dh_p < where_p) {
                    var rtnotWhereTable = "";
                    var forNotWhere = strLog.split(",");
                    forNotWhere.forEach(obj => {
                        // console.log("not where: "+obj)
                        var notw = $.trim(obj);
                        if (notw.indexOf("(") == -1) {
                            rtnotWhereTable += replaceAsName(notw) + ",";
                        }
                    });
                    tableName = rtnotWhereTable;
                    tableName = tableName.substring(0, tableName.length - 1);
                } else {
                    //只有where
                    var table_as_str = strLog.substring(0, strLog.indexOf("WHERE"))
                    tableName = replaceAsName(table_as_str)
                }
            } else {
                console.log("没处理")
                //取where 前部分
                strLog = strLog.substring(0, join_p);
                //带逗号  from 后面表 带逗号  且在where里面 
                if (dh_p != -1 && dh_p < where_p) {
                    var rtnotWhereTable = "";
                    var forNotWhere = strLog.split(",");
                    forNotWhere.forEach(obj => {
                        // console.log("not where: "+obj)
                        var notw = $.trim(obj);
                        if (notw.indexOf("(") == -1) {
                            rtnotWhereTable += replaceAsName(notw) + ",";
                        }
                    });
                    tableName = rtnotWhereTable;
                    tableName = tableName.substring(0, tableName.length - 1);
                } else {
                    //没有多表 ，分离的情况
                    tableName = replaceAsName(strLog);
                }


            }
        }

        // else{
        //      //子表情况
        //      if(strLog.indexOf("(")==1&& strLog.indexOf(" SELECT")>-1){
        //          console.log("字表")
        //      }
        //     
        //  }
    }
    // }
    return tableName;
    // console.log(strLog);
}

//去除表的别名问题
function replaceAsName(asName) {
    var asNameTrim = $.trim(asName);
    // console.log("replaceAsName  == "+asNameTrim)
    var tableName = asName;
    var hhl = asNameTrim.indexOf(")");
    var kgl = asNameTrim.indexOf(" ");
    if (asNameTrim.length > 0 && (hhl != -1 && kgl > 0)) {
        if (hhl < kgl) {
            tableName = asNameTrim.substring(0, hhl)
        } else {
            tableName = asNameTrim.substring(0, kgl)
        }
    } else {
        tableName = asNameTrim.substring(0, kgl)
    }
    //没有别名
    if (hhl == -1 && kgl == -1) {
        tableName = asName;
    }
    return tableName;
}
