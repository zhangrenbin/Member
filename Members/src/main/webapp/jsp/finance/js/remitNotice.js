var daterangOpt = {  
   	startDate: moment().subtract('days', 1),
    endDate: moment(),  
    maxDate : moment(), //最大时间   
    dateLimit : {  
        days : 30  
    }, //起止时间的最大间隔  
    showDropdowns : true,  
    showWeekNumbers : false, //是否显示第几周  
    timePicker : true, //是否显示小时和分钟  
    timePickerIncrement : 60, //时间的增量，单位为分钟  
    timePicker12Hour : false, //是否使用12小时制来显示时间  
    showCustomRangeLabel:false,
    /*ranges : {  
        //'最近1小时': [moment().subtract('hours',1), moment()],  
        '今日': [moment().startOf('day'), moment()],  
        '昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],  
        '最近7日': [moment().subtract('days', 6), moment()],  
        '最近30日': [moment().subtract('days', 29), moment()]  
    },*/  
    opens : 'right', //日期选择框的弹出位置  
    buttonClasses : [ 'btn btn-default' ],  
    applyClass : 'btn-small btn-primary blue',  
    cancelClass : 'btn-small',  
    format : 'YYYY-MM-DD HH:mm:ss', //控件中from和to 显示的日期格式  
    separator : ' - ',  
    locale : {  
        applyLabel : '确定',  
        cancelLabel : '取消',  
        fromLabel : '起始时间',  
        toLabel : '结束时间',  
        customRangeLabel : '自定义',  
        daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],  
        monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',  
                '七月', '八月', '九月', '十月', '十一月', '十二月' ],  
        firstDay : 1  
    }  
}
var pageSize=10;
var currPage = 1;
var start = 1;
$("#remitFrm").validate({
	rules: {
		rBAccount: {
			required: true,
			rangelength:[16,19]
		},
		rBName: {
			required: true
		},
		rMoney: {
			required: true,
			number:true,
			min:0,
			max:99999999
		},
		rRemark: {
			required: true,
			maxlength:200
		}
	}
});

$(document).ready(function(){
	var singleOpt = $.extend({timePicker : true,singleDatePicker:true},daterangOpt);
	$('.date-picker').daterangepicker(singleOpt, function(start, end, label) {//格式化日期显示框  
	    $('.date-picker').val(start.format('YYYY-MM-DD HH:mm:ss'));  
	}); 
	var startDateStr =  moment().format("YYYY-MM-DD HH:mm:ss");
    $('#rTime').val(startDateStr); 
    $("#remitBtn").click(function() {
    	if(!$("#remitFrm").valid()) {
    		return;
    	}
    	var pa =$("#remitFrm").serialize();
    	ajaxs("finance/f_remit_notice/sub.do","post",pa,true,function(data){
			if(data.success == "true") {
				loadMyRemit(currPage);
				Alerts.alert("提交成功");
				$("#remitFrm")[0].reset();
				return;
			}
			Alerts.alert(data.msg);
    	});
    });
    loadMyRemit();
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
            	loadMyRemit(currPage);
            }  
        }
    });
}

function loadMyRemit(page, rows) {
	if(!arguments[0]) {
		page = start;
	}
	if(!arguments[1]) {
		rows = pageSize;
	}
	ajaxs("finance/f_remit_notice/list.do?page=" + page + "&rows=" + rows,"get",{},true,function(data){
		if(data) {
			$("#remitBody").html(data);
		}
	},"html");
}

