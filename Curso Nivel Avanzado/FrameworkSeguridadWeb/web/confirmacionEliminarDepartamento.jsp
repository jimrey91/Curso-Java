<%-- 
    Document   : confirmacionEliminarDepartamento
    Created on : 10-09-2013, 12:09:45 AM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eliminar Departamento</title>
    </head>
    <body>
        <h1>Felicitaciones!</h1>
        <h2>El departamento ha sido eliminado satisfactoriamente.</h2>
        <p>Codigo Departamento: <bean:write name="ActionFormDepartamentos" property="codigoDepartamento" />.</p>
        <p>Nombre Departamento: <bean:write name="ActionFormDepartamentos" property="nombreDepartamento" />.</p>
        <html:link page="/mantenimientoDepartamentos.jsp">Regresar</html:link>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
