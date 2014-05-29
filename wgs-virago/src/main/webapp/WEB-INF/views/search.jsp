<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!--%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Book Search</title>
<link href="//netdna.bootstrapcdn.com/bootswatch/3.1.1/spacelab/bootstrap.min.css" rel="stylesheet">
</head>
<body-->
 
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
	<div class="container theme-showcase">
		<div class="page-header">
			<h1>
				Book Search&nbsp;<small>find the book you need</small>
			</h1>
		</div>
		<div class="well bs-component">
			<form:form class="form-horizontal" modelAttribute="book" method="post">
				<fieldset>
					<div class="form-group">
						<label for="title" class="col-lg-2 control-label">Search Phrase</label>
						<div class="col-lg-10">
							<form:input type="text" class="form-control" id="title" path="title" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-10 col-lg-offset-2">
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-default">Reset</button>
						</div>
					</div>
				</fieldset>
			</form:form>
		</div>
	</div>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
    </tiles:putAttribute>
</tiles:insertDefinition>
	<!-- Include all compiled plugins (below), or include individual files as needed >
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
</body>
</html-->