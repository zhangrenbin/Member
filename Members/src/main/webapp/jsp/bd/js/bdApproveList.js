var pageSize=10;
var currPage = 1;
var start = 1;

$(document).ready(function(){
	doSearch();
})

function updatePager(totalPages, currentPage,totalCount) {
	if(screen.width < 450) {
		visiblePages = 0;
	}
	//更新显示记录数
	$('#pageinfo').text('每页显示' + pageSize + '条，共' + totalCount + '条');
	$.jqPaginator('#pagination1', {
        totalPages: totalPages,
        visiblePages: 10,
        currentPage: currentPage,
        onPageChange: function (num, type) {
            if("change" == type) {
            	//查询
            	currPage = num;
            	doSearch(currPage);
            }  
        }
    });
}

function doSearch(page, rows) {
	if(!arguments[0]) {
		page = start;
	}
	if(!arguments[1]) {
		rows = pageSize;
	}
	var pa = $("#searchFrm").serialize();
	ajaxs("bd/f_bd_approve/page.do?page=" + page + "&rows=" + rows,"post",pa,true,function(data) {
		if(data) {
			$("#bdList").html(data);
		}
	},"html");
}

function ok(id) {
	Alerts.confirm("确定批准此报单申请?",function(){
		ajaxs("bd/f_bd_approve/ok.do","post",{id:id},true,function(data) {
			if(data.success == 'true') {
				doSearch(currPage);
				Alerts.alert("审批成功");
				return;
			}
			Alerts.alert(data.msg);
		});
	});
}

function reject(id) {
	Alerts.confirm("确定驳回此报单申请?",function(){
		ajaxs("bd/f_bd_approve/reject.do","post",{id:id},true,function(data) {
			if(data.success == 'true') {
				doSearch(currPage);
				Alerts.alert("审批成功");
				return;
			}
			Alerts.alert(data.msg);
		});
	});
	
}