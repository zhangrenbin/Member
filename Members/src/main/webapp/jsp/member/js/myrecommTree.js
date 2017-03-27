$(document).ready(function(){
	$(".memb").click(function() {
		var id = $(this).data("val");
		searchTree(id);
	});
	if($(".memb:eq(0)").length > 0) { 
		$(".memb:eq(0)").click();
	} else {
		searchTree(0)
	}
});

function searchTree(id) {
	ajaxs("memb/f_recomm_tree/search.do","post",{id:id},true,function(data) {
		if(data) {
			makeTree(data);
		}
	});
}

function makeTree(data) {
	 var chartdata = doChartData(data);
	 var myChart = echarts.init($("#recommTree")[0]); 
	 option = {
	    title : {
	        text: '推荐树图'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter:function(p) {
        		return "会员姓名：" + p["2"].name + "<br>" +
        			"会员账号：" + p["2"].account + "<br>" + 
        			"推荐人：" + p["2"].recommer;
        	}
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            saveAsImage : {show: true}
	        }
	    },
	    calculable : false,
	    series : [
	        {
	            name:'推荐关系图图',
	            type:'tree',
	            orient: 'vertical',  // vertical horizontal
	            rootLocation: {x: '50%', y: 100}, // 根节点位置  {x: 'center',y: 10}
	            nodePadding: 20,
	            symbol: 'circle',
	            symbolSize: 60,
	            roam: true,
	            itemStyle: {
	                normal: {
	                	color: '#4883b4',
	                    label: {
	                        show: true,
	                        position: 'inside',
	                        textStyle: {
	                            color: 'white',
	                            fontSize: 15,
	                            fontWeight:  'bolder'
	                        }
	                    },
	                    lineStyle: {
	                        color: '#000',
	                        width: 1,
	                        type: 'broken' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
	                    }
	                },
	                emphasis: {
	                    label: {
	                        show: true
	                    }
	                }
	            },
	            data: chartdata
	        }
	    ]
	};
	myChart.setOption(option);
}

function doChartData(mt) {
	var chartdata = [];
	if(mt == null) {
		return chartdata;
	}
	var item = {};
	item.name = mt.membName;
	item.account = mt.membAccount;
	item.recommer = mt.recommerName;
	item.recommerAccount = mt.recommerAccount;
	item.children= [];
	var c1 = doChartData(mt.leftChild);
	if(c1.length > 0) {
		item.children.push(c1[0]);
	}
	var c2 = doChartData(mt.rightChild);
	if(c2.length > 0) {
		item.children.push(c2[0]);
	}
	chartdata.push(item);
	return chartdata;
}

function doSubmit() {
	$("#searchFrm").submit();
}