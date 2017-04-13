$(function(){
	   
	   //默认加载
	   $('#userListtable').DataTable({
		     /* 
		     * bDeferRender 
		     * 是否启用延迟加载：当你使用AJAX数据源时，可以提升速度。 
		     * 默认为false 
		     */  
		    "bDeferRender" : true,
		    /* 
		     * bLengthChange 
		     * 是否允许用户，在下拉列表自定义选择分页大小(10, 25, 50 and 100),需要分页支持 
		     * 默认为true 
		     */  
		    "bLengthChange":true,
		    /* 
		     * bFilter 
		     * 是否启用内置搜索功能：可以跨列搜索。 
		     * 默认为true 
		     */  
		    "bFilter" : true,
		    /* 
		     * bSort 
		     * 是否开启列排序功能，如果想禁用某一列排序，可以在每列设置使用bSortable参数 
		     */  
		    "bSort" : false,
		    /* 
		     * bProcessing 
		     * 是否显示加载时进度条，默认为false 
		     */  
		    "bProcessing" : true,  
		      "sServerMethod" : "POST",
		      "sAjaxSource":[[@{/users/getList}]],
			  "columns":[
			    {"data":"id"},
			    {"data":"userName"},
			    {"data":"nickName"},
			    {"data":"phone"},
			    {"data":"email"},
			    {"data":"status"},
                {
			     "mRender": function ( data, type, full ) {  
                   return "<a href=\"javascript:;\">编辑</a>";
                 }	
                } 
			  ]
			});
   });
