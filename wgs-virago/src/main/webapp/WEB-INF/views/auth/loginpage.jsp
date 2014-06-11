<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container theme-showcase">
		<div class="page-header">
			<h1>Login</h1>
			<div id="login-error">${error}</div>
		</div>
		<div class="panel panel-primary">
			<form:form class="form-horizontal"  action="../../j_spring_security_check" method="post">
				<p>
					<label class="col-lg-2 control-label" for="j_username">Username</label> <input class="form-control" id="j_username" name="j_username" type="text" />
				</p>
				<p>
					<label class="col-lg-2 control-label" for="j_password">Password</label> <input class="form-control" id="j_password" name="j_password" type="password" />
				</p>
				<input class="btn btn-primary" type="submit" value="Login" />
			</form:form>
		</div>
	</div>
</body>
</html>