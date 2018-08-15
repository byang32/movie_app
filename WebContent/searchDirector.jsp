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
			<h1>Director Search</h1>
		</div>
		<%@ include file="includes/navigation.jsp" %>
		<div id="formCenter">
		<br>
			<form action="SearchDirector" method="post">
			<label for="director"><strong>Search by Director: </strong></label>
			<input name="director">
			<input type="submit" value="Search!">
			</form>
		</div>
		<%@ include file="includes/footer.jsp" %>
	</div>
	<%@ include file="includes/scripts.jsp" %>
</body>
</html>