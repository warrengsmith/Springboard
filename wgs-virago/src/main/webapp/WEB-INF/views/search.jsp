<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Book Search</title>
<link
	href="//netdna.bootstrapcdn.com/bootswatch/3.1.1/spacelab/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<br />
	<br />
	<div class="container theme-showcase">
		<img src="<c:url value="/resources/images/virago_banner.jpg" />"
			alt="Virago Logo" />
		<div class="page-header">
			<h1>
				Book Search&nbsp;<small>find the book you need</small>
			</h1>
		</div>
		<form:form modelAttribute="book" method="post">
			<div class="form-group">
				<label for="title">Partial title</label>
				<form:input type="text" class="form-control" id="title" path="title" />
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
			<button type="reset" class="btn btn-default">Reset</button>
		</form:form>
	</div>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
</body>
</html>