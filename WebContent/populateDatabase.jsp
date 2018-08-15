<!doctype hmtl>
<html>
<head>
<title>Java Web Programming: Populate Database</title>
<meta name="description" content="Jsp file that submits a form to the database.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div id="wrapper">
		<div>
			<h1>Search</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div id="formCenter">
		<br>
		<form action="PopulateDatabase" method="post">
			<p>Click on the populate button to populate the person database.</p>
			<p>Warning: Submitting this form will reset the database and it will
			only contain those people in the original spreadsheet!</p>
			<input type="submit" value="Populate!">
			</form>
		</div>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
</html>