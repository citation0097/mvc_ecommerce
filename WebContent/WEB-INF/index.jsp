<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div >
	<c:if test="${type ==0}">
		<jsp:include page = "manager/mgrloginForm.jsp"/>
	</c:if>
    <c:if test="${type ==1}">
		<jsp:include page ="member/loginForm.jsp"/>
	</c:if>

</div>
<div>
	<jsp:include page="${cont }"></jsp:include>
</div>
</body>
</html>