<!doctype hmtl>
<html>
<head>
<title>Java Web Programming: 404 - Page Not Found</title>
<meta name="description" content="JSP that demostrates a 404 response page for when a page is not found.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div id="wrapper">
		<div class="container">
			<h1>404 - Sorry :(</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div>
			<p>This is not the page you were looking for.</p>
			<p>To continue, click the Back button.</p>
		</div>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
	<p>This is not the page you were looking for.</p>
	<p>To continue, click the Back button.</p>
</body>
</html>