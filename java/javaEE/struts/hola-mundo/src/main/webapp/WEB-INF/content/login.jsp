<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="login.titulo"></s:text></title>
</head>
<body>
	<p>"Escribir sam para pasar validacion"</p>
	<s:form action="validarUsuario">
		<div>
			<s:text name="login.textoNombre" />
			<s:textfield name="usuario"></s:textfield>
		</div>
		<div>
			<s:text name="login.textoPassword" />
			<s:password name="password"></s:password>
		</div>
		<s:submit value="Validar credenciales" name="submit"></s:submit>
	</s:form>
</body>
</html>