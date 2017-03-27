var pageSize=10;
var currPage = 1;
var start = 1;
$(document).ready(function(){
	doSearch();
});

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
	ajaxs("finance/f_withDraw_approve/page.do?page=" + page + "&rows=" + rows,"post",pa,true,function(data) {
		if(data) {
			$("#wdList").html(data);
		}
	},"html");
}

function ok(id) {
	Alerts.confirm("确认将已经完成打款?", function(){
		ajaxs("finance/f_withDraw_approve/ok.do","post",{id:id},true,function(data) {
			if(data.success == "true") {
				Alerts.alert("确认成功");
				doSearch(currPage);
			}
		},"json", "确认失败");
	});
}

function reject(id) {
	Alerts.prompt("驳回原因", function(res){
		ajaxs("finance/f_withDraw_approve/reject.do","post",{id:id,msg:res},true,function(data) {
			if(data.success == "true") {
				Alerts.alert("驳回成功");
				doSearch(currPage);
			}
		},"json", "驳回失败");
	});
}