var ajaxs = function(url, type, param, async, successfuction, dataType, errorMsg) {
	var dt = '';
	if(typeof(dataType) == "undefined" || dataType == '') {
		dt = "json";
	}
	$.ajax({
		url : url,
		data : param,
		type : type,
		async: async,
		dataType : dt,
		success : function(data) {
			if(typeof(successfuction) == "undefined" || successfuction == '') {
				return;
			}
			successfuction(data);
		},
		error : function(XMLHttpReques, massage, errorObject) {
			if(typeof(errorMsg) == "undefined" || errorMsg == '') {
				return;
			}
			
		}
	});
}

bootbox.setDefaults({
	/**
	* @optional String
	* @default: en
	* which locale settings to use to translate the three
	* standard button labels: OK, CONFIRM, CANCEL
	*/
	locale: "zh_CN",
	/**
	* @optional Boolean
	* @default: true
	* whether the dialog should be shown immediately
	*/
	show: true,
	/**
	* @optional Boolean
	* @default: true
	* whether the dialog should be have a backdrop or not
	*/
	backdrop: true,
	/**
	* @optional Boolean
	* @default: true
	* show a close button
	*/
	closeButton: true,
	/**
	* @optional Boolean
	* @default: true
	* animate the dialog in and out (not supported in < IE 10)
	*/
	animate: true,
	/**
	* @optional String
	* @default: null
	* an additional class to apply to the dialog wrapper
	*/
	className: "my-modal"
}); 

var Alerts = function() {
	
}

Alerts.alert = function(msg, callback) {
	bootbox.alert(msg,function(){
		if(typeof(callback) == "undefined") {
			return;
		}
		callback();
	});
}

Alerts.confirm = function(msg, callback) {
	bootbox.confirm(msg, function(result) {
		if(typeof(callback) == "undefined") {
			return;
		}
		if(result) {
			callback();
		}
	});
}

Alerts.prompt = function(msg, callback) {
	bootbox.prompt(msg, function(result) {
		if(typeof(callback) == "undefined") {
			return;
		}
		if(result) {
			callback(result);
		}
	});
}

$.validator.setDefaults({
   errorElement: 'div',
   focusInvalid: false,
   ignore: "",
   errorClass: "help-block",
   validClass: "has-info",
	highlight: function (e) {
		$(e).closest('.form-group').removeClass('has-info').addClass('has-error');
	},
	unhighlight: function (e) {
		$(e).closest('.form-group').removeClass('has-error').addClass('has-info');
	},
	success: function (e) {
		$(e).closest('.form-group').removeClass('has-error').addClass("has-info");//.addClass('has-info');
		$(e).remove();
	},
	errorPlacement: function (error, element) {
		if(element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
			var controls = element.closest('div[class*="col-"]');
			if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
			else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
		}
		else if(element.is('.select2')) {
			error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
		}
		else if(element.is('.chosen-select')) {
			error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
		}
		else error.insertAfter(element.parent());
	}
});

function getBasePath() {
	var location = (window.location+'').split('/'); 
	var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
	return basePath;
}

String.prototype.startWith=function(str){  
    if(str==null||str==""||this.length==0||str.length>this.length)  
      return false;  
    if(this.substr(0,str.length)==str)  
      return true;  
    else  
      return false;  
    return true;  
}  
String.prototype.endWith=function(str){  
    if(str==null||str==""||this.length==0||str.length>this.length)  
      return false;  
    if(this.substring(this.length-str.length)==str)  
      return true;  
    else  
      return false;  
    return true;  
}  