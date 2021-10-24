<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:property value="titulo" /></title>
</head>
<body>
	<s:property value="textoNombre" />
	<s:property value="nombre" />
	
	<p/>
	Password:
	<s:property value="password" />
	
	<s:form>
		<s:textfield name="nombre"></s:textfield>
		<s:password name="password"></s:password>
		<s:submit key="persona.valorBoton" name="submit"></s:submit>
	</s:form>
</body>
</html>