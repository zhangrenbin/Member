$(document).ready(function(){
	ajaxs("main/f_user_main/getRecentRecomm.do","get",{},true,function(data) {
		if(data) {
			var htm = '';
			for(var i in data) {
				htm += '<tr>';
				htm += '<td>' + data[i].mAccount + '</td>';
				htm += '<td>' + data[i].mCnname + '</td>';
				if(data[i].mActive) {
					htm += '<td><span class="green">' + "已激活" + '</span></td>';
				} else {
					htm += '<td><span class="red">' + "未激活" + '</span></td>';
				}
				htm += '<td class="hidden-480">' + data[i].mRegdate + '</td>';
				htm += '</tr>';
			}
			$("#recentRecomm").html(htm);
		}
	},"json");
});

var modPassFormValid = $("#modPassForm").validate({
	rules: {
		oldPassword:{
			required: true
		},
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
			remote:'密码格式不正确,请输入6-18位字母或数字！'
		},
		userPassword2: {
			equalTo:'两次输入的密码不一致'
		}
	}
});

function editInfo() {
	window.location.href = basePath + 'main/myInfo.do';
}

function modPass(){
	if(!$("#modPassForm").valid()) {
		return;
	}
	var pa = $("#modPassForm").serialize();
	ajaxs("main/modPass.do","post",pa,true,function(data) {
		if(data.success == "true") {
			Alerts.alert("修改成功！");
			$("#modPassDlg").modal('hide');
			return;
		}
		Alerts.alert(data.msg);
		return;
	});
}

function editPwd(account) {
	$("#modPassForm")[0].reset();
	modPassFormValid.resetForm();
	$("#accountlabel").text(account);
	$("#modPassDlg").modal({});
}