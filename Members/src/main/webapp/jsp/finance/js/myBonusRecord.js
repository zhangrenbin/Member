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
	ajaxs("finance/f_bonus_record/page.do?page=" + page + "&rows=" + rows,"post",pa,true,function(data) {
		if(data) {
			$("#recordList").html(data);
		}
	},"html");
}

function baodan(id) {
	Alerts.confirm("确定要提交报单?", function(){
		ajaxs("finance/f_bonus_record/baodan.do","post",{id:id},true,function(data) {
			if(data.success == "true") {
				Alerts.alert("提交成功");
				doSearch(currPage);
			}
		},"json", "提交失败");
	});
}

function chuli(id) {
	Alerts.confirm("确定将此报单置为已处理?", function(){
		ajaxs("finance/f_bonus_record/chuli.do","post",{id:id},true,function(data) {
			if(data.success == "true") {
				Alerts.alert("处理成功");
				doSearch(currPage);
			}
		},"json", "处理失败");
	});
}