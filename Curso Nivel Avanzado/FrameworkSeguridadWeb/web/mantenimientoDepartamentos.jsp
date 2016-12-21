<%-- 
    Document   : mantenimientoDepartamentos
    Created on : 10-08-2013, 11:45:31 PM
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
    <title>Mantenimiento de Departamentos</title>
    </head>
    <body>
    <h2>Mantenimiento de Departamentos</h2>
    <html:form action="/mantenimientoDepartamentos">
        <table border="0">
        <tbody>
        <tr>
            <td>Codigo Departamento:</td>
            <td><html:text property="codigoDepartamento" size="5" maxlength="2"/></td>
        </tr>
        <tr>
            <td>Nombre Departamento</td>
            <td><html:text property="nombreDepartamento" size="50" maxlength="25"/></td>
        </tr>
        <tr>
            <td colspan="2">
            <bean:write name="ActionFormDepartamentos" property="error" filter="false"/>
            </td>
        </tr>
        </tbody>
        </table>
        <html:submit property="action" value="Nuevo"/>
        <html:submit property="action" value="Agregar"/>
        <html:submit property="action" value="Consultar"/>
        <html:submit property="action" value="Eliminar"/>
    </html:form>
    <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
