<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	try {
		ace.settings.check('main-container', 'fixed')
	} catch (e) {
	}
</script>
<div id="sidebar" class="sidebar                  responsive"
	data-sidebar="true" data-sidebar-scroll="true"
	data-sidebar-hover="true">
	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
	</script>

	<!-- /.sidebar-shortcuts -->

	<ul class="nav nav-list" style="top: 0px;" id="sys_menu">

	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>

	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
		// 菜单初始化
		$(function(){
			//var menuCode="${param._menuCode}";
			$.ajax({
			   type: "POST",
			   url: "menu/queryMenuTree.do?",
			   dataType:"json",
			   success: function(msg){
				   if(msg){
					   var htm='';
					   for(var i in msg){
						   htm+=getMenu(msg[i]);
					   }
					   $("#sys_menu").html(htm);
					   //$("li[menuCode='"+menuCode+"']").addClass('active').parents("li").addClass("active open");
				   }
			   },
			   error:function(error,info, e){ 
				    alert(info);
			   } 
		   });
		  // 获取菜单	
		  function getMenu(menu){
			  var htm=' <li class=""  menuCode="'+menu.menuCode+'" level="' + menu.menuLevel + '" icon="'+ menu.img + '">';
			  if(menu.subMenu){
				  htm+='<a href="#" class="dropdown-toggle" >';
			  }else{
				  htm+='<a href="'+handleUrl(menu)+'" target="iframepage" onclick="breadNav(this)">';
			  }
			  htm+='<i class="menu-icon fa '+ menu.img + '"></i> <span class="menu-text">'+menu.menuName+' </span>';
			  if(menu.subMenu){
				  htm+=' <b class="arrow fa fa-angle-down"></b>';
			  }else{
				  htm+=' <b class="arrow"></b>';
			  }
			  htm+=' </a>';
			  if(menu.subMenu){
				  htm+= getSubMenu(menu.subMenu);
			  }
			 htm+='</li>';
			 // 如果有下级菜单
			 return htm;
		  }	
		  
		  // 获取下级菜单
		  function getSubMenu(subMenu){
			  var htm=' <ul class="submenu">';
			  for(var i in subMenu){
				  var menu=subMenu[i];
				  if(menu.subMenu){
					  htm+='  <li class="" menuCode="'+menu.menuCode+'" level="' + menu.menuLevel + '" icon="'+ menu.img + '"><a href="'+handleUrl(menu)+'" class="dropdown-toggle" target="iframepage"> <i';
					  htm+='	class="menu-icon fa ' + menu.img + '"></i><span class="menu-text">'+ menu.menuName + '</span>';
					  htm+=' <b class="arrow fa fa-angle-down"></b>';
					  htm+=' </a>';
					  htm+=getSubMenu(menu.subMenu);
				  }else{
					  htm+='  <li class="" menuCode="'+menu.menuCode+'" level="' + menu.menuLevel + '" icon="'+ menu.img + '"><a href="'+handleUrl(menu)+'" target="iframepage" onclick="breadNav(this)"> <i';
					  htm+='	class="menu-icon fa ' + menu.img + '"></i><span class="menu-text">'+ menu.menuName + '</span>';
					  htm+='<b class="arrow"></b>';
					  htm+=' </a>';
				  }
			      htm+='</li> ';
			  }
			  htm+=' </ul>	';
			 return htm;
			 
		  }
		  
		  //处理链接
		  function handleUrl(menu){
			  var  realUrl=menu.navigateUrl;
			  if(!realUrl){
				  return "";
			  }
			  if(realUrl.lastIndexOf("?")>0){
				  realUrl=realUrl+"&_menuCode="+menu.menuCode;
			  }else{
				  realUrl=realUrl+"?_menuCode="+menu.menuCode; 
			  }
			  //${pageContext.request.contextPath}/
			  if(realUrl.startWith("http://") || realUrl.startWith("https://")) {
				  return realUrl;
			  }
			  return "${pageContext.request.contextPath}/" + realUrl;
		  }
			
		});
		
		function breadNav(o) {
			$(".breadcrumb").empty();
			//求取上层菜单
			var htm = '';
			var slevel = $(o).parent("li:eq(0)").attr("level");
			var ilevel = parseInt(slevel);
			for(var i = 0; i <= ilevel; i++) {
				var po = $(o).closest("li[level=" + i + "]");
				var name = $(po).children("a:eq(0)").children("span").html();
				if(i == 0) {
					var img = po.attr("icon");
					htm += '<li>' + 
						'<i class="ace-icon fa home-icon ' + img + '"></i>' + 
							'&nbsp;<span>' + name + '</span>' + 
						'</li>';
				} else {
					htm += '<li class="active">' + name + '</li>';
				}
			}
			$(".breadcrumb").append(htm);
		}
	</script>
</div>