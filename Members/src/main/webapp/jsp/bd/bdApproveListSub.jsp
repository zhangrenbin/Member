<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/authtaglib" prefix="a"%>
<c:forEach var="b" items="${p.resultList }">
	<tr>
		<td>
			${b.mCnname }
		</td>
		<td>
			${b.mAccount }
		</td>
		<td class="hidden-480">
			<fmt:formatDate value="${b.bDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
		<td class="hidden-480">
			${b.bRemark }
		</td>
		<td class="hidden-480">
			<fmt:formatDate value="${b.bApproveDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
		<td>
			<c:if test="${b.bState == 0 }">
				<a href="javascript:ok(${b.id })">[批 准]</a>&nbsp;
				<a href="javascript:reject(${b.id })">[驳 回]</a>
			</c:if>
			<c:if test="${b.bState < 0 }">
				<span class="red">驳回</span>
			</c:if>
			<c:if test="${b.bState > 0 }">
				<span class="green">通过</span>
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