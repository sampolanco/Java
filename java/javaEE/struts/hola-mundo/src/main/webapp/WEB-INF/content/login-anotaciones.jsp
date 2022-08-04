<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login usando anotaciones</title>
<s:head />
</head>
<body>
	<s:actionerror />
	<p>"Escribir sam para pasar validacion"</p>
	<s:form action="validarUsuarioAnotaciones">
		<div>
			Nombre
			<s:textfield name="usuario"></s:textfield>
		</div>
		<div>
			Password
			<s:password name="password"></s:password>
		</div>
		<s:submit value="Validar credenciales" name="submit"></s:submit>
	</s:form>
</body>
</html>