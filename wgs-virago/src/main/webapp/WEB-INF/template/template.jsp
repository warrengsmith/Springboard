<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Default tiles template</title>
</head>
<body>
	<div>
		<tiles:insertAttribute name="header" />
		<div>
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
</body>
</html>