<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; ccharset=UTF-8">
<title>Feeds</title>
<link href="<c:url value="resources/bootstrap/bootstrap.min.css" />"
	rel="stylesheet" />
<script src="resources/bootstrap/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h2>Add XML RSS Feed</h2>
		<h3>Please provide new XML RSS Feed information</h3>
		<div style="color:red;font-size:30;">
			<c:out value="${errorMessage}" />
		</div>
		<form:form method="POST" modelAttribute="feed">
			<table>
				<tr>
					<td><label for="name">XML RSS Feed URL: </label></td>
					<td><form:input path="url" id="url" /></td>
					<td><form:errors path="url" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="name">XML RSS Feed Name: </label></td>
					<td><form:input path="feedName" id="url" /></td>
					<td><form:errors path="feedName" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Add Feed" /></td>
				</tr>
			</table>
		</form:form>
		<a href="<c:url value='/feeds' />">Back to feeds</a>
	</div>
</body>
</html>