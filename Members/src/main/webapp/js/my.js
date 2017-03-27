
function noborder(value, row, index) {
  return 'border:0;';
}

// 展示 提示信息
function showMsg(msg,time){
	var t=time||2000;
	 $.messager.show({
			title:'提示信息',
			msg:msg,
			timeout:t,
			border:false,
			showType:'slide'
		});
}
// ip地址转换为 数字
function ip2int(ip) 
{
    var num = 0;
    ip = ip.split(".");
    if(ip.length!=4){
    	return -1;
    }
    num = Number(ip[0]) * 256 * 256 * 256 + Number(ip[1]) * 256 * 256 + Number(ip[2]) * 256 + Number(ip[3]);
    num = num >>> 0;
    return num;
}
Date.prototype.Format = function(formatStr)   
{   
    var str = formatStr;   
    var Week = ['日','一','二','三','四','五','六'];  
  
    str=str.replace(/yyyy|YYYY/,this.getFullYear());   
    str=str.replace(/yy|YY/,(this.getYear() % 100)>9?(this.getYear() % 100).toString():'0' + (this.getYear() % 100));   
  
    str=str.replace(/MM/,this.getMonth()>8?(this.getMonth() + 1).toString():'0' + (this.getMonth() + 1));   
    str=str.replace(/M/g,this.getMonth()+1);   
  
    str=str.replace(/w|W/g,Week[this.getDay()]);   
  
    str=str.replace(/dd|DD/,this.getDate()>9?this.getDate().toString():'0' + this.getDate());   
    str=str.replace(/d|D/g,this.getDate());   
  
    str=str.replace(/hh|HH/,this.getHours()>9?this.getHours().toString():'0' + this.getHours());   
    str=str.replace(/h|H/g,this.getHours());   
    str=str.replace(/mm/,this.getMinutes()>9?this.getMinutes().toString():'0' + this.getMinutes());   
    str=str.replace(/m/g,this.getMinutes());   
  
    str=str.replace(/ss|SS/,this.getSeconds()>9?this.getSeconds().toString():'0' + this.getSeconds());   
    str=str.replace(/s|S/g,this.getSeconds());   
  
    return str;   
}   

function getBasePath() {
	var location = (window.location+'').split('/'); 
	var basePath = location[0]+'//'+location[2]+'/'+location[3]; 
	return basePath;
}

//对于存在basepath的页面，获取锚点
function GetMaoUrl(maoid) {
	return window.location.href + maoid;
}

(function($){  
    //备份jquery的ajax方法  
    var _ajax=$.ajax;  
      
    //重写jquery的ajax方法  
    $.ajax=function(opt){  
        //备份opt中error和success方法  
        var fn = {  
            error:function(XMLHttpRequest, textStatus, errorThrown){},  
            success:function(data, textStatus){}  
        }  
        if(opt.error){  
            fn.error=opt.error;  
        }  
        if(opt.success){  
            fn.success=opt.success;  
        }  
          
        //扩展增强处理  
        var _opt = $.extend(opt,{  
            error:function(XMLHttpRequest, textStatus, errorThrown){  
                //错误方法增强处理  
            	var txt = XMLHttpRequest.responseText;
            	if(txt.indexOf('error-page') != -1) {
                	window.document.write(txt);
                }
                fn.error(XMLHttpRequest, textStatus, errorThrown);  
            },  
            success:function(data, textStatus){  
                //成功回调方法增强处理  
                if((typeof(data) == 'string') && data.indexOf('error-page') != -1) {
                	window.document.write(data);  
                }
                fn.success(data, textStatus);  
            }  
        });  
        _ajax(_opt);  
    };  
})(jQuery);