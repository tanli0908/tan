<!DOCTYPE html>
<head>
    <title>SysEmailConfiguration需要修改title</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <#include "/WEB-INF/ftl/common/header.ftl" >
    <script type="text/javascript" src="${resourcesUrl}/fas/resources/js/modules/cost/costImport.js?version=${version}"></script>
    <script type="text/javascript" src="${resourcesUrl}/fas/resources/js/common/fas.2.0.js?version=${version}"></script>
    <script type="text/javascript" src="${resourcesUrl}/fas/resources/js/modules/base_setting/sys_email_configuration.js?version=${version}"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false">
		 <@p.toolbar id="toolbar" listData=[
				 {"id":"btn-search","title":"查询","iconCls":"icon-search","action" : "sysEmailConfiguration.search()", "type":0},
	             {"id":"btn-remove","title":"清空","iconCls":"icon-empty", "action" : "sysEmailConfiguration.clear()","type":0},
	             {"id":"btn-import","title":"导入","iconCls":"icon-import","action":"sysEmailConfiguration.doImport()","type":0},
	             {"id":"btn-export","title":"导出","iconCls":"icon-export","action":"sysEmailConfiguration.pageExportExcel()","type":0}
	           ]
			/>
		<#--搜索start-->
		<div class="search-div">
			     <form name="searchForm" id="searchForm" method="post">
	       		 	<table class="form-tb">
	       		 		<col width="100" />
						<col  />
	       		 		<col width="100" />
						<col  />
	       		 		<col width="100" />
						<col  />
	       		 		<col width="100" />
						<col  />
						 <tbody>
						  <tr>
						  
                                                                        <td style="text-algin:right;height:60px;">主键ID：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="id" id="id" size="80" maxLength="30"/>
                                         </td>
                                                                                                                  <td style="text-algin:right;height:60px;">品牌部编号：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="brandUnitNo" id="brandUnitNo" size="80" maxLength="30"/>
                                         </td>
                                                                                                                  <td style="text-algin:right;height:60px;">品牌部名称：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="brandUnitName" id="brandUnitName" size="80" maxLength="30"/>
                                         </td>
                                         </tr><tr>                                                                            <td style="text-algin:right;height:60px;">邮箱地址：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="emailAddr" id="emailAddr" size="80" maxLength="30"/>
                                         </td>
                                                                                                                  <td style="text-algin:right;height:60px;">1.启用 0.禁用：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="status" id="status" size="80" maxLength="30"/>
                                         </td>
                                                                                                                  <td style="text-algin:right;height:60px;">备注：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="remark" id="remark" size="80" maxLength="30"/>
                                         </td>
                                         </tr><tr>                                                                            <td style="text-algin:right;height:60px;">建档人：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="createUser" id="createUser" size="80" maxLength="30"/>
                                         </td>
                                                                                                                  <td style="text-algin:right;height:60px;">建档时间：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="createTime" id="createTime" size="80" maxLength="30"/>
                                         </td>
                                                                                                                  <td style="text-algin:right;height:60px;">修改时间：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="updateTime" id="updateTime" size="80" maxLength="30"/>
                                         </td>
                                         </tr><tr>                                                                            <td style="text-algin:right;height:60px;">修改人：</td>
                                        <td>
                                                                                    <input type="text" class="inputtxt" name="updateUser" id="updateUser" size="80" maxLength="30"/>
                                         </td>
                                                                                                       </tr>
	       		 		 </tbody>
	       		 	</table>
				</form>
		</div>
	</div>
	 		
	<div  data-options="region:'center',border:false">
	     <div class="easyui-layout" data-options="fit:true" id="subLayout">
			 <#--工具栏   -->  
			<div data-options="region:'north',border:false">
				<@p.toolbar id="toolbar3" listData=[
					 {"id":"btn-insert","title":"新增行","iconCls":"icon-add-row", "action" : "sysEmailConfiguration.insertRow()", "type":0},
		             {"id":"btn-remove","title":"删除行","iconCls":"icon-del-row", "action" : "sysEmailConfiguration.deleteRow()","type":0},
		             {"id":"btn-save","title":"保存","iconCls":"icon-save", "action" : "sysEmailConfiguration.save()", "type":0}
		           ]
				/>
            </div>
		                   
			<#--列表-->
	        <div data-options="region:'center',border:false" id="dataGridDiv">
			      <@p.datagrid id="mainDataGrid"  loadUrl="" saveUrl=""   defaultColumn="" 
			              isHasToolBar="false" onClickRowEdit="false" pagination="true" selectOnCheck="true" 
			               checkOnSelect="true" rownumbers="true" singleSelect="false"  
				           columnsJsonList="[
				                  {field : 't',checkbox:true,width : 30,notexport:true},
				                  {field : 'id',hidden : 'true',align:'center',notexport:true},
				                  
                                                                                               {field : 'id',title : '主键ID',width : 160,align:'left',halign:'center',
                                            editor:{
                                                type:'validatebox',
                                                options:{
                                                    required:true,
                                                    validType:'maxLength[20]'
                                                }
                                            }
                                  },
                                                                                                                             {field : 'brandUnitNo',title : '品牌部编号',width : 160,align:'left',halign:'center',
                                            editor:{
                                                type:'validatebox',
                                                options:{
                                                    required:true,
                                                    validType:'maxLength[20]'
                                                }
                                            }
                                  },
                                                                                                                             {field : 'brandUnitName',title : '品牌部名称',width : 160,align:'left',halign:'center',
                                            editor:{
                                                type:'validatebox',
                                                options:{
                                                    required:true,
                                                    validType:'maxLength[20]'
                                                }
                                            }
                                  },
                                                                                                                             {field : 'emailAddr',title : '邮箱地址',width : 160,align:'left',halign:'center',
                                            editor:{
                                                type:'validatebox',
                                                options:{
                                                    required:true,
                                                    validType:'maxLength[20]'
                                                }
                                            }
                                  },
                                                                                                                             {field : 'status',title : '1.启用 0.禁用',width : 160,align:'left',halign:'center',
                                            editor:{
                                                type:'validatebox',
                                                options:{
                                                    required:true,
                                                    validType:'maxLength[20]'
                                                }
                                            }
                                  },
                                                                                                                             {field : 'remark',title : '备注',width : 160,align:'left',halign:'center',
                                            editor:{
                                                type:'validatebox',
                                                options:{
                                                    required:true,
                                                    validType:'maxLength[20]'
                                                }
                                            }
                                  },
                                                                                                                                                                                                                                                                                                                 				                  {field : 'createUser',title : '创建人',width : 100,align:'center'},
				                  {field : 'createTime',title : '创建时间',width : 150,align:'center'},
				                  {field : 'updateUser',title : '修改人',width : 100,align:'center'},
				                  {field : 'updateTime',title : '修改时间',width : 150,align:'center'}
				                 ]" 
			         		 jsonExtend='{
	                           onDblClickRow:function(rowIndex, rowData){
			                   	   sysEmailConfiguration.editRow(rowIndex, rowData)
		                   }
			         }'/>
			</div>
		 </div>
	</div>
</body>
</html>