<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
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
		<h2>XML RSS Feed</h2>
		<p>Please find the list of all available feeds</p>
		<br /> <br /> <a href="<c:url value='/newfeed' />">Add New Feed</a>
		<br /> <br />
		<table class="table">
			<tbody>
				<c:forEach items="${feeds}" var="feed">
					<tr>
						<td><a href="<c:url value='/feed-details-${feed.id}' />">${feed.url}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>