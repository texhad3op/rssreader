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
	<div class="container">
		<a href="<c:url value='/feeds' />">Back to feeds</a>
		<h2>Selected feed</h2>
		<table>
			<tr>
				<td>Feed name:</td>
				<td><c:out value="${feed.feedName}" /></td>
			</tr>
			<tr>
				<td>URL address:</td>
				<td><c:out value="${feed.url}" /></td>
			</tr>
			<tr>
				<td>Update time and date:</td>
				<td><c:out value="${feed.lastUpdate}" /></td>
			</tr>
			<tr>
				<td>Article count:</td>
				<td><c:out value="${itemsCount}" /></td>
			</tr>
		</table>
		<h2>5 Most recent articles:</h2>
		<table class="table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Url</th>
					<th>UpdateTime</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.title}</td>
						<td><a href="${item.link}" target="_blank">${item.link}</a></td>
						<td>${item.published}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>