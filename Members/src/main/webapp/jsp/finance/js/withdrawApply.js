var pageSize=10;
var currPage = 1;
var start = 1;
jQuery.validator.addMethod("withdraw_money", function(value, element) { 
	if(isNaN(value)) {
		return false;
	}
	if(value <=0 || value % 100 != 0) {
		return false;
	}
	if(valid < parseInt(value)) {
		return false;
	}
	return true;
}, "提款金额不合法");

$("#withDrawFrm").validate({
	rules: {
		txMoney: {
			required: true,
			withdraw_money:true
		},
		txBAccount: {
			required: true,
			digits:true,
			rangelength:[16,19]
		},
		txBName: {
			required: true
		},
		txBank: {
			required: true
		},
		rRemark: {
			required: true,
			max:200
		}
	}
});

$(document).ready(function(){
    $("#withDrawBtn").click(function() {
    	if(!$("#withDrawFrm").valid()) {
    		return;
    	}
    	var pa =$("#withDrawFrm").serialize();
    	ajaxs("finance/f_withdraw_apply/sub.do","post",pa,true,function(data){
			if(data.success == "true") {
				var jo = eval("(" + data.msg + ")");
				$("#valid").html(jo.valid);
				$("#lock").html(jo.lock);
				valid = jo.valid;
				loadMyWithDrawt(currPage);
				Alerts.alert("提交成功");
				return;
			}
			Alerts.alert(data.msg);
    	});
    });
    loadMyWithDrawt();
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
            	loadMyWithDrawt(currPage);
            }  
        }
    });
}

function loadMyWithDrawt(page, rows) {
	if(!arguments[0]) {
		page = start;
	}
	if(!arguments[1]) {
		rows = pageSize;
	}
	ajaxs("finance/f_withdraw_apply/list.do?page=" + page + "&rows=" + rows,"get",{},true,function(data){
		if(data) {
			$("#withDrawBody").html(data);
		}
	},"html");
}

