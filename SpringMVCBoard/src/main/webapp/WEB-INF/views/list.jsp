<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVCBoard</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>Seq</td>
			<td>Writer</td>
			<td>Title</td>
			<td>Date</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td>${dto.id}</td>
			<td><a href="view?seq=${dto.seq}">${dto.title}</a></td>
			<td>${dto.date}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="4"> <a href="write_view">write</a> </td>
		</tr>
	</table>
</body>
</html>