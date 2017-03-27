var pageSize=10;
var currPage = 1;
var start = 1;
var editFrmValid;
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
	ajaxs("finance/f_remit_config/page.do?page=" + page + "&rows=" + rows,"post",pa,true,function(data) {
		if(data) {
			$("#remitList").html(data);
		}
	},"html");
}

function remitConfig(id) {
	Alerts.confirm("确认收到汇款?", function(){
		ajaxs("finance/f_remit_config/config.do","get",{id:id},true,function(data) {
			if(data.success == "true") {
				Alerts.alert("确认成功");
				doSearch(currPage);
			}
		},"json", "确认失败");
	});
}

function remitReject(id) {
	Alerts.confirm("确定驳回此汇款通知?", function(){
		ajaxs("finance/f_remit_config/reject.do","get",{id:id},true,function(data) {
			if(data.success == "true") {
				Alerts.alert("驳回成功");
				doSearch(currPage);
			}
		},"json", "驳回失败");
	});
}

function activeMemb(id) {
	var url = 'memb/f_memb_active.do';
	Alerts.confirm("确定要激活本会员吗?", function() {
		ajaxs(url,"post",{id:id},true,function(data) {
			if(data.success == "true") {
				Alerts.alert("激活成功");
			}
		},"json", "激活失败");
	});
}