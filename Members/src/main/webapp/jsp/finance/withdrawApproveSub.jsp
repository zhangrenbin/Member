<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/authtaglib" prefix="a"%>
<c:forEach var="w" items="${p.resultList }">
	<tr>
		<td>
			${w.membName }
			<br/>
			(${w.membAccount })
		</td>
		<td class="hidden-480">
			<fmt:formatDate value="${w.txDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
		<td>
			${w.txMoney }
		</td>
		<td>
			${w.txBAccount }
		</td>
		<td class="hidden-480">
			${w.txBName }
		</td>
		<td class="hidden-480">
			${w.txBank }
		</td>
		<td class="hidden-480">
			${w.txRemark }
		</td>
		<td class="hidden-480">
			<c:if test="${w.state == 0}">
				<span class="blue">未处理</span>
			</c:if>
			<c:if test="${w.state == 2}">
				<span class="red">驳回</span>
			</c:if>
			<c:if test="${w.state == 1}">
				<span class="green">已打款</span>
			</c:if>
		</td>
		<td class="hidden-480">
			${w.doMsg }
		</td>
		<td>
			<c:if test="${w.state == 0}">
				<a href="javascript:ok(${w.id })">[完成打款]</a>
				<br>
				<a href="javascript:reject(${w.id })">[驳回]</a>
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