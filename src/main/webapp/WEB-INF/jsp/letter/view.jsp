<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판</title>
<script type="text/javascript">
	function confirmDelete() {
		if (confirm("삭제하시겠습니까?"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>편지 보기</h2>
	<p>
		<a href="./app/members">회원목록</a>
		<c:if test="${letter.receiverId == sessionScope.MEMBER.memberId }">
			<a href="./app/letter/delete?letterId=${letter.letterId }"
				onclick="return confirmDelete();">글삭제</a>
		</c:if>
	</p>
	<hr />
	<p>
		<span>${letter.letterId }</span> | <span style="font-weight: bold;">${letter.title }</span>
	</p>
	<p>
		<span>${letter.cdate }</span> | <span>${letter.receiverName }</span>
	</p>
	<hr />
	<p>${letter.contentHtml }</p>
	<hr />

</body>
</html>