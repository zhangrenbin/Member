<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/authtaglib" prefix="a"%>
<div id="profile-feed-1" class="profile-feed">
	<c:forEach var="m" items="${p.resultList }">
		<div class="profile-activity clearfix">
			<div>
				<div>
					<img class="pull-left" alt="无照片" style="max-width:40px; width: 40px;height: 40px" 
						src="ace/assets/avatars/avatar5.png" />
					<div class="col-sm-2">
						<a class="user" href="memb/f_memb_detail.do?id=${m.id }"><h5>${m.mAccount }</h5> </a>
						<h5>${m.mCnname }</h5>
					</div>
					<div class="col-sm-2">
						<h5>${m.mMobile }</h5>
					</div>
					<div class="col-sm-2">
						<c:if test="${empty m.mActive || m.mActive < 1}">
							<h5 class="red">${m.extendPro.activeStr }</h5>
							<a:auth funccode="memb_active">
								<!-- 有激活会员的权限 -->
								<a href="javascript:activeMemb(${m.id})">&nbsp;&nbsp;[激 活]</a>
							</a:auth>
						</c:if>
						<c:if test="${m.mActive > 0}">
							<h5 class="green">${m.extendPro.activeStr }</h5>
						</c:if>
					</div>
					<div class="col-sm-2 time">
						<i class="ace-icon fa fa-clock-o bigger-110"></i>
						注册日期:&nbsp;
						<br>
						<fmt:formatDate value="${m.mRegdate }" pattern="yyyy-MM-dd HH:mm:ss"/>
					</div>
					<div class="col-sm-2 time">
						<i class="ace-icon fa fa-clock-o bigger-110"></i>
						激活日期:&nbsp;
						<br>
						<fmt:formatDate value="${m.mActivedate }" pattern="yyyy-MM-dd HH:mm:ss"/>
					</div>
				</div>
			</div>
			<div class="tools action-buttons">
				<a:auth funccode="memb_detail">
					<!-- 查看会员详情的权限 -->
					<a href="memb/f_memb_detail.do?id=${m.id }" class="blue" title="会员详情">
						<i class="ace-icon fa fa-info-circle bigger-125"></i>
					</a>
				</a:auth>
				<a:auth funccode="memb_edit">
					<a title="重置密码" href="javascript:resetPasswordDlg('${m.mAccount }')">
						<i class="bigger-120 ace-icon fa fa-shield"></i>
					</a>
				</a:auth>
				<!-- 
				<a:auth funccode="memb_del">
					<a href="javascript:deleteMemb(${m.id })" class="red" title="删除">
						<i class="ace-icon fa fa-times bigger-125"></i>
					</a>
				</a:auth>
				 -->
			</div>
		</div>
	</c:forEach>
</div>
<c:choose>
	<c:when test="${!empty p.resultList && p.pageCount > 1}">
		<script type="text/javascript">
			$("#pagetool").show();
			updatePager(${p.pageCount},${p.curPageNum},${p.totalSize});
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			$("#pagetool").hide();
		</script>
	</c:otherwise>
</c:choose>