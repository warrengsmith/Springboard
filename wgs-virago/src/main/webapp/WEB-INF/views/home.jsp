<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<br />
	<br />
	<div class="container theme-showcase">
		<div class="jumbotron">
			<h1>Hello world!</h1>
			<p>The time on the server is ${serverTime}.</p>
		</div>
		<div class="page-header">
			<h1>Created with Spring MVC and Bootstrap!</h1>
		</div>
	</div>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
</body>
</html>
