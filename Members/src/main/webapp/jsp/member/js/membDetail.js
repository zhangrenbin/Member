var infoFrmValid = $("#infoFrm").validate({
	rules: {
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
		mBccount:{
			required: false,
			digits:true,
			rangelength:[16,19]
		}
	},
	errorPlacement: function (error, element) {
		error.insertAfter(element.closest(".form-group").children(".input-group"));
	}, 
	errorClass:'ml-150 help-block'
});

function toModMode() {
	$("#beforeEdit").hide();
	$("#afterEdit").show();
	$("div.form-group label[mycontrol]").hide();
	$("div.form-group input[mycontrol]").show();
	$("div.form-group textarea[mycontrol]").show();
	$("div.form-group div[mycontrol]").show();
	$("div.form-group span[mycontrol]").show();
	$("div.form-group select[mycontrol]").show();
	//初始化省份
	$("#mProvince").empty();
	ajaxs("dic/getProvince.do","get",{},true,function(data) {
		if(data) {
			var h = "";
			for(var i in data) {
				h += "<option value='" + data[i].nProvid + "'>" + data[i].sProvname + "</option>"
			}
			$("#mProvince").html(h);
			//s设置选中
			$("#mProvince").val(provid);
			loadCity(provid,cityid);
		}
	});
}

function loadCity(provid,selid) {
	//初始城市
	ajaxs("dic/getCity.do","get",{province:provid},true,function(dl) {
		if(dl) {
			var htm = "";
			for(var i in dl) {
				htm += "<option value='" + dl[i].nCityid + "'>" + dl[i].sCityname + "</option>"
			}
			$("#mCity").html(htm);
			//设置选中值
			if(selid) {
				$("#mCity").val(selid);
			}
		}
	});
}

function backToList() {
	//window.location.href = 'app/appManagePage.do';
	history.go(-1);
}

function cancleEdit() {
	$("#beforeEdit").show();
	$("#afterEdit").hide();
	$("div.form-group label[mycontrol]").show();
	$("div.form-group input[mycontrol]").hide();
	$("div.form-group textarea[mycontrol]").hide();
	$("div.form-group div[mycontrol]").hide();
	$("div.form-group span[mycontrol]").hide();
	$("div.form-group select[mycontrol]").hide();
	//复位
	$("#infoFrm")[0].reset();
	infoFrmValid.resetForm();
}

function modMemb() {
	if(!$('#infoFrm').valid()) return;
	$('#infoFrm').submit();
}

function doValid() {
	$('#infoFrm').valid();
}