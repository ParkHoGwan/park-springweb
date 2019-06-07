<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!-- 회원 목록 -->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>회원 목록</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>회원 목록</h2>
	<p>전체 ${totalCount }건</p>
	<form action="./app/members">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 100 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
	</form>
	<table>
		<thead>
			<tr>
				<td>회원번호</td>
				<td>이메일</td>
				<td>이름</td>
				<td>등록일시</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${members}">
				<tr>
					<td>${member.memberId }</td>
					<td>${member.email }</td>
					<td>${member.name }</td>
					<td>${member.cdate }</td>
					<td><a
						href="./app/letter/form?receiverId=${member.memberId }&receiverName=${member.name }">편지쓰기</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>