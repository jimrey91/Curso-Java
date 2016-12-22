<%-- 
    Document   : form_contribuyentes
    Created on : 09-02-2013, 07:12:35 PM
    Author     : Daniel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicion de Contribuyentes</title>
    </head>
    <body>
        <h1>Adicion de Contribuyentes</h1>
                <form name="Form1" action="procesa_contribuyentes.jsp" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nit Contribuyente</td>
                        <td><input type="text" name="no_nit" value="" size="18" /></td>
                    </tr>
                    <tr>
                        <td>Nombre Contribuyente</td>
                        <td><input type="text" name="nombre_contribuyente" value="" size="65" /></td>
                    </tr>
                    <tr>
                        <td>Razon Social</td>
                        <td><input type="text" name="razon_social" value="" size="200" /></td>
                    </tr>
                    <tr>
                        <td>Representante Legal</td>
                        <td><input type="text" name="representante_legal" value="" size="65" /></td>
                    </tr>
                    <tr>
                        <td>Renta Anual</td>
                        <td><input type="text" name="renta_anual" value="" size="10" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Guardar" name="Guardar" />
                            <input type="reset" value="Limpiar" name="Limpiar" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
