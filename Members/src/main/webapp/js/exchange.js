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
jQuery.validator.addMethod("mobile", function(value, element) { 
	var length = value.length; 
	var mobile = /^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\d{8}$/ ;
	return this.optional(element) || (length == 11 && mobile.test(value)); 
}, "手机号码格式错误");
jQuery.validator.addMethod("idnum", function(value, element) { 
	var length = value.length; 
	var idnum = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/ 
	return this.optional(element) || (length == 18 && idnum.test(value)); 
}, "身份证格式错误");
jQuery.validator.addMethod("account", function(value, element) { 
	var length = value.length; 
	var account = /^[a-zA-z][a-zA-Z0-9_]{3,15}$/ 
	return this.optional(element) || account.test(value); 
}, "账号格式错误");
