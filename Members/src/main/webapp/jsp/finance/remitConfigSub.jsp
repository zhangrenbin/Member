<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/authtaglib" prefix="a"%>
<c:forEach var="r" items="${p.resultList }">
	<tr>
		<td class="hidden-480">
			${r.extendPro.membName }
		</td>
		<td>
			${r.extendPro.membAccount }
		</td>
		<td>
			${r.rMoney }
		</td>
		<td>
			${r.rBAccount }
		</td>
		<td class="hidden-480">
			<fmt:formatDate value="${r.rTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
		<td class="hidden-480">
			${r.extendPro.bdName } / ${r.extendPro.bdAccount }
		</td>
		<td class="hidden-480">
			${r.rRemark }
		</td>
		<td class="hidden-480">
			<c:if test="${empty r.rState || r.rState == 0}">
				<span class="blue">${r.extendPro.stateStr }</span>
			</c:if>
			<c:if test="${!empty r.rState && r.rState < 0}">
				<span class="red">${r.extendPro.stateStr }</span>
			</c:if>
			<c:if test="${!empty r.rState && r.rState > 0}">
				<span class="green">${r.extendPro.stateStr }</span>
			</c:if>
		</td>
		<td>
			<c:if test="${empty r.rState || r.rState == 0}">
				<a href="javascript:remitConfig(${r.id })">[确 认]</a>&nbsp;
				<a href="javascript:remitReject(${r.id })">[驳 回]</a>
			</c:if>
			<c:if test="${!empty r.rState && r.rState > 0 && !empty r.extendPro.membActive && r.extendPro.membActive < 1}">
				<span>会员未激活</span>
				<br/>
				<a href="javascript:membActive(${r.rFromUser })">[激 活]</a>
			</c:if>
			
		</td>
	</tr>
</c:forEach>
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