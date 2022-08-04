<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Persona objeto complejo</title>
</head>
<body>
	<s:property value="persona.nombre" />
	<p/>
	<s:property value="persona.direccion.ciudad" />
	<p/>
	<s:property value="persona.direccion.calle" />
	<p/>
	<s:form>
		<s:textfield label="Nombre" name="persona.nombre"></s:textfield>
		<s:textfield label="Ciudad" name="persona.direccion.ciudad"></s:textfield>
		<s:textfield label="Calle" name="persona.direccion.calle"></s:textfield>
		<s:submit value="Enviar"></s:submit>
	</s:form>
</body>
</html>