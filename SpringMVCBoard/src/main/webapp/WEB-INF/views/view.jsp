<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringMVCBoard</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="modify" method="post">
			<input type="hidden" name="seq" value="${view.seq}">
			<tr>
				<td> ID </td>
				<td> <input type="text" name="id" value="${view.id}"></td>
			</tr>
			<tr>
				<td> TITLE </td>
				<td> <input type="text" name="title" value="${view.title}"></td>
			</tr>
			<tr>
				<td> CONTENT </td>
				<td> <textarea rows="10" name="content" >${view.content}</textarea></td>
			</tr>
			<tr >
				<td colspan="2"> <input type="submit" value="MODIFY">
				&nbsp;&nbsp; <a href="list">LIST</a> 
				&nbsp;&nbsp; <a href="delete?seq=${view.seq }">DELETE</a></td>
			</tr>
		</form>
	</table>
	
</body>
</html>