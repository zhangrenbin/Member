<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/authtaglib" prefix="a"%>
<c:forEach var="r" items="${p.resultList }">
	<tr>
		<td>
			<fmt:formatDate value="${r.rTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
		</td>
		<td>
			${r.rBAccount }
		</td>
		<td class="hidden-480">
			${r.rBName }
		</td>
		<td>
			${r.rMoney }
		</td>
		<td class="hidden-480">
			${r.extendPro.bdName } / ${r.extendPro.bdAccount }
		</td>
		<td class="hidden-480">
			${r.rRemark }
		</td>
		<td>
			${r.extendPro.stateStr }
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