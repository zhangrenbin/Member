var pageSize=10;
var currPage = 1;
var start = 1;
var editFrmValid;
$(document).ready(function(){
	$('textarea[class*=autosize]').autosize({append: "\n"});
	doSearch();
});

var resetPassFormValid = $("#resetPassForm").validate({
	rules: {
		userPassword: {
			required: true,
			rangelength:[6,18]
		},
		userPassword2: {
			equalTo: "#userPassword"
		}
	},
	messages: {
		userPassword: {
			remote:'密码格式不正确！'
		},
		userPassword2: {
			equalTo:'两次输入的密码不一致'
		}
	}
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
	ajaxs("memb/f_memb_list/page.do?page=" + page + "&rows=" + rows,"post",pa,true,function(data) {
		if(data) {
			$("#memList").html(data);
		}
	},"html");
}

function deleteMemb(id) {
	Alerts.confirm("确定删除此会员?", function(){
		ajaxs("memb/f_memb_del.do","get",{id:id},true,function(data) {
			if(data.success == "true") {
				doSearch(currPage);
			}
		},"json", "删除失败");
	});
}

function resetPasswordDlg(account) {
	$("#resetPassForm")[0].reset();
	resetPassFormValid.resetForm();
	$("#accountlabel").text(account);
	$("#account").val(account);
	$("#resetPassDlg").modal({});
}

function resetPass() {
	if(!$("#resetPassForm").valid()) {
		return;
	}
	var pa = $("#resetPassForm").serialize();
	ajaxs("memb/f_memb_eidt/resetPass.do","post",pa,true,function(data) {
		if(data.success == "true") {
			$("#resetPassDlg").modal('hide');
		}
	});
}

function activeMemb(id) {
	var url = 'memb/f_memb_active.do';
	Alerts.confirm("确定要激活本会员吗?", function() {
		ajaxs(url,"post",{id:id},true,function(data) {
			if(data.success == "true") {
				doSearch(currPage);
				Alerts.alert("激活成功");
			}
		},"json", "激活失败");
	});
}