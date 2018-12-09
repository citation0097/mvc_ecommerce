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
<c:if test="${empty sessionScope.id}">
	<div id="mList"><p> Login</div>
</c:if>
<c:if test="${!empty sessionScope.id }">
	<div id ="mList">
		<ul>
			<li>product work
			<li><button>Register</button>
			<li><button>Edit/Delete</button>
		</ul>
		<ul>
			<li>Purchased product
			<li><button>Entire List confirm</button>
		</ul>
		<ul>
			<li>Product QnA
			<li><button>Product QnA</button>
		</ul>
	</div>


</c:if>

</div>
</body>
</html>