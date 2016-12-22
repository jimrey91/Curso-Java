<%-- 
    Document   : form_rentaImponible
    Created on : 09-10-2013, 02:51:48 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Renta Imponible</title>
    </head>
    <body>
        <h1>Renta Imponible</h1>
        <form name="form" method="POST" action="procesa_rentaImponible.jsp">
                
        <table border="1">
            <tbody>
                <tr>
                    <td>No Nit:</td>
                    <td><input type="text" name="no_nit" value="" size="20"/></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" value="" size="50"/></td>
                </tr>
                <tr>
                    <td>Salario Anual:</td>
                    <td><input type="text" name="salario_anual" value="" size="8"/></td>
                </tr>
                <tr>
                    <td>Aguinaldo:</td>
                    <td><input type="text" name="aguinaldo" value="" size="8"/></td>
                </tr>
                <tr>
                    <td>Ingresos por Servicios: </td>
                    <td><input type="text" name="ingresos_servicios" value="" size="8"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Guardar" name="Guardar"/></td>
                    <td><input type="reset" value="Limpiar" name="Limpiar" name="Limpiar"/></td>
                </tr>
            </tbody>
        </table>
</form>
    </body>
</html>
