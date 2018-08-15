<!doctype hmtl>
<html>
<head>
<title>Java Web Programming: Search</title>
<meta name="description" content="Movies application showing the title, director and length of the movies.">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
	<div id="wrapper">
		<div>
			<h1>Title Search</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div id="formCenter">
		<br>
		<form action="Search" method="post">
			<label for="title"><strong>Search by Title: </strong></label>
			<input name="title">
			<input type="submit" value="Search!">
			</form><br><br>
		</div>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
</html>