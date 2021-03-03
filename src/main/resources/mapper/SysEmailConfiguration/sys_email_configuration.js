var sysEmailConfiguration = {};
sysEmailConfiguration.listUrl = BasePath + "/saler_invoice_set/list.json";
sysEmailConfiguration.saveUrl = BasePath + "/saler_invoice_set/save";
sysEmailConfiguration.curEditRowIndex = null;

sysEmailConfiguration.search = function(){
	var reqParam = $("#searchForm").form('getData');
	$("#mainDataGrid").datagrid('options').queryParams = reqParam;
	$("#mainDataGrid").datagrid('options').url = invoiceSet.listUrl;
	$("#mainDataGrid").datagrid('load');
};

sysEmailConfiguration.clear= function(){
	$("#searchForm").form('clear');
	$('#searchForm').find("input").val("");
};

sysEmailConfiguration.validateEdit = function(){
	if (sysEmailConfiguration.curEditRowIndex) != null && sysEmailConfiguration.curEditRowIndex) >= 0){
		if ($("#mainDataGrid").datagrid('validateRow', sysEmailConfiguration.curEditRowIndex)){
			$("#mainDataGrid").datagrid('endEdit', sysEmailConfiguration.curEditRowIndex);
			sysEmailConfiguration.curEditRowIndex = null;
			return true;
		}else{
			showWarn("请填写完正在编辑行的必填项");
			return false;
		}
	}
	
	return true;
};

sysEmailConfiguration.editRow = function(rowIndex, rowData){
	if (sysEmailConfiguration.curEditRowIndex == rowIndex) {
		return;
	}
	if (sysEmailConfiguration.validateEdit()){
		return;
	}
	
	sysEmailConfiguration.curEditRowIndex = rowIndex;
	$("#mainDataGrid").datagrid('beginEdit', sysEmailConfiguration.curEditRowIndex);
	
	//双击编辑的时候，不能编辑唯一项,公司+店铺
	var edCompanyName = $("#mainDataGrid").datagrid('getEditor',{index:rowIndex,field:'companyName'});
	if (edCompanyName) {
		$(edCompanyName.target).combogrid({disabled:true});
		$(edCompanyName.target).combogrid('setValue', rowData.companyName);
	}
	var edShortName = $("#mainDataGrid").datagrid('getEditor', {index:rowIndex,field:'shortName'});
	if (edShortName) {
		$(edShortName.target).combogrid({disabled:true});
		$(edShortName.target).combogrid('setValue', rowData.shortName);
	}
};

sysEmailConfiguration.insertRow  = function(){
	if (!invoiceSet.validateEdit()){
		return;
	}
	
	sysEmailConfiguration.curEditRowIndex= 0;
	$("#mainDataGrid").datagrid('insertRow', {index:0,row:{}});
	$("#mainDataGrid").datagrid('beginEdit', sysEmailConfiguration.curEditRowIndex);
};

sysEmailConfiguration.deleteRow = function(){
	var checkRows = $("#mainDataGrid").datagrid('getChecked');
	if (checkRows.length > 0){
		$.each(checkRows, function(item, row){
			var index = $("#mainDataGrid").datagrid("getRowIndex", row);
			if (index == sysEmailConfiguration.curEditRowIndex) {
				sysEmailConfiguration.curEditRowIndex = null;
			}
			$("#mainDataGrid").datagrid('deleteRow', index);
		});
	}else{
		showWarn("请先选择要删除的行");
	}
};

sysEmailConfiguration.existDelete  = function(deletedRows, insertRow){
	var exist = false;
	if (deletedRows && deletedRows.length > 0) {
		$.each(deletedRows, function(index, item){
			if (item.companyNo == insertRow.companyNo && item.shopNo == insertRow.shopNo) {
				//有相同的数据已经在删除列表，所以可以允许添加
				exist = true;
				return false;
			}
		});
	}
	
	return exist;
};

sysEmailConfiguration.save= function(){
	if (!invoiceSet.validateEdit()){
		return;
	}
	var insertRows = $("#mainDataGrid").datagrid('getChanges','inserted');
	var updatedRows = $("#mainDataGrid").datagrid('getChanges','updated');
	var deletedRows = $("#mainDataGrid").datagrid('getChanges','deleted');
	var validMsg = "";
	var validRow = null;
	$.each(insertRows,function(index, item){
		var shopNoParam = "";
		var uniqueName = "";
		if (item.shopNo) {
			shopNoParam = "&shopNo="+item.shopNo;
			uniqueName = "公司:"+item.companyName + "店铺:" + item.shortName;
		} else {
			shopNoParam = "&shopNoNull=shopNoNull";
			uniqueName = item.companyName;
		}
		$.ajax({
		    type: "POST",
		    url: BasePath + '/saler_invoice_set/get_biz.json',
		    data: "companyNo="+item.companyNo+shopNoParam,
		    async: false,
		    success: function(result){
		    	if (result && result.length > 0) {
		    		if (!invoiceSet.existDelete(deletedRows, item)) {
		    			//只能查到一个满足条件的数据正常
			    		validMsg = uniqueName + "已经存在，不能重复添加";
		    		}
		    	}
		    }
		});
		if (validMsg) {
			validRow = item;
			return false;
		}
    	item.createUser = currentUser.username;
    	item.createTime = new Date().format("yyyy-MM-dd hh:mm:ss");
    });
	
	if (validMsg) {
		var index = $("#mainDataGrid").datagrid("getRowIndex", validRow);
		invoiceSet.curEditRowIndex = index;
		$("#mainDataGrid").datagrid('beginEdit', index);
		showWarn(validMsg);
		return;
	}
	
    $.each(updatedRows,function(index, item){
    	item.updateUser = currentUser.username;
    	item.updateTime = new Date().format("yyyy-MM-dd hh:mm:ss");
    });
	
	var changeRows = {
    		inserted : JSON.stringify(insertRows),
    		updated : JSON.stringify(updatedRows),
    		deleted : JSON.stringify(deletedRows)
    };
    $.post(invoiceSet.saveUrl, changeRows, function(result){
    	if(result){
    		showSuc('保存成功');
    		invoiceSet.search(); 
    	}else{
    		showSuc('保存失败');
    	}
    });
};

sysEmailConfiguration.doImport = function() {
	$.importExcel.open({
		'submitUrl' : BasePath + '/saler_invoice_set/do_import',
		'templateName' : '税务信息配置导入模板.xlsx',
		success : function(data) {
			$.messager.progress('close');
			if (data) {
				if (isNotBlank(data.error)) {
					showError(data.error);
				} else {
					$.importExcel.colse();
					showInfo('数据导入成功');
					invoiceSet.search();
				}
			} else {
				showWarn('导入失败,请联系管理员!');
			}
		},
		error : function() {
			$.messager.progress('close');
			showWarn('数据导入失败，请联系管理员');
		}
	});
};

var exporter = null;
sysEmailConfiguration.pageExportExcel = function() {
	var params = $('#searchForm').form('getData');
	seajs.use([ 'fas/modules/base_setting/set.io' ], function(Excel) {
		exporter = new Excel.exporter($('#mainDataGrid'), '税务信息配置导出',
				invoiceSet.listUrl);
		exporter.export(params);
	});
};

//初始化
$(function(){
	ajaxRequestAsync( BasePath + '/common_util/getCurrentUser',null,function(data){
		currentUser = data;
	});
});