<!doctype hmtl>
<html>
<head>
<title>Java Web Programming: Success</title>
<meta name="description" content="JSP that demostrates a Success response page for when a page is succesful in performing actions.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div id="wrapper">
		<div class="container">
			<h1>Success</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div>
			<p>${message}</p>
		</div>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>