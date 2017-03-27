function init() {
	$("#memFrm").validate({
		rules: {
			mAccount: {
				required: true,
				account:true,
				remote : {
					url: 'memb/checkAccount.do'
				}
			},
			mCnname: {
				required: true
			},
			mIdnum: {
				required: true,
				idnum:true
			},
			mMobile: {
				required: true,
				mobile:true
			},
			mBAccount:{
				required: true,
				digits:true,
				rangelength:[16,19]
			},
			mBank:{
				required: true
			},
			mBName:{
				required: true
			}
		}
	});
	$("#createBtn").click(function() {
		if(!$('#memFrm').valid()) e.preventDefault();
		var pa = $("#memFrm").serialize();
	    ajaxs("memb/f_memb_add/addMemb.do","post",pa,false,function(data) {
			if(data.success != "true") {
				Alerts.alert(data.msg);
				return;
			} 
			window.location.href = 'memb/f_memb_list.do';
		});
	});
	loadProv();
}
init();

function loadProv() {
	ajaxs("dic/getProvince.do","get",{},true,function(data) {
		if(data) {
			var htm = '';
			for(var i in data) {
				htm += '<option value="' + data[i].nProvid + '">' + data[i].sProvname + '</option>'
			}
			$("#mProvince").html(htm);
			loadCity($("#mProvince").val());
		} 
	});
}

function loadCity(provid) {
	ajaxs("dic/getCity.do","get",{province:provid},true,function(data) {
		if(data) {
			var htm = '';
			for(var i in data) {
				htm += '<option value="' + data[i].nCityid + '">' + data[i].sCityname + '</option>'
			}
			$("#mCity").html(htm);
		} 
	});
}

function saveAccount(e) {
	var pa = $("#accountFrm").serialize();
    ajaxs("user/createStep_1.do","post",pa,false,function(data) {
		if(data.success != "true") {
			Alerts.alert("用户保存失败！");
			e.preventDefault();
		}
	});
}

function uploadPhoto(id) {
	$.ajaxFileUpload({
        url:'user/uploadPhoto.do',//处理图片脚本
        secureuri :false,
        fileElementId :id,//file控件id
        dataType : 'json',
        success : function (data, status){
        	if(data.success != "true") {
        		Alerts.alert(data.msg);
        	}
        }
	});
}