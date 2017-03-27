<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/authtaglib" prefix="a"%>
<c:forEach var="r" items="${p.resultList }">
	<tr>
		<td>
			${r.membName }
		</td>
		<td>
			${r.membAccount }
		</td>
		<td class="hidden-480">
			<fmt:formatDate value="${r.rTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
		<td>
			${r.rMoney }
		</td>
		<td class="hidden-480">
			${r.rDesc }
		</td>
		<td>
			<c:if test="${empty god }">
				<c:if test="${empty r.rPoint || r.rPoint == '0'}">
					<a href="javascript:baodan(${r.id })">[报 单]</a>
				</c:if>
				<c:if test="${!empty r.rPoint && r.rPoint == '1'}">
					<span>已报单</span>
				</c:if>
				<c:if test="${!empty r.rPoint && r.rPoint == '2'}">
					<span>已处理</span>
				</c:if>
			</c:if>
			<c:if test="${!empty god }">
				<c:if test="${empty r.rPoint || r.rPoint == '0'}">
					<span>未报单</span>
				</c:if>
				<c:if test="${!empty r.rPoint && r.rPoint == '1'}">
					<a href="javascript:chuli(${r.id })">[处 理]</a>
				</c:if>
				<c:if test="${!empty r.rPoint && r.rPoint == '2'}">
					<span>已处理</span>
				</c:if>
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